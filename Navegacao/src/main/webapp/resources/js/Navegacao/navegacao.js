var Navigation = function(navigationMap, mapObjects) {
	var self = this, player = navigationMap.startingPoint, footstepAudio = '/resources/audio/footsteps-cut.wav', collisionsAudio = '/resources/audio/collisions.mp3',left = '/resources/audio/beep_left.wav',right = '/resources/audio/beep_right.wav' , mapObjects = mapObjects, lastBumpedObject = null, timerNavigation = new Timer(), isNavigationStopped = false, isNavigationFinished = false, navigationHistory = new NavigationHistory(), isBlocked = false, confirmClose = false, confirmSaveHistory = false, startTime = "", time = "";

	DirectionEnum = {
			UP : 1,
			DOWN : 2,
			LEFT : 3,
			RIGHT : 4,

			getTextDirection : function(direction) {
				var text = "";
				switch (direction) {
				case DirectionEnum.UP:
					text = "Norte";
					break;
				case DirectionEnum.DOWN:
					text = "Sul";
					break;
				case DirectionEnum.LEFT:
					text = "Oeste";
					break;
				case DirectionEnum.RIGHT:
					text = "Leste";
					break;
				default:
					text = "Norte";
				}
				return text;
			}
	}, offset = {
			top : player.data("coord-y") * navigationMap.scale,
			left : player.data("coord-x") * navigationMap.scale
	};

	player.data({
		"coord-z" : navigationMap.maxZ + 1
	});

	self.init = function() {
		console.log("Iniciando a navegação!");
		var log = getInitLog();
		navigationHistory.logInit(log);
		startTime = getTextTime();
		timerNavigation.start();
	}

	self.walk = function(forcedDirection) {
		if (!checkIsNavigationStoppedOrFinished()) {
			console.log("self.walk");
			var rotate = player.data("rotate"), coordZ = navigationMap.maxZ + 1, audio, nextOffset = {
				top : offset.top,
				left : offset.left
			};
			var logDown = false;
			if (forcedDirection) {
				self.direction = forcedDirection;
				logDown = true;
			} else {
				self.direction = checkDirection(rotate);
			}

			switch (self.direction) {
			case DirectionEnum.UP:
				offset = {
					top : offset.top - 32,
					left : offset.left
			};
				break;
			case DirectionEnum.DOWN:
				offset = {
					top : offset.top + 32,
					left : offset.left
			};
				break;
			case DirectionEnum.LEFT:
				offset = {
					top : offset.top,
					left : offset.left - 32
			};

				break;
			case DirectionEnum.RIGHT:
				offset = {
					top : offset.top,
					left : offset.left + 32
			};
				break;
			default:
				offset = {
					top : offset.top - 32,
					left : offset.left
			};

			}
			var hasObject = false;

			hasObject = checkCollisions(offset);

			if (!hasObject) {
				playIconicAudio(footstepAudio);
				navigationMap.moveObj(player, offset, rotate);
				if(!logDown){
					navigationHistory.logWalkUp(DirectionEnum.getTextDirection(self.direction));
				}else{
					navigationHistory.logWalkDown();
				}
				var finishedNavigation = false;
				finishedNavigation = checkEndPoint(offset);
				if(finishedNavigation){
					isBlocked = true;
					timerNavigation.pause();
					askToSaveNavigationHistory(true);
				}

			} else {
				playIconicAudio(collisionsAudio);
				hasObject = false;
				offset = {
						top : nextOffset.top,
						left : nextOffset.left
				};
				navigationHistory.logCollision(lastBumpedObject);
			}
		}
	}

	self.down = function() {
		if (!checkIsNavigationStoppedOrFinished()) {
			var direction = checkOppositeDirection(player.data("rotate"));
			self.walk(direction);
		}
	}

	self.rotateLeft = function() {
		if (!checkIsNavigationStoppedOrFinished()) {
			navigationMap.rotateObjectAction(player,
					navigationMap.DirectionEnum.LEFT);
			var rotate = player.data("rotate"),
			direction = checkDirection(rotate);
			playIconicAudio(left);
			navigationHistory.logChangeDirection(DirectionEnum.getTextDirection(direction));
		}
	}

	self.rotateRight = function() {
		if (!checkIsNavigationStoppedOrFinished()) {
			navigationMap.rotateObjectAction(player,
					navigationMap.DirectionEnum.RIGHT);
			var rotate = player.data("rotate"),
			direction = checkDirection(rotate);
			playIconicAudio(right);
			navigationHistory.logChangeDirection(DirectionEnum.getTextDirection(direction));
		}
	}

	self.getAroundObjects = function() {
		if (!checkIsNavigationStoppedOrFinished()) {
			navigationHistory.logActions("ALT R", "Objetos ao seu redor");
			var currentPos = {
					y : player.data("coord-y"),
					x : player.data("coord-x")
			}, objects = [];

			objects.push(getObjectByCoordinated(currentPos.x, (currentPos.y - 1))); // UP
			objects.push(getObjectByCoordinated((currentPos.x + 1), currentPos.y)); // RIGHT
			objects.push(getObjectByCoordinated(currentPos.x, (currentPos.y + 1))); // DOWN
			objects.push(getObjectByCoordinated((currentPos.x - 1), currentPos.y)); // LEFT

			var directions = ["Norte", "Leste", "Sul", "Oeste"];
			var i, length = objects.length, textToSpeech = "";
			for (i = 0; i < length; i++) {
				if (objects[i] !== null && objects[i] !== undefined) {
					textToSpeech += toStringObject(objects[i], directions[i]);
				}
			}
			if(!textToSpeech){
				textToSpeech = "Não existe nenhum objeto ao seu redor!";
			}
			playTextToSpeech(textToSpeech);
		}
	}

	self.getInfoMap = function() {
		if (!checkIsNavigationStoppedOrFinished()) {
			navigationHistory.logActions("ALT M", "Informações do mapa");
			var nomeMapa = document.getElementById("nomeMapa").value, descricaoMapa = document
			.getElementById("descricaoMapa").value, objetivoMapa = document
			.getElementById("objetivoMapa").value, andarMapa = document
			.getElementById("andarMapa").value, descricaoTipoMapa = document
			.getElementById("descricaoTipoMapa").value;

			var textToSpeech = "O mapa " + nomeMapa + ", do tipo " + descricaoTipoMapa +", está no " + andarMapa
			+ " pavimento.  A descrição do mapa é " + descricaoMapa
			+ ". E O objetivo é " + objetivoMapa;
			console.log(textToSpeech);
			playTextToSpeech(textToSpeech);
		}
	}

	self.getCurrentLocation = function() {
		if (!checkIsNavigationStoppedOrFinished()) {
			navigationHistory.logActions("ALT O", "Localização atual do jogador");
			var posX = player.data("coord-x") + 1;
			posY = player.data("coord-y") + 1, rotate = player.data("rotate"),
			direction = checkDirection(rotate),
			textDirection = DirectionEnum.getTextDirection(direction);

			var textToSpeech = "Estou na linha " + posY + ", coluna "
				+ posX + ". Virado para o " + textDirection + ".";

			console.log(textToSpeech);

			playTextToSpeech(textToSpeech);
		}
	}

	self.getLastBumpedObject = function() {
		if (!checkIsNavigationStoppedOrFinished()) {
			navigationHistory.logActions("ALT C", "Informações do último objeto colidido");
			if(lastBumpedObject){
				describeObject(lastBumpedObject, "Último objeto colidido foi ");
			}else{
				var textToSpeech = "Você não colidiu com nenhum objeto ainda!";
				playTextToSpeech(textToSpeech);
			}
		}
	}

	self.getTimerNavigation = function() {
		if(!checkIsNavigationFinished()){
			navigationHistory.logActions("ALT T", "Informações do tempo de navegação");
			var textToSpeech = timerNavigation.getTimeValues().toString();
			textToSpeech = "Tempo de navegação: " + textToSpeech;
			console.log(textToSpeech);
			playTextToSpeech(textToSpeech);
		}
	}

	self.playPauseTextToSpeech = function() {
		if (!checkIsNavigationStoppedOrFinished()) {
			navigationHistory.logActions("ALT P", "Pausar e Retomar áudio dos textos");
			var audioTextToSpeech = $('audio').get(0);
			if (!audioTextToSpeech.paused) {
				audioTextToSpeech.pause();
				pauseTextToSpeech();
			}else{
				resumeTextToSpeech();
			}
		}
	}

	self.resumeStopNavigation = function() {
		if(!checkIsNavigationFinished()){
			navigationHistory.logActions("ALT S", "Pausar e Retomar a navegação");
			var timer = timerNavigation.getTimeValues().toString(), textToSpeech = "";
			
			if (!isNavigationStopped) {
				timerNavigation.pause();
				isNavigationStopped = true;
				console.log(time);
				time = getTextTime();
				
				textToSpeech = "Navegação pausada " + time
				+ ". Para retomar a navegação, tecle Alt S.";
				console.log(textToSpeech);
				playTextToSpeech(textToSpeech);

			} else {
				timerNavigation.start();
				isNavigationStopped = false;
				time = getTextTime();
				textToSpeech = "Navegação retomada " + time + ".";
				console.log(textToSpeech);
				playTextToSpeech(textToSpeech);
			}
		}
	}

	self.playLog = function() {
		if (!checkIsNavigationStoppedOrFinished()) {
			navigationHistory.logActions("ALT L", "Reproduzir o log da navegação");
			var log = navigationHistory.history.log;
			console.log(log);
			playTextToSpeech(log);
		}
	}

	self.askToCloseNavigation = function() {
		if(!checkIsNavigationFinished()){
			navigationHistory.logActions("ALT Q", "Encerrar a navegação");
			var textToSpeech = "Você tem certeza que deseja encerrar a navegação? Tecle S para sim ou N para não.";
			playTextToSpeech(textToSpeech);
			confirmClose = true;
			confirmSaveHistory = false;
			isBlocked = true;
		}
	}
	
	self.yes = function() {
		if(isBlocked &&(confirmClose || confirmSaveHistory)){
			playTextToSpeech("Sim");
			navigationHistory.logActions("S", "Sim");
			if(confirmClose){
				closeNavigation();
			}else if(confirmSaveHistory){
				saveNavigationHistory();
			}
		}
	}

	self.no = function() {
		if(isBlocked &&(confirmClose || confirmSaveHistory)){
			playTextToSpeech("Não");
			navigationHistory.logActions("N", "Não.");
			isBlocked = false;
			if(confirmClose){
				isNavigationFinished = false;
			}
		}
	}
	
	self.playKeyboardShortcuts = function() {
		var url = '/resources/audio/Soar-teclas-navegacao-ggz.mp3';
		playIconicAudio(url);
	}

	function closeNavigation() {
		isNavigationFinished = true;
		timerNavigation.pause();
		var endTime = getTextTime();

		var nomeMapa = document.getElementById("nomeMapa").value;
		var text =" Log de navegação do mapa " + nomeMapa +". Data: " + getTextDate() + " . Iniciou " + startTime +" e finalizou " + endTime + ". Duração da navegação " + timerNavigation.getTimeValues().toString();  
		navigationHistory.logFinishedNavigation(player, text);
		askToSaveNavigationHistory(false);
	}

	function askToSaveNavigationHistory(challenge) {
		var textToSpeech = "";
		if(challenge){
			textToSpeech = " Você finalizou a navegação. O ponto final está na linha "
				+ (navigationMap.endPoint.data("coord-y") + 1) + " e coluna "
				+ (navigationMap.endPoint.data("coord-x") + 1) + ". ";
			isNavigationFinished = true;
		}
		textToSpeech += "Você deseja salvar o histórico da navegaçao realizada? Tecle S para sim ou N para não.";
		playTextToSpeech(textToSpeech);
		confirmClose = false;
		confirmSaveHistory = true;
	}

	function saveNavigationHistory() {
		navigationHistory.history.dataNavegacao = new Date();
		navigationHistory.history.tempoNavegacao = timerNavigation.getTimeValues().toString();
		navigationHistory.history.mapa.id = document.getElementById("idMapa").value;
		navigationHistory.history.usuario = 3; //TODO: Usuário BRUNA, trocar para usuário logado!
		navigationHistory.saveNavigationHistory();
		confirmClose = false;
		confirmSaveHistory = false;
		isBlocked = false;
	}

	function getObjectByCoordinated(x, y) {
		var object = null, hasObjectX = false, hasObjectY = false;

		$.each(mapObjects, function(key, value) {
			if (value.pontoInicial == false && value.objeto.nivel != 0) {
				hasObjectY = validateCoordinate(y, value.coordenadaY,
						value.altura);
				hasObjectX = validateCoordinate(x, value.coordenadaX,
						value.largura);
			}

			if (hasObjectX && hasObjectY) {
				object = value;
				return false;
			}
		});

		return object;
	}

	function toStringObject(objectMap, direction) {
		var textToSpeech = "";
		if (objectMap !== null && objectMap !== undefined) {

			textToSpeech = "Objeto "
				+ objectMap.objeto.nome
				+ (direction !== null && direction !== undefined ? " está ao " + direction : "" )
				+ ", "
				+ (objectMap.audioDescricao ? " Descrição: "
						+ objectMap.audioDescricao : "Sem descrição")
						+ ". Na linha: " + (objectMap.coordenadaY + 1)
						+ " e coluna: " + (objectMap.coordenadaX + 1)
						+ ". O objeto possui " + objectMap.altura + " de altura e "
						+ objectMap.largura + " de largura. ",

						console.log(textToSpeech);
		}
		return textToSpeech;
	}

	function describeObject(objectMap, extraText) {

		if (objectMap !== null && objectMap !== undefined) {
			var textToSpeech = toStringObject(objectMap);
			pathAudioFile = objectMap.audioIconico.arquivo;

			if (objectMap !== null && objectMap !== undefined) {
				textToSpeech = extraText + textToSpeech;
			}
			playTextToSpeech(textToSpeech);

		}
	}
	function checkDirection(angle) {
		angle = navigationMap.normalizeAngle(angle);
		var direction = DirectionEnum.UP;
		switch (angle) {
		case 0:
			direction = DirectionEnum.UP;
			break;
		case 90:
			direction = DirectionEnum.RIGHT;
			break;
		case 180:
			direction = DirectionEnum.DOWN;
			break;
		case 270:
			direction = DirectionEnum.LEFT;
			break;

		default:
			direction = DirectionEnum.UP;
		break;
		}
		return direction;
	}

	function checkOppositeDirection(angle) {
		angle = navigationMap.normalizeAngle(angle);
		var direction = DirectionEnum.UP;
		switch (angle) {
		case 0:
			direction = DirectionEnum.DOWN;
			break;
		case 90:
			direction = DirectionEnum.LEFT;
			break;
		case 180:
			direction = DirectionEnum.UP;
			break;
		case 270:
			direction = DirectionEnum.RIGHT;
			break;

		default:
			direction = DirectionEnum.UP;
		break;
		}
		return direction;
	}

	function checkCollisions(offset) {
		var hasObjectX = false;
		hasObjectY = false, hasObject = false, nextPosX = offset.left / 32,
		nextPosY = offset.top / 32;
		$.each(mapObjects, function(key, value) {
			if ((value.pontoInicial == false && value.pontoFinal == false)
					&& value.objeto.nivel != 0) {
				hasObjectY = validateCoordinate(nextPosY, value.coordenadaY,
						value.altura);
				hasObjectX = validateCoordinate(nextPosX, value.coordenadaX,
						value.largura);
			}

			if (hasObjectX && hasObjectY) {
				hasObject = true;
				lastBumpedObject = value;

				if (value.audioIconico.arquivo) {
					collisionsAudio = value.audioIconico.arquivo;
				} else {
					collisionsAudio = '/resources/audio/collisions.mp3'
				}
				return false;
			}
		});
		return hasObject;
	}

	function checkEndPoint(offset) {
		var nextPosX = offset.left / 32,
		nextPosY = offset.top / 32, finishedNavigation = false, hasObjectY = false, hasObjectX = false;

		if (navigationMap.endPoint != null){
			var endX = navigationMap.endPoint.data("coord-x"), endY = navigationMap.endPoint.data("coord-y");

			hasObjectY = validateCoordinate(nextPosY, endY, navigationMap.endPoint.data("height"));
			hasObjectX = validateCoordinate(nextPosX, endX, navigationMap.endPoint.data("width"));

			if (hasObjectX && hasObjectY) {
				finishedNavigation = true;
				navigationHistory.logFinishedChallengeNavigation(navigationMap.endPoint, timerNavigation.getTimeValues().toString());
			}
		}

		return finishedNavigation;
	}

	function validateCoordinate(nextPos, objectPos, measurements) {
		var hasObject = false;

		if (nextPos == objectPos) {
			hasObject = true;
		}

		var objectRealSize = objectPos + (measurements - 1);

		if (nextPos > objectPos && nextPos <= objectRealSize) {
			hasObject = true;
		}
		return hasObject;
	}

	function playIconicAudio(audioPath) {
		var audio = $('audio');
		if (audio.get(0)) {
			if (!audio.get(0).paused) {
				audio.get(0).pause();
				audio.get(0).currentTime = 0;
			}
		}
		audio.attr('src', audioPath);
		audio.get(0).play();

		audio.get(0).onerror = function() {
			console.log("Erro ao reproduzir áudio: " + audioPath);
		};

	}

	function checkIsNavigationStoppedOrFinished() {
		if(!isBlocked){
			if(checkIsNavigationFinished()){
				return isNavigationFinished;
			}

			if (isNavigationStopped) {
				var textToSpeech = "Navegação pausada   " + time + ". Para retomar a navegação, tecle Alt S.";
				console.log(textToSpeech);
				playTextToSpeech(textToSpeech);
			}
			return isNavigationStopped;
		}
		return isBlocked;

	}

	function checkIsNavigationFinished() {
		if(!isBlocked){
			if (isNavigationFinished) {
				var textToSpeech = "Navegação finalizada. Para retornar a navegar, acesse o Menu \"Iniciar Navegação\" ou ALT 1.";
				console.log(textToSpeech);
				playTextToSpeech(textToSpeech);
			}
			return isNavigationFinished;
		}
		return isBlocked;
	}

	function getInitLog(){
		var posX = player.data("coord-x") + 1;
		posY = player.data("coord-y") + 1, rotate = player.data("rotate"),
		direction = checkDirection(rotate),
		textDirection = DirectionEnum.getTextDirection(direction);

		var textToSpeech = "Iniciando a navegação, estou na direção " + textDirection + ", linha "
		+ posY + " e coluna " + posX + ".";

		playTextToSpeech(textToSpeech);

		return textToSpeech;
	}
	
	function getTextTime(){
		var date = new Date(); // for now
		var hours =  date.getHours() == 1 ? " á " + date.getHours() + " hora " : "ás " + date.getHours() + " horas ";
		var minutes = date.getMinutes() == 1 ? date.getMinutes() + " minuto e " : date.getMinutes() + " minutos e ";
		var seconds = date.getSeconds() == 1 ? date.getSeconds() + " segundo " : date.getSeconds() + " segundos ";
		var textTime = hours + minutes + seconds;
		
		return textTime;
	}
	
	function getTextDate(){
		var date = new Date(); 
		var day = date.getDate() < 10 ? "0"+date.getDate() : date.getDate();
		var month = date.getDate() < 10 ? "0"+date.getMonth() : date.getMonth();
		var year = date.getFullYear();
		
		var text = day+"/"+month+"/"+year;
		
		return text;
	}
	self.init();

};
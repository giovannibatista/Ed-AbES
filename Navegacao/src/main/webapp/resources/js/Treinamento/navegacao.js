var Navigation = function(navigationMap, mapObjects) {
	var self = this, 
	player = navigationMap.startingPoint, 
	footstepAudio = '/resources/audio/footsteps-cut.mp3', 
	collisionsAudio = '/resources/audio/collisions.mp3',
	audioLeft = '/resources/audio/beep_left.wav',
	audioRight = '/resources/audio/beep_right.wav' , 
	mapObjects = mapObjects, 
	lastBumpedObject = null, 
	timerNavigation = new Timer(), 
	navigationHistory = new NavigationHistory(), 
	isNavigationStopped = false, 
	isNavigationFinished = false, 
	isBlocked = false, 
	confirmClose = false, 
	confirmSaveHistory = false,
	up = false,
	right = false,
	left = false,
	altC = false,
	altM = false,
	altO = false,
	altT = false,
	altR = false,
	altS = false,
	altL = false,
	altP = false,
	altQ = false,
	yes = false,
	no = false,
	index = 0,
	currentAction = "";

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
		timerNavigation.start();
	}

	self.walk = function(forcedDirection) {
		if(up){
			index++;
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
					navigationHistory.logWalkUp(DirectionEnum.getTextDirection(self.direction));

					if(index == 1 && currentAction == "init"){
						setTimeout(function(){
							var textToSpeech = "Este é o som de um passo do jogador. Agora dê mais dois passos para OESTE com a tecla de atalho seta para cima.";
							playTextToSpeech(textToSpeech);
							currentAction = "";
						}, 1000);
					}

					if(index == 1 && currentAction == "localizacao"){
						up = false;
						setTimeout(function(){
							var textToSpeech = "Vamos continuar nosso treinamento. Agora tecle seta para esquerda para girar o jogador 90 graus para esquerda, sentido antihorário novamente. ";
							playTextToSpeech(textToSpeech);
							currentAction = "";
							currentAction = "up";
							left = true;
							index = 0;
						}, 1000);
					}
					
					if(index == 2 && currentAction == "left"){
						setTimeout(function(){
							var textToSpeech = "Durante a navegação, podemos saber quanto tempo estamos levando, para isso podemos utilizar a tecla ALT T.";
							playTextToSpeech(textToSpeech);
							currentAction = "up";
							altT = true;
							up=false;
							index = 0;
						}, 1000);
					}
					
					if(index == 1 && currentAction == "retomarNavegacao"){
						setTimeout(function(){
							var textToSpeech = "Acho que estamos bem perto. Mas vamos ver quais objetos estão ao nosso redor. " +
									"Utilize o comando ALT R para verificar os objetos ao redor do jogador, com distância de um passo.";
							playTextToSpeech(textToSpeech);
							currentAction = "up";
							index = 0;
							altR = true;
							up=false;
						}, 1000);
					}
					
					

				} else {
					playIconicAudio(collisionsAudio);
					hasObject = false;
					offset = {
							top : nextOffset.top,
							left : nextOffset.left
					};
					navigationHistory.logCollision(lastBumpedObject);
					
					if(index == 1 && currentAction == "redor"){
						setTimeout(function(){
							var textToSpeech = "Estamos quase no fim do nosso treinamento. Durante a navegação, você pode escutar o log dos seus movimentos e comandos realizados. " +
									"A fim de relembrar o caminho que andou ou se está indo na direção correta. Utilize o comando ALT L para reproduzir o log do histórico da navegação.";
							playTextToSpeech(textToSpeech);
							currentAction = "up";
							index = 0;
							altL = true;
							up = false;
						}, 1000);
					}
					
					if(index == 3){
						up = false;
						setTimeout(function(){
							var textToSpeech = "Opa, você colidiu em um objeto. Ao colidir, um som icônico de madeira foi reproduzido. " +
							"Vamos descobrir qual foi o último objeto que o jogador colidiu. E para isso, utilize a tecla de atalho ALT C.";
							playTextToSpeech(textToSpeech);
							altC = true;
							currentAction = "colisao";
							index = 0;
						}, 1000);
					}
				}


			}
		}
	}

	self.rotateLeft = function() {
		if(left){
			if (!checkIsNavigationStoppedOrFinished()) {
				navigationMap.rotateObjectAction(player,
						navigationMap.DirectionEnum.LEFT);
				var rotate = player.data("rotate"),
				direction = checkDirection(rotate);
				playIconicAudio(audioLeft);
				navigationHistory.logChangeDirection(DirectionEnum.getTextDirection(direction));

				if(currentAction == "colisao"){
					setTimeout(function(){
						var textToSpeech = "Esté o som emitido quando o jogodor gira 90 graus para a esquerda. Para o jogador não se perder e saber aonde está no mapa, podemos " +
						"utilizar a tecla de atalho ATL O, que retorna a localização atual do jogador. Então tecle ALT O.";
						playTextToSpeech(textToSpeech);
						currentAction = "left";
						index = 0;
						altO = true;
					}, 1000);
				}
				
				if(currentAction == "up"){
					setTimeout(function(){
						var textToSpeech = "Agora dê mais dois passos para frente com a tecla seta para cima";
						playTextToSpeech(textToSpeech);
						currentAction = "left";
						up = true;
						left = false;
						
					}, 1000);
				}
			}
		}
	}

	self.rotateRight = function() {
		if(right){
			if (!checkIsNavigationStoppedOrFinished()) {
				navigationMap.rotateObjectAction(player,
						navigationMap.DirectionEnum.RIGHT);
				var rotate = player.data("rotate"),
				direction = checkDirection(rotate);
				playIconicAudio(audioRight);
				navigationHistory.logChangeDirection(DirectionEnum.getTextDirection(direction));
				
				setTimeout(function(){
					var textToSpeech = "O som emitido ao girar o jogador 90 graus para direita é diferente de quando girar 90 graus esquerda. " +
							"Mais uns passos e chegamos no nosso outro objeto do mapa. Porém sempre é bom descansar um pouco. Então você pode pausar a navegação. " +
							"Com a navegação parada, o jogador não pode navegar e o cronomêtro também irá parar." +
							"Utilize a tecla ALT S para pausar a navegação.";
					playTextToSpeech(textToSpeech);
					currentAction = "right";
					right = false;
					altS = true;
				}, 1000);
			}
		}
	}

	self.getAroundObjects = function() {
		if(altR){
			if (!checkIsNavigationStoppedOrFinished()) {
				navigationHistory.logActions("ALT R", "Objetos ao seu redor");
				var currentPos = {
						y : player.data("coord-y"),
						x : player.data("coord-x")
				}, objects = [];

				/*objects.push(getObjectByCoordinated(currentPos.x, (currentPos.y - 1))); // UP
				objects.push(getObjectByCoordinated((currentPos.x + 1), currentPos.y)); // RIGHT
				*/
				objects.push(getObjectByCoordinated(currentPos.x, (currentPos.y + 1))); // DOWN
				//objects.push(getObjectByCoordinated((currentPos.x - 1), currentPos.y)); // LEFT

				var directions = [/*"Norte", "Leste", */"Sul"/*, "Oeste"*/];
				var i, length = objects.length, textToSpeech = "";
				for (i = 0; i < length; i++) {
					if (objects[i] !== null && objects[i] !== undefined) {
						textToSpeech += toStringObject(objects[i], directions[i]);
					}
				}
				textToSpeech += ". Oba chegamos ao segundo objeto do mapa. Com o comando ALT R podemos saber todos objetos ao nosso redor, no sentido horário. " +
						"Para ter certeza do objeto ao na direção SUL, vamos colidir com ele. " +
						"De mais um passo a frente e escute o som padrão de colisão do sistema, quando não é vinculado nenhum som ao objeto.";
				playTextToSpeech(textToSpeech);
				altR = false;
				up = true;
				currentAction = "redor";
			}
		}
	}

	self.getInfoMap = function() {
		if(altM){
			if (!checkIsNavigationStoppedOrFinished()) {
				altM=false;
				navigationHistory.logActions("ALT M", "Informações do mapa");
				var nomeMapa = document.getElementById("nomeMapa").value, descricaoMapa = document
				.getElementById("descricaoMapa").value, objetivoMapa = document
				.getElementById("objetivoMapa").value, andarMapa = document
				.getElementById("andarMapa").value, descricaoTipoMapa = document
				.getElementById("descricaoTipoMapa").value, rotate = player.data("rotate"),
				direction = checkDirection(rotate),
				textDirection = DirectionEnum.getTextDirection(direction);

				var textToSpeech = "O mapa " + nomeMapa + ", do tipo " + descricaoTipoMapa +", está no " + andarMapa
				+ " pavimento.  A descrição do mapa é " + descricaoMapa
				+ ". E O objetivo é " + objetivoMapa + ". Com as informações do mapa, já podemos iniciar a navegação. " +
				"Vamos começar dando um passo para frente, em direção " + textDirection + " e aprender como é o som icônico de um passo. " +
				"Para isso, se utiliza a tecla de atalho seta para cima.";
				console.log(textToSpeech);
				playTextToSpeech(textToSpeech);
				up=true;
			}
		}
	}

	self.getCurrentLocation = function() {
		if(altO){
			if (!checkIsNavigationStoppedOrFinished()) {
				navigationHistory.logActions("ALT O", "Localização atual do jogador");
				var posX = player.data("coord-x") + 1;
				posY = player.data("coord-y") + 1, rotate = player.data("rotate"),
				direction = checkDirection(rotate),
				textDirection = DirectionEnum.getTextDirection(direction);

				var textToSpeech = "Estou na direção " + textDirection + ", coluna "
				+ posX + " e linha " + posY + ".";

				if(currentAction == "left"){
					textToSpeech += " Como giramos o nosso jogador 90 graus para a esquerda, agora estamos na direção " + textDirection +". " +
					"Vamos em frente! De um passo para frente com a tecla seta para cima."
					up = true;
					altO = false;
					currentAction = "localizacao";
				}

				console.log(textToSpeech);

				playTextToSpeech(textToSpeech);
			}
		}
	}

	self.getLastBumpedObject = function() {
		if(altC){
			currentAction = "colisao";
			if (!checkIsNavigationStoppedOrFinished()) {
				navigationHistory.logActions("ALT C", "Informações do último objeto colidido");
				if(lastBumpedObject){
					altC = false;
					describeObject(lastBumpedObject, "Último objeto colidido foi ");

				}else{
					var textToSpeech = "Você não colidiu com nenhum objeto ainda!";
					playTextToSpeech(textToSpeech);
				}
			}
		}
	}

	self.getTimerNavigation = function() {
		if(altT){
			if(!checkIsNavigationFinished()){
				
				navigationHistory.logActions("ALT T", "Informações do tempo de navegação");
				var textToSpeech = timerNavigation.getTimeValues().toString();
				textToSpeech = " O tempo de navegação é " + textToSpeech + ". Estamos indo muito bem e estamos quase chegando no outro objeto. " +
						"Agora vamos girar nosso personagem 90 graus para direita, sentido horário. Utilize a tecla de atalho seta para direita e preste atenção no som que será emitido.";
				console.log(textToSpeech);
				playTextToSpeech(textToSpeech);
				right = true;
				altT = false;
				currentAction = "timer";
			}
		}
	}

	self.playPauseTextToSpeech = function() {
		if(altP){
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
	}

	self.resumeStopNavigation = function() {
		if(altS){
			if(!checkIsNavigationFinished()){
				navigationHistory.logActions("ALT S", "Pausar e Retomar a navegação");
				var timer = timerNavigation.getTimeValues().toString(), textToSpeech = "";
				if (!isNavigationStopped) {
					timerNavigation.pause();
					isNavigationStopped = true;
					textToSpeech = "Navegação pausada em " + timer
					+ ". Para retomar a navegação, tecle Alt S. Mas antes, tente movimentar seu jogador para frente e vamos ver o que acontece!";
					console.log(textToSpeech);
					playTextToSpeech(textToSpeech);
					up = true;
					altS = false;
					currentAction = "navegacaoparada"

				} else {
					timerNavigation.start();
					isNavigationStopped = false;
					textToSpeech = "Navegação retomada em " + timer + ". De um passo para frente com a tecla seta para cima.";
					console.log(textToSpeech);
					playTextToSpeech(textToSpeech);
					up = true;
					altS = false;
					index = 0;
					currentAction = "retomarNavegacao"
				}
			}
		}
	}

	self.playLog = function() {
		if(altL){
			if (!checkIsNavigationStoppedOrFinished()) {
				navigationHistory.logActions("ALT L", "Reproduzir o log da navegação");
				var log = navigationHistory.history.log;
				console.log(log);
				
				log += ". Fim do Log. Pronto! Você finalizou o treinamento do módulo de navegação. " +
						"Acredito que foi muito bem e já pode escolher um mapa na lista de mapas públicos e começar a navegar. Vamos encerrar a navegação com o comando ALT Q.";
				altQ = true;
				altL = false;
				currentAction = "";
				playTextToSpeech(log);
			}
		}
	}

	self.askToCloseNavigation = function() {
		if(altQ){
			if(!checkIsNavigationFinished()){
				navigationHistory.logActions("ALT Q", "Encerrar a navegação");
				var textToSpeech = "Ao encerrar a navegação, é lhe perguntado se Você tem certeza que deseja encerrar a navegação? Com as opções S para sim ou N para não. Tecle S para encerrar a navegação e o treinamento.";
				playTextToSpeech(textToSpeech);
				confirmClose = true;
				confirmSaveHistory = false;
				isBlocked = true;
				
				yes = true; 
				altQ = false;
			}
		}
	}

	self.yes = function() {
		if(yes){
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
	}

	self.no = function() {
		if(no){
			if(isBlocked &&(confirmClose || confirmSaveHistory)){
				playTextToSpeech("Não");
				navigationHistory.logActions("N", "Não.");
				isBlocked = false;
				if(confirmClose){
					isNavigationFinished = false;
				}
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
		navigationHistory.logFinishedNavigation(player, timerNavigation.getTimeValues().toString());
		askToSaveNavigationHistory(false);
	}

	function askToSaveNavigationHistory(challenge) {
		var textToSpeech = "";
		if(challenge){
			textToSpeech = " Você finalizou a navegação. O ponto final estava na coluna "
				+ (navigationMap.endPoint.data("coord-x") + 1) + " e linha "
				+ (navigationMap.endPoint.data("coord-y") + 1) + ". ";
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
						+ ". Na coluna: " + (objectMap.coordenadaX + 1)
						+ " e linha: " + (objectMap.coordenadaY + 1)
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
			if(currentAction == "colisao"){
				textToSpeech += "Este objeto possui um som icônico próprio de batida em madeira. " +
				"Objetos que não possuem nenhum som vinculados, emitem um som padrão de colisão. " +
				"Agora, vamos descobrir o outro objeto no mapa. Primeiro, precisamos chegar até ele. Utilize a tecla de atalho seta para esquerda," +
				"para girar seu personagem 90 graus para esquerda, sentido antihorário.";
				left = true;
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
				var textToSpeech = "Navegação pausada. Para retomar a navegação, tecle Alt S. " +
						"Então, quando a navegação estiver pausada, apaenas os comandos para encerrar a navegação, " +
						"saber o tempo de navegaçao e o de retomar a navegação estarão disponíveis para o jogador. Porém ainda não queremos encerrar a navegação. " +
						"Então tecle ALT S para retomar a navegação";
				console.log(textToSpeech);
				playTextToSpeech(textToSpeech);
				
				altS = true;
				up = false;
				currentAction = "retomarNavegacao";
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

		var textToSpeech = "Bem-vindo ao módulo de treinamento do Ed-AbES. Seu jogador iniciou na direção " + textDirection + ", coluna "
		+ posX + " e linha " + posY + " do mapa. Primeiro vamos saber mais informações do mapa de treinamento, para isso utilize a tecla de atalho ALT M.";

		playTextToSpeech(textToSpeech);

		altM = true;
		currentAction = "init";

		return textToSpeech;
	}
	self.init();

};
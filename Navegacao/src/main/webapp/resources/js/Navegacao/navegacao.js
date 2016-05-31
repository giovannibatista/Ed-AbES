var Navigation = function(navigationMap, mapObjects) {
	var self = this, player = navigationMap.startingPoint, footstepAudio = '/resources/audio/footsteps-cut.mp3', collisionsAudio = '/resources/audio/collisions.mp3',left = '/resources/audio/beep_left.wav',right = '/resources/audio/beep_right.wav' , mapObjects = mapObjects, lastBumpedObject = null, timerNavigation = new Timer(), isNavigationStopped = false, navigationHistory = new NavigationHistory();

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
		var log = "Iniciando a navegação. " + self.getCurrentLocation();
		navigationHistory.logInit(log);
		timerNavigation.start();
	}

	self.walk = function(forcedDirection) {
		if (!checkIsNavigationStopped()) {
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
					self.saveNavigationHistory();
					var textToSpeech = " Você finalizou a navegação. O ponto final estava na coluna "
						+ (navigationMap.endPoint.data("coord-x") + 1) + " e linha "
						+ (navigationMap.endPoint.data("coord-y") + 1) + ". Finalizou a navegação em " + timerNavigation.getTimeValues().toString() + ". Pressione enter para sair!";
					playTextToSpeech(textToSpeech);
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
		if (!checkIsNavigationStopped()) {
			var direction = checkOppositeDirection(player.data("rotate"));
			self.walk(direction);
		}
	}

	self.rotateLeft = function() {
		if (!checkIsNavigationStopped()) {
			navigationMap.rotateObjectAction(player,
					navigationMap.DirectionEnum.LEFT);
			var rotate = player.data("rotate"),
			direction = checkDirection(rotate);
			playIconicAudio(left);
			navigationHistory.logChangeDirection(DirectionEnum.getTextDirection(direction));
		}
	}

	self.rotateRight = function() {
		if (!checkIsNavigationStopped()) {
			navigationMap.rotateObjectAction(player,
					navigationMap.DirectionEnum.RIGHT);
			var rotate = player.data("rotate"),
			direction = checkDirection(rotate);
			playIconicAudio(right);
			navigationHistory.logChangeDirection(DirectionEnum.getTextDirection(direction));
		}
	}

	self.getAroundObjects = function() {
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

	self.getInfoMap = function() {
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

	self.getCurrentLocation = function() {
		var posX = player.data("coord-x") + 1;
		posY = player.data("coord-y") + 1, rotate = player.data("rotate"),
		direction = checkDirection(rotate),
		textDirection = DirectionEnum.getTextDirection(direction);

		var textToSpeech = "Estou na direção " + textDirection + ", coluna "
		+ posX + " e linha " + posY + ".";

		console.log(textToSpeech);

		playTextToSpeech(textToSpeech);

		return textToSpeech;

	}

	self.getLastBumpedObject = function() {
		if(lastBumpedObject){
			describeObject(lastBumpedObject, "Último objeto colidido foi ");
		}else{
			var textToSpeech = "Você não colidiu com nenhum objeto ainda!";
			playTextToSpeech(textToSpeech);
		}
	}

	self.getTimerNavigation = function() {
		var textToSpeech = timerNavigation.getTimeValues().toString();
		textToSpeech = "Tempo de navegação: " + textToSpeech;
		console.log(textToSpeech);
		playTextToSpeech(textToSpeech);
	}

	self.playPauseTextToSpeech = function() {
		var audioTextToSpeech = $('audio').get(0);
		if (!audioTextToSpeech.paused) {
			audioTextToSpeech.pause();
			pauseTextToSpeech();
		}else{
			resumeTextToSpeech();
		}
	}

	self.resumeStopNavigation = function() {
		var timer = timerNavigation.getTimeValues().toString(), textToSpeech = "";
		if (!isNavigationStopped) {
			timerNavigation.pause();
			isNavigationStopped = true;
			textToSpeech = "Navegação pausada em " + timer
			+ ". Para retomar a navegação, tecle Alt S.";
			console.log(textToSpeech);
			playTextToSpeech(textToSpeech);

		} else {
			timerNavigation.start();
			isNavigationStopped = false;
			textToSpeech = "Navegação retomada em " + timer + ".";
			console.log(textToSpeech);
			playTextToSpeech(textToSpeech);
		}
	}

	self.playLog = function() {
		var log = navigationHistory.history.log;
		console.log(log);
		playTextToSpeech(log);
	}

	self.closeNavigation = function() {
		if(confirm("Você tem certeza que deseja encerrar a navegação?")){
			navigationHistory.logFinishedNavigation(player, timerNavigation.getTimeValues().toString());
			self.saveNavigationHistory();
			document.location = "/";
		}
	}

	self.saveNavigationHistory = function() {
		timerNavigation.pause();
		isNavigationStopped = true;
		if(confirm("Você deseja salvar o histórico da navegaçao realizada?")){
			navigationHistory.history.dataNavegacao = new Date();
			navigationHistory.history.tempoNavegacao = timerNavigation.getTimeValues().toString();
			navigationHistory.history.mapa.id = document.getElementById("idMapa").value;
			navigationHistory.history.usuario = 3; //TODO: Usuário BRUNA, trocar para usuário logado!
			navigationHistory.saveNavigationHistory();
		}
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

	function checkIsNavigationStopped() {
		if (isNavigationStopped) {
			var textToSpeech = "Navegação pausada. Para retomar a navegação, tecle Alt S.";
			console.log(textToSpeech);
			playTextToSpeech(textToSpeech);
		}
		return isNavigationStopped;

	}

	self.init();

};
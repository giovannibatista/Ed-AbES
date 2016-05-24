var Navigation = function(navigationMap, mapObjects) {
	var self = this, player = navigationMap.startingPoint, footstepAudio = '/resources/audio/footsteps-cut.mp3', collisionsAudio = '/resources/audio/collisions.mp3', mapObjects = mapObjects, lastBumpedObject = null, timerNavigation = new Timer(), isNavigationStopped = false;

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
		self.getCurrentLocation();
		timerNavigation.start();
	}

	self.walk = function(forcedDirection) {
		if (!checkIsNavigationStopped()) {
			console.log("self.walk");
			var rotate = player.data("rotate"), coordZ = navigationMap.maxZ + 1, audio, nextOffset = {
				top : offset.top,
				left : offset.left
			};
			if (forcedDirection) {
				self.direction = forcedDirection
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

			} else {
				playIconicAudio(collisionsAudio);
				hasObject = false;
				offset = {
					top : nextOffset.top,
					left : nextOffset.left
				};
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
		}
	}

	self.rotateRight = function() {
		if (!checkIsNavigationStopped()) {
			navigationMap.rotateObjectAction(player,
					navigationMap.DirectionEnum.RIGHT);
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

		var i, length = objects.length, textToSpeech = "";
		for (i = 0; i < length; i++) {
			if (objects[i] !== null && objects[i] !== undefined) {
				textToSpeech += toStringObject(objects[i]);
			}
		}

		playTextToSpeech(textToSpeech);
	}

	self.getInfoMap = function() {
		var nomeMapa = document.getElementById("nomeMapa").value, descricaoMapa = document
				.getElementById("descricaoMapa").value, objetivoMapa = document
				.getElementById("objetivoMapa").value, andarMapa = document
				.getElementById("andarMapa").value;

		var textToSpeech = "O mapa " + nomeMapa + " está no " + andarMapa
				+ " pavimento. A descrição do mapa é " + descricaoMapa
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

	}

	self.getLastBumpedObject = function() {
		describeObject(lastBumpedObject);
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

	function toStringObject(objectMap) {
		var textToSpeech = "";
		if (objectMap !== null && objectMap !== undefined) {
			textToSpeech = "Objeto "
					+ objectMap.objeto.nome
					+ ", "
					+ (objectMap.audioDescricao ? " Descrição: "
							+ objectMap.audioDescricao : "Sem descrição")
					+ ". Na posição X: " + (objectMap.coordenadaX + 1)
					+ " e posição Y: " + (objectMap.coordenadaY + 1)
					+ ". O objeto possui " + objectMap.altura + " de altura e "
					+ objectMap.largura + " de largura. ",

			console.log(textToSpeech);
		}
		return textToSpeech;
	}

	function describeObject(objectMap) {

		if (objectMap !== null && objectMap !== undefined) {
			var textToSpeech = toStringObject(objectMap);
			pathAudioFile = objectMap.audioIconico.arquivo;

			playTextToSpeech(textToSpeech);

		}
	}

	/*
	 * height: value.altura, width: value.largura, idObject: value.objeto.id,
	 * image: value.objeto.imagemMapa, x: value.coordenadaX, y:
	 * value.coordenadaY, z: value.profundidade, title: value.audioDescricao,
	 * nome: value.objeto.nome, id: value.idMapaObjeto, rotate : value.angulo,
	 * arquivoAudio : value.idArquivoAudio, pontoInicial : value.pontoInicial,
	 * pontoFinal : value.pontoFinal, nivel : value.objeto.nivel
	 */

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
			// console.log("Nome: " + value.objeto.nome + " X" +
			// value.coordenadaX + " Y" + value.coordenadaY + " nivel:" +
			// value.objeto.nivel + "value.objeto.nivel == 0?" +
			// value.objeto.nivel == 0 );
			// TODO - Validar este ponto inicial e final em outro lugar...
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

	var audio;
	function playIconicAudio(audioPath) {
		if (audio) {
			if (!audio.paused) {
				audio.pause();
				audio.currentTime = 0;
			}
		}
		audio = new Audio(audioPath);
		audio.play();

		audio.onerror = function() {
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
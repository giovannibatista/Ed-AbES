var Navigation = function(navigationMap, mapObjects) {
	var self = this,
	player = navigationMap.startingPoint,
	footstepAudio = '/resources/audio/footsteps-cut.mp3', collisionsAudio = '/resources/audio/collisions.mp3',
	mapObjects = mapObjects,
	lastBumpedObject = null;
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
	},
	offset = {
			top : player.data("coord-y") * navigationMap.scale,
			left : player.data("coord-x") * navigationMap.scale
	};

	player.data({
		"coord-z": navigationMap.maxZ + 1
	});

	self.walk = function(forcedDirection) {
		console.log("self.walk");
		var rotate = player.data("rotate"),
		coordZ = navigationMap.maxZ + 1,
		nextOffset = {
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
			playAudioIconic(footstepAudio);
			navigationMap.moveObj(player, offset, rotate);

		} else {
			playAudioIconic(collisionsAudio);
			hasObject = false;
			offset = {
					top : nextOffset.top,
					left : nextOffset.left
			};
		}
	}

	self.down = function() {
		var direction = checkOppositeDirection(player.data("rotate"));
		self.walk(direction);
	}

	self.rotateLeft = function() {
		navigationMap.rotateObjectAction(player,
				navigationMap.DirectionEnum.LEFT);
	}

	self.rotateRight = function() {
		navigationMap.rotateObjectAction(player,
				navigationMap.DirectionEnum.RIGHT);
	}

	self.getAroundObjects = function() {
		debugger;
		var currentPos = {
				y : player.data("coord-y"),
				x : player.data("coord-x")
		};

		var objects = [];

		objects.push(getObjectByCoordinated(currentPos.x, (currentPos.y - 1))); // UP
		objects.push(getObjectByCoordinated((currentPos.x + 1), currentPos.y)); // RIGHT
		objects.push(getObjectByCoordinated(currentPos.x, (currentPos.y + 1))); // DOWN
		objects.push(getObjectByCoordinated((currentPos.x - 1), currentPos.y)); // LEFT

		var i,
		length = objects.length;
		for ( i = 0	; i < length; i++ ) {
			if ( objects[i] !== null && objects[i] !== undefined ){
				describeObject(objects[i]);
			}
		}

	}


	self.getGoalMap = function() {

		// TODO - Fazer a chamada para o Text to Speech
	}



	self.getCurrentLocation = function() {
		var posX = player.data("coord-x");
		posY = player.data("coord-y"), rotate = player.data("rotate"),
		direction = checkDirection(rotate),
		textDirection = DirectionEnum.getTextDirection(direction);

		var textToSpeech = ("Estou na direcao %s, coluna %s e linha %s.",
				textDirection, posX, posY);

		console.log(textToSpeech);

		// TODO - Fazer a chamada para o Text to Speech
	}

	self.getLastBumpedObject = function() {

		describeObject(lastBumpedObject);

	}

	function getObjectByCoordinated (x, y) {
		var object = null;

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

	function describeObject(objectMap) {

		var textToSpeech = "Objeto " + objectMap.objeto.nome +", " + (objectMap.audioDescricao ? " Descricao: " + objectMap.audioDescricao : "Sem descricao") + 
		". Na Posicao X: " + objectMap.coordenadaX + " e posicao Y: " + objectMap.coordenadaY + ". O objeto possui " + objectMap.altura + " de altura e " + objectMap.largura + " de largura." ,
		pathAudioFile = objectMap.audioIconico.arquivo;

		console.log(textToSpeech);

		// TODO - Fazer a chamada para o Text to Speech

		if(pathAudioFile){
			playAudioIconic(pathAudioFile);
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

				if (value.audioIconico.arquivo){
					collisionsAudio = value.audioIconico.arquivo;
				}else{
					collisionsAudio = '/resources/audio/collisions.mp3'
				}
				return false;
			}
		});
		return hasObject;
	}

	function validateCoordinate(nextPos, objectPos, measurements) {
		// debugger;
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
	
	function playAudioIconic(audioPath){
		var audio = new Audio(audioPath);
		audio.play();
		
		audio.onerror = function() {
		    console.log("Erro ao reproduzir audio: " + audioPath);
		};
		
	}

};
var Navigation = function(navigationMap, mapObjects) {
	var self = this;
	var player = navigationMap.startingPoint;

	var footstepAudio = '/resources/audio/footsteps-cut.mp3';
	var collisionsAudio = '/resources/audio/collisions.mp3';

	var mapObjects = mapObjects;

	var DirectionEnum = {
			UP : 1,
			DOWN : 2,
			LEFT : 3,
			RIGHT : 4
	};

	var offset = {
			top : player.data("coord-y") * navigationMap.scale,
			left : player.data("coord-x") * navigationMap.scale
	};

	self.walk = function(forcedDirection) {
		console.log("self.walk");
		var rotate = player.data("rotate");
		if (forcedDirection) {
			self.direction = forcedDirection
		} else {
			self.direction = checkDirection(rotate);
		}
		var nextOffset = {
				top : offset.top,
				left : offset.left
		};

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

		if(!hasObject){
			navigationMap.moveObj(player, offset, rotate);
			var audio = new Audio(footstepAudio);
			audio.play();

		}else{
			var audio = new Audio(collisionsAudio);
			audio.play();

			hasObject = false;
			player.attr("coord-x",nextOffset.left);
			player.attr("coord-y",nextOffset.top);

			offset = {
					top : nextOffset.top,
					left : nextOffset.left
			};
		}

		/*		console.log("WALK OFFSET X "+  (offset.left/32));
		console.log("WALK OFFSET Y "+  (offset.top/32));
		console.log("PLAYER X "+  player.data("coord-x"));
		console.log("PLAYER Y "+  player.data("coord-y"));


		console.log("WALK NEXTOFFSET X "+  (nextOffset.left/32));
		console.log("WALK NEXTOFFSET Y "+  (nextOffset.top/32));

		 */		
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

	self.getAroundObjects = function(){
		var currentPos = {
				top : player.data("coord-y"),
				left : player.data("coord-x")
		};
		
		
		
	}

	self.getGoalMap = function(){
		
	}

	self.getCurrentLocation = function(){
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
		var hasObjectY = false;
		var hasObject = false;
		//debugger;
		var nextPosX = offset.left / 32;
		var nextPosY = offset.top / 32;
		$.each(mapObjects, function(key, value) {
			//console.log("Nome: " + value.objeto.nome + " X" + value.coordenadaX + " Y" + value.coordenadaY + " nivel:" + value.objeto.nivel + "value.objeto.nivel == 0?" + value.objeto.nivel == 0 );
			//TODO - Validar este ponto inicial e final em outro lugar...
			if((value.pontoInicial == false && value.pontoFinal == false) && value.objeto.nivel != 0){
				hasObjectY = validateCoordinate(nextPosY, value.coordenadaY, value.altura);
				hasObjectX = validateCoordinate(nextPosX, value.coordenadaX, value.largura);
			}

			if(hasObjectX && hasObjectY){
				hasObject = true;
				return false;
			}
		});
		return hasObject;
	}

	function validateCoordinate(nextPos, objectPos, measurements) {
		//debugger;
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

};
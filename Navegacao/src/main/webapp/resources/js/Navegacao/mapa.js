var navigation = null;
$(window).load(function() {
	var idMap = document.getElementById("idMapa").value,
	$mapa = $("#mapa"),
	$mapaNavegacao = new Map($mapa);//Instanciate the Map

	$.ajax({
		url: "/Navegacao/Mapa/Objetos/" + idMap,
		type: "GET",
		dataType: "json",
		success: function(json) {
			$.each(json, function(key, value) {
				$mapaNavegacao.addMob({
					height: value.altura,
					width: value.largura,
					idObject: value.objeto.id,
					image: value.objeto.imagemMapa,
					x: value.coordenadaX,
					y: value.coordenadaY,
					z: value.profundidade,
					title: value.audioDescricao,
					nome: value.objeto.nome,
					id: value.idMapaObjeto,
					rotate : value.angulo,
					arquivoAudio : value.idArquivoAudio,
					pontoInicial : value.pontoInicial,
					pontoFinal : value.pontoFinal,
					nivel : value.objeto.nivel
				});
			});
			//Instanciate the navigation
			navigation = new Navigation($mapaNavegacao, json);
		},
		error: function() {
			alert("Erro ao ler os objetos do mapa. Por favor, contate o administador!");
		}
	});

	//initiate the map
	$mapaNavegacao.init();
	//initiate the navigation
	
	
});

var Map = function($navigationMap){
	var self = this,
	$mapRelative = $navigationMap,
	$map = null

	self.maxRotation = 360;

	//Custom parameters
	self.params = {
			initialScale: 32,
			rotationDegrees: 90,
			zindex: 8000
	};

	self.startingPoint = null;
	self.endPoint = null;
	self.maxDepth = 0;
	self.maxX = 0;
	self.maxY = 0;
	

	self.init = function(params) {
		//Extend options
		self.params = $.extend(self.params, params);

		self.x = self.y = 0;

		self.higherZIndex = 0;

		self.scale = self.params.initialScale;

		self.objSelection = null;

		//Create inner map object
		_createInnerMap();
		
		return (self);
	};

	self.DirectionEnum = {
			LEFT: 1,
			RIGHT: 2
	};

	var _createInnerMap = function() {
		//create new object
		var $mobs = $("<div />");
		$mobs.attr("id", "mapa_mobs");

		//append into map
		$mapRelative.append($mobs);

		//store the reference
		$map = $("#mapa_mobs");
	}

	self.addMob = function(objectProperties) {
		var $obj = $("<div />");
		$obj.data({
			width: objectProperties.width,
			height: objectProperties.height,
			image: objectProperties.image,
			objeto: objectProperties.idObject,
			id: objectProperties.id,
			title: objectProperties.title,
			nome: objectProperties.nome,
			rotate: objectProperties.rotate,
			profundidade: objectProperties.z,
			arquivoAudio : objectProperties.arquivoAudio,
			pontoInicial: objectProperties.pontoInicial,
			pontoFinal: objectProperties.pontoFinal,
			x : objectProperties.x,
			y : objectProperties.y,
			nivel : objectProperties.nivel
		});


		var offset = {
				left: objectProperties.x * self.scale,
				top: objectProperties.y * self.scale
		};

		addMob($obj, offset, (objectProperties.id == 0));
	}
	
	var addMob = function($obj, offset, isNew) {
		console.log("oi");
		var imageSrc = $obj.data("image");
		width = $obj.data("width"),
		height = $obj.data("height"),
		objeto = $obj.data("objeto"),
		id = $obj.data("id"),
		title = $obj.data("title"),
		nome = $obj.data("nome"),
		rotate = $obj.data("rotate"),
		profundidade = $obj.data("profundidade"),
		arquivoAudio = $obj.data("arquivoAudio"),
		pontoInicial = $obj.data("pontoInicial"),
		pontoFinal = $obj.data("pontoFinal"),
		x = $obj.data("x"),
		y = $obj.data("y"),
		$mob = $("<div />"); 		//create the mob
		
		$mob.addClass("mobs");
		$mob.css({
			"background-image": "url("+imageSrc+")",
			"background-size": (self.scale * width) + "px "+ (self.scale * height) +"px",
			width: self.scale * width,
			height: self.scale * height
		});

		//Get the deserved z-index based on the object status (NEW or UPDATE)
		profundidade = _getProperZIndex(profundidade);

		//append characteristics
		$mob.data({
			id: id,
			image: imageSrc,
			idObjeto: objeto,
			width: width,
			height: height,
			title: title,
			nome: nome,
			rotate: rotate,
			"coord-z": profundidade,
			arquivoAudio: arquivoAudio,
			profundidade: profundidade,
			x : x,
			y : y
		});

		//append into map body
		$map.append($mob);

		//move to desired position
		self.moveObj($mob, offset, rotate);
		
		
		self.maxDepth = getMaximumValue($mob, "profundidade", self.maxDepth);
		//TODO : Refatorar para pegar o X+Largura e Y+Altura...
		self.maxX = getMaximumValue($mob, "x", self.maxX);
		self.maxY = getMaximumValue($mob, "y", self.maxY);

		if(pontoInicial == true){
			console.log("STARTING POINT: x " + $mob.data("coord-x") + "y " + $mob.data("coord-y"));
			self.startingPoint = $mob;
		}

		if(pontoFinal == true){
			console.log("END POINT: x " + $mob.data("coord-x") + "y " + $mob.data("coord-y"));
			self.endPoint = $mob;
		}

	}
	

	var getMaximumValue = function($mob, prop, maxValue) {
		var value = $mob.data(prop);

		if(maxValue < value){
			maxValue = value;
		}

		return maxValue;
	}	


	var _getProperZIndex = function(objIndex) {
		var index = objIndex;

		//
		if (index == undefined) {
			index = self.higherZIndex + 1;
		}

		//update the base in the end
		if (self.higherZIndex < index) {
			self.higherZIndex = index;
		}

		return (index);
	}

	self.moveObj = function($obj, offset, rotate) {
		var profundidade = $obj.data("coord-z");

		//normalize positions
		offset.top = ((offset.top > 0) ? offset.top : 0);
		offset.left = ((offset.left > 0) ? offset.left : 0);

		//calculate relative position
		var pos = {
				left: parseInt(offset.left/self.scale),
				top: parseInt(offset.top/self.scale)
		};

		//move to absolute position
		$obj.css({
			transform: "translate3d("+ (pos.left * self.scale) +"px, "+ (pos.top * self.scale) +"px, 0) rotate("+rotate+"deg)",
			left: 0,
			top: 0,
			zIndex: (profundidade + self.params.zindex)
		});

		//append characteristics
		$obj.data({
			"coord-x": pos.left,
			"coord-y": pos.top
		});

		//check if it is in front of another mob
		//_checkAllFloatPositions();
	}

	var _checkAllFloatPositions = function() {
		$(".mobs").each(function() {
			var $obj = $(this);

			_checkFloatPosition($obj);
		});
	}

	var _checkFloatPosition = function($mob) {
		var isFloating = false;

		//start clearing it
		_drawBorder($mob, false);

		//get all mobs excluding the current on
		$(".mobs").not($mob).each(function() {
			var $obj = $(this);

			//Check if we are not comparing the same object
			if (!isFloating) {
				//Check if the object is floating another
				isFloating = _isMobFloatingObject($mob, $obj);

				if (isFloating) {
					//Draw the border according to floating status
					_drawBorder($mob, true);

					//We just need one affirmative case to leave the iterator
					return;
				}
			}
		});
	}

	var _drawBorder = function($obj, shouldDraw) {
		$obj.toggleClass("floatingObject", shouldDraw);
	}

	//Check if the current $mob is floating the $obj
	var _isMobFloatingObject = function($mob, $obj) {
		var mobValues = {
				x: $mob.data("coord-x"),
				y: $mob.data("coord-y"),
				z: $mob.data("coord-z"),
				width: $mob.data("width"),
				height: $mob.data("height")	
		};

		var objValues = {
				x: $obj.data("coord-x"),
				y: $obj.data("coord-y"),
				z: $obj.data("coord-z"),
				width: $obj.data("width"),
				height: $obj.data("height")
		};

		//First validation - Z-Index
		if (mobValues.z > objValues.z) {		
			//Second validation - Float Position

			//mobValues X
			for (mvX = mobValues.x; mvX < (mobValues.x + mobValues.width); mvX++) {
				//mobValues Y
				for (mvY = mobValues.y; mvY < (mobValues.y + mobValues.height); mvY++) {
					//objValues X
					for (ovX = objValues.x; ovX < (objValues.x + objValues.width); ovX++) {
						//objValues Y
						for (ovY = objValues.y; ovY < (objValues.y + objValues.height); ovY++) {
							//Check if they are in the same level
							if (mvX == ovX && mvY == ovY) {
								return (true);
							}
						}
					}
				}
			}
		}

		return (false);
	}

	self.rotateObjectAction = function(oject, directionEnum) {
		//get current rotate
		var rotate = oject.data("rotate");
		var offset = {
				top: oject.data("coord-y") * self.scale,
				left: oject.data("coord-x") * self.scale
		};

		if(rotate == 0 && directionEnum == self.DirectionEnum.LEFT){
			rotate = self.maxRotation;	
		}

		//sum the default degree
		rotate = calculateRotateObject(directionEnum, rotate);

		//check the greater value for Rotation
		rotate = self.normalizeAngle(rotate);

		//store the new value
		oject.data("rotate", rotate);

		//move the object
		self.moveObj(oject, offset, rotate);
	}

	var calculateRotateObject = function(directionEnum, rotate){
		switch (directionEnum) {
		case self.DirectionEnum.LEFT:
			rotate -= self.params.rotationDegrees;
			break;
		case self.DirectionEnum.RIGHT:
			rotate += self.params.rotationDegrees;
			break;
		default:
			break;
		}
		return rotate;
	}

	self.normalizeAngle = function(angle) {
		if (angle >= self.maxRotation) {
			angle = 0;
		}
		return angle;
	}
	
};
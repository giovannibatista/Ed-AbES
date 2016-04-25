navegacao = null;
$(window).load(function() {
	var idMapa = document.getElementById("idMapa").value;
	var $mapa = $("#mapa");

	//Instanciate the Map
	var $mapaNavegacao = new Mapa($mapa);

	$.ajax({
		url: "/Navegacao/Mapa/Objetos/" + idMapa,
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
					pontoInicial : value.pontoInicial
				});
			});
			//Instanciate the navigation
			navegacao = new Navegacao($mapaNavegacao);
		},
		error: function() {
			alert("Erro ao ler os objetos do mapa. Por favor, contate o administador!");
		}
	});

	//initiate the map
	$mapaNavegacao.init();
});


var Mapa = function($navigationMap){
	var self = this;

	var $mapRelative = $navigationMap;
	var $map = null;

	self.maxRotation = 360;

	//Custom parameters
	self.params = {
			initialScale: 32,
			rotationDegrees: 90,
			zindex: 8000
	};
	
	self.objetoInicial = null;

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
			x : objectProperties.x,
			y : objectProperties.y
		});
		
		
		var offset = {
				left: objectProperties.x * self.scale,
				top: objectProperties.y * self.scale
		};


		_addMob($obj, offset, (objectProperties.id == 0));
	}

	var _addMob = function($obj, offset, isNew) {
		var imageSrc = $obj.data("image");
		var width = $obj.data("width");
		var height = $obj.data("height");
		var objeto = $obj.data("objeto");
		var id = $obj.data("id");
		var title = $obj.data("title");
		var nome = $obj.data("nome");
		var rotate = $obj.data("rotate");
		var profundidade = $obj.data("profundidade");
		var arquivoAudio = $obj.data("arquivoAudio");
		var pontoInicial = $obj.data("pontoInicial");

		//create the mob
		var $mob = $("<div />");
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
			arquivoAudio: arquivoAudio
		});
		
		

		/*//bind events
		$mob.bind("click", function() {
			var $obj = $(this);

			_selectObj($obj);
		});
		 */
		//append into map body
		$map.append($mob);

		//move to desired position
		self.moveObj($mob, offset, rotate);

		
		if(pontoInicial == true){
			console.log("x " + $mob.data("coord-x") + "y " + $mob.data("coord-y"));
			self.objetoInicial = $mob;
		}

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

	/*var _selectObj = function($obj) {
		if ($obj.is(self.objSelection)) {
			return;
		}

		_unSelectObj();

		//append reference for new selected one
		self.objSelection = $obj;

		//add opacity class
		self.objSelection.addClass("objSelected");

		//initiate the helper options
		_createOptionHelpers($obj);

		//make it draggable
		self.objSelection.draggable({
			zIndex: 10000,
			start: function(event, ui) {
				var $obj = $(this);

				//clear the translate
				$obj.css({
					transform: "translate3d(0, 0, 0)"
				});
			},
			stop: function(event, ui) {
				//get left and top
				var pos = ui.position;

				//move the obj
				self.moveObj(self.objSelection, pos, self.objSelection.data("rotate"));
			}
		});
	}*/

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
};
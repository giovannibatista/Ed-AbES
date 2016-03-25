var MapEdAbES = function($mapaObject, $thumbnail) {
	console.log($mapaObject);
	console.log($thumbnail);
	debugger;
	var self = this;

	var $mapRelative = $mapaObject;
	var $map = null;
	var $thumbs = $thumbnail;

	//Greatest rotation degree value
	self.max_rotation = 360;

	//edit objcts
	var $editObj = {
			modal: $("#editModal"),
			input: $("#titleEditModal"),
			action: $("#btnEditModal"),
			audios: $("#audios"),
			idAudio: $("#idArquivoAudio")
	};

	//Custom parameters
	self.params = {
			keyboardNavation: true,
			mouseMoveNavigation: true,
			zoom: true,
			droppable: true,
			initialScale: 32,
			rotationDegrees: 90,
			zindex: 8000
	};

	//Object Status
	self.status = {
			NEW: 1,
			UPDATE: 2,
			DELETE: 3
	};

	/*
	 * Initiates the Map
	 */
	self.init = function(params) {
		//Extend options
		debugger;
		self.params = $.extend(self.params, params);

		self.x = self.y = 0;

		self.higherZIndex = 0;

		self.scale = self.params.initialScale;

		self.objSelection = null;

		//Create inner map object
		_createInnerMap();

		//Create dropper helper
		_createDropperHelper();

		//Enable window events
		_bindWindowEvents();

		return (self);
	};

	/*
	 * Export all Mobs into JSON object (only with the relevant data)
	 * @return List of mobs
	 */
	self.exportMobs = function() {
		var mobs = new Array();

		$(".mobs").each(function() {
			var $obj = $(this);
			
			console.log("->" + $obj.data("idArquivoAudio"));
			
			mobs.push({
				"idMapaObjeto": $obj.data("id"),
				"coordenadaX": $obj.data("coord-x"),
				"coordenadaY": $obj.data("coord-y"),
				"profundidade": $obj.data("coord-z"),
				"idObjeto": $obj.data("idObjeto"),
				"altura": $obj.data("height"),
				"largura": $obj.data("width"),
				"audioDescricao": $obj.data("title"),
				"operacao": $obj.data("status"),
				"nome": $obj.data("nome"),
				"angulo": $obj.data("rotate"),
				"idArquivoAudio": $obj.data("idArquivoAudio")
			});
		});

		return (mobs);
	}

	/*
	 *  objectProperties = {
	 *  	height = Integer,
	 *  	width = Integer,
	 *  	idObject = Integer,
	 *  	image = String,
	 *  	x = Integer,
	 *  	y = Integer,
	 *  	z = Integer,
	 *  	title = String,
	 *  	id = Integer,
	 *  	rotate = Integer
	 *  }
	 */
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
			arquivoAudio : objectProperties.arquivoAudio
		});

		var offset = {
				left: objectProperties.x * self.scale,
				top: objectProperties.y * self.scale
		};

		_addMob($obj, offset, (objectProperties.id == 0));
	}

	var _createInnerMap = function() {
		//create new object
		$mobs = $("<div />");
		$mobs.attr("id", "mapa_mobs");

		//append into map
		$mapRelative.append($mobs);

		//store the reference
		$map = $("#mapa_mobs");
	}

	var _moveTo = function(x, y, animation) {
		$map.css({
			transform: "translate3d("+x+"px, "+y+"px, 0)",
			transition : animation ? "0.5s ease-in-out" : ""
		});
	};

	var _createDropperHelper = function() {
		//create the object
		var $helper = $("<div />");
		$helper.attr("id", "dropperHelper");

		//append into the map
		$mapRelative.append($helper);

		//create the helper object
		self.dropperHelper = {
				flag: false,
				instance: $("#dropperHelper"),
				dropPositions : null,
				x: -1,
				y: -1
		};
	}

	var _hideDropperHelper = function() {
		self.dropperHelper.instance.css({
			"width" : 0,
			"height": 0
		});

		self.dropperHelper.flag = false;
		self.dropperHelper.x = -1;
		self.dropperHelper.y = -1;
		self.dropperHelper.dropPositions = null;
	}

	var _moveDropperHelper = function($obj, offset) {
		var width = $obj.data("width");
		var height = $obj.data("height");

		var dropPosition = {
				left: (parseInt(offset.left/self.scale) - 11) * self.scale,
				top: (parseInt(offset.top/self.scale) - 3) * self.scale
		};

		//check if the helper is already in the expected position
		if (dropPosition.left == self.dropperHelper.x &&
				dropPosition.top == self.dropperHelper.y) {
			return;
		}

		//append the new values
		self.dropperHelper.x = dropPosition.left;
		self.dropperHelper.y = dropPosition.top;

		//move the helper to the drop position
		self.dropperHelper.instance.css({
			width: self.scale * width,
			height: self.scale * height,
			transform: "translate3d("+(self.dropperHelper.x)+"px, "+(self.dropperHelper.y)+"px, 0)"
		});
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
		console.log(arquivoAudio);

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
			status: (isNew ? self.status.NEW : self.status.UPDATE),
			title: title,
			nome: nome,
			rotate: rotate,
			"coord-z": profundidade,
			arquivoAudio: arquivoAudio
		});

		//bind events
		$mob.bind("click", function() {
			var $obj = $(this);

			_selectObj($obj);
		});

		//append into map body
		$map.append($mob);

		//move to desired position
		_moveObj($mob, offset, rotate);
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

	var _drawBorder = function($obj, shouldDraw) {
		$obj.toggleClass("floatingObject", shouldDraw);
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

	var _moveObj = function($obj, offset, rotate) {
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
		_checkAllFloatPositions();
	}

	var _createOptionHelpers = function($obj) {
		var $helper = $("<div />");
		$helper.addClass("helperOptions");

		//Edit
		$helper.append(_createOptionHelperAction(
				MapEdAbES_Resources.labels.edit, 
				"glyphicon-pencil",
				function($btn) {
					_editObjectAction($btn, $obj);
				}
		));

		//Rotate
		$helper.append(_createOptionHelperAction(
				MapEdAbES_Resources.labels.rotate, 
				"glyphicon-repeat",
				function($btn) {
					_rotateObjectAction($btn, $obj);
				}
		));

		//Resize
		$helper.append(_createOptionHelperAction(
				MapEdAbES_Resources.labels.resize, 
				"glyphicon-resize-full",
				function($btn) {
					_resizeObjectAction($btn, $obj);
				}
		));

		//Duplicate
		$helper.append(_createOptionHelperAction(
				MapEdAbES_Resources.labels.duplicate, 
				"glyphicon-duplicate",
				function($btn) {
					_duplicateObjectAction($btn, $obj);
				}
		));

		//Delete
		$helper.append(_createOptionHelperAction(
				MapEdAbES_Resources.labels.exclude, 
				"glyphicon-trash",
				function($btn) {
					_deleteObjectAction($btn, $obj);
				}
		));

		$obj.append($helper);
	}

	/*
	 *  Object actions down here
	 */
	var _deleteObjectAction = function($btn, $obj) {
		//Ask the user if he really wants to exclude the object
		if (!confirm(MapEdAbES_Resources.confirms.exclude)) {
			return;
		}

		//check if the object does already exists in the database
		if ($obj.data("id") != 0) {
			//If does exists, we should change the status
			$obj.data({
				status: self.status.DELETE
			});

			//Hide from the user
			$obj.hide();
		}
		else {
			//Otherwise, just remove it
			$obj.remove();
		}
	}

	var _duplicateObjectAction = function($btn, $obj) {
		//get object properties
		var objectProperties = {
				//remove the ID
				id: 0,

				//add 1 position to the right
				x: $obj.data("coord-x") + 1,

				//get Y position
				y: $obj.data("coord-y"),

				//just copy the other properties
				image: $obj.data("image"),
				width: $obj.data("width"),
				height: $obj.data("height"),
				idObject: $obj.data("idObjeto"),
				title: $obj.data("title"),
				nome: $obj.data("nome"),
				rotate: $obj.data("rotate")
		};

		self.addMob(objectProperties);
	}

	var _rotateObjectAction = function($btn, $obj) {

		//get current rotate
		var rotate = $obj.data("rotate");
		var offset = {
				top: $obj.data("coord-y") * self.scale,
				left: $obj.data("coord-x") * self.scale
		};

		//sum the default degree
		rotate += self.params.rotationDegrees;

		//check the greater value for Rotation
		if (rotate >= self.max_rotation) {
			rotate = 0;
		}

		//store the new value
		$obj.data("rotate", rotate);

		//move the object
		_moveObj($obj, offset, rotate);
	}

	var _resizeObjectAction = function($btn, $obj) {
		//check if the resize is already active
		if ($btn.hasClass("active")) {
			//In case it is, destroy the resizable
			$obj.resizable("destroy");
		}
		else {
			//In case it is not, open the resizable
			$obj.resizable({
				grid: [self.scale, self.scale],
				minHeight: self.scale,
				minWidth: self.scale,
				resize: function(event, ui) {
					_resizeObject($obj, ui.size);
				}
			});
		}

		//toggle the active
		$btn.toggleClass("active");
	}

	var _resizeObject = function($obj, position) {
		//save the relative values
		$obj.data({
			height: (position.height / self.scale),
			width: (position.width / self.scale)
		});

		//update the background
		$obj.css({
			"background-size": (position.width + "px") + " " + (position.height + "px")
		});

		//check if it is in front of another mob
		_checkAllFloatPositions();
	}

	var _editObjectAction = function($btn, $obj) {
		//get the most updated title
		var title = $obj.data("title");
		var audio = $obj.data("arquivoAudio");

		if(audio){
			_selecionarAudioSelect(audio);
		}
		//update the title
		$editObj.input.val(title);

		//open the dialog
		$editObj.modal.modal("show");

		//bind the action 
		$editObj.action.unbind("click").bind("click", function() {
			//Update the object title
			var audios = document.getElementById("audios");
			$obj.data({
				title: $editObj.input.val(),
				idArquivoAudio: audios.options[audios.selectedIndex].value 
			});

			//hide the dialog
			$editObj.modal.modal("hide");
		});
	}

	var _selecionarAudioSelect = function(audio){
		var audios = document.getElementById("audios");

		for(var index = 1 ; index < audios.length;index++){
			var id = audios[index].value;
			if(audio.id == id){
				audios[index].selected = 'selected';
				break;
			}
		}

	}

	var _createOptionHelperAction = function(title, iconClass, callBack) {
		var $btn = $("<button />")
		.addClass("btn")
		.addClass("btn-default")
		.attr({
			title: title
		})
		.bind("click", function() {
			callBack($btn);
		});

		var $span = $("<span />")
		.addClass("glyphicon")
		.addClass(iconClass);

		//append into <a>
		$btn.append($span);

		return ($btn);
	}

	var _selectObj = function($obj) {
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
				_moveObj(self.objSelection, pos, self.objSelection.data("rotate"));
			}
		});
	}

	var _unSelectObj = function() {
		if (self.objSelection != null) {
			//kill draggable
			if (self.objSelection.hasClass("ui-draggable")) {
				self.objSelection.draggable("destroy");
			}

			//kill resizable
			if (self.objSelection.hasClass("ui-resizable")) {
				self.objSelection.resizable("destroy");
			}

			//clear opacity
			self.objSelection.removeClass("objSelected");

			//clear the helper
			self.objSelection.empty();

			//clear the reference
			self.objSelection = null;
		}
	}

	var _isAnyObjectSelected = function() {
		return (self.objSelection != null);
	}

	var _bindWindowEvents = function () {
		//In case the Droppable is enable
		if (self.params.droppable) {
			$thumbs.draggable({
				revert: true,
				zIndex: 10000,
				scroll: false,
				drag: function(event, ui) {
					/*if (self.dropperHelper.flag) {
						var position = {
							left: ui.offset.left,
							top: ui.offset.top
						};

						//move the dropper helper
						_moveDropperHelper(ui.helper, position);
					}*/
				}
			});

			$map.droppable({
				accept : $thumbs,
				drop : function(event, ui) {
					var $obj = $(this);
					var position = {
							left: ui.offset.left - $obj.offset().left,
							top: ui.offset.top - $obj.offset().top
					};

					//hide the dropper helper
					//_hideDropperHelper();

					_addMob(ui.draggable, position, true);
				},
				over : function(event, ui) {
					var $obj = $(this);
					var position = {
							left: ui.offset.left - $obj.offset().left,
							top: ui.offset.top - $obj.offset().top
					};

					self.dropperHelper.flag = true;
					self.dropperHelper.dropPositions = position;

				},
				out : function(event, ui) {
					//hide the dropper helper
					//_hideDropperHelper();
				}
			});
		}

		//In case the keyboard navigation is enabled
		if (self.params.keyboardNavation) {
			$(window).bind("keydown", function(e) {
				switch (e.keyCode) {
				case 27: //ESC 						
					//cancel any obj selection
					_unSelectObj();

					break;

				case 39: //Arrow Right
					break;

				case 40: //Arrow Down
					break;

				case 37: //Arrow Left
					break;

				case 38: //Arrow Up
					break;
				}
			});
		}

		//In case the mouse move navigation
		if (self.params.mouseMoveNavigation) {
			// Drag & drop
			$map.on('mousedown', function(event) {
				if (_isAnyObjectSelected()) {
					return (false);
				}

				self.dragging = false;

				$map.data('mouseX', event.pageX);
				$map.data('mouseY', event.pageY);
				$map.data('lastX', self.x);
				$map.data('lastY', self.y);

				$map.addClass('map-dragging');

				$map.on('mousemove', function(event) {
					self.dragging = true;

					var x = event.pageX - $map.data('mouseX') + self.x;
					var	y = event.pageY - $map.data('mouseY') + self.y;

					_moveTo(x, y);

					$map.data('lastX', x);
					$map.data('lastY', y);

				});

				$(document).on('mouseup', function(event) {
					self.x = $map.data('lastX');
					self.y = $map.data('lastY');

					$map.off('mousemove');
					$(document).off('mouseup');

					$map.removeClass('map-dragging');

					//normalize
					if (self.x > 0) self.x = 0;
					if (self.y > 0) self.y = 0;

					_moveTo(self.x, self.y, true);
				});
			});
		}
	};
};
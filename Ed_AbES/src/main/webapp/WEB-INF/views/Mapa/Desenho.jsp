<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Ed-AbES - Desenho do Mapa</title>
		<jsp:include page="../Head.jsp" />
		
		<link href="/resources/css/jquery-ui.min.css" type="text/css" rel="stylesheet" />
		<link href="/resources/css/MapEdAbES.css" type="text/css" rel="stylesheet">
	</head>
	<body>
	<div class="content">
			<div id="mainMenu">
				<jsp:include page="../Menu.jsp" />
			</div>
			<div id="mainBody">
				<div class="col-md-12">
					<div class="col-md-12">
						<h1>${nomeMapa}</h1>
						<input type="hidden" id="tipoMapa" value="${tipoMapa}"/>
					</div>
					<div class="col-md-3">
						<div class="clearfix">
							<a href="/Mapa/Editar/${idMapa}" class="btn btn-warning col-md-5 col-xs-12">Voltar</a>
							<button id="saveMap" class="btn btn-success col-md-6 col-md-offset-1 col-xs-12" type="button">Salvar o mapa</button>
							<button id="andarBtn" type="button" onclick="criar();">Criar</button>
							<button id="andarBtn" type="button" onclick="andar();">Andar</button>
							<button id="andarBtn" type="button" onclick="andar2();">Andar 2</button>
							
						</div>
						<br />
						<jsp:include page="_IncDesenhoMenu.jsp" />
					</div>
					<div class="col-md-9">
						<div id="mapa"></div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="editModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title">Descrição do objeto<img class="runTimeTranslationObject" style="padding-left: 8px; padding-bottom: 3px;" src="/resources/img/icone_som.png"></img></h4>
					</div>
					<div class="modal-body">
						<label class="control-label">O texto abaixo corresponde a descrição textual que será lida no módulo de navegação.</label>
					</div>
					<div class="modal-body">
						<input type="text" class="form-control" name="titleEditModal" id="titleEditModal" placeholder="Ex: Este é o armário da cozinha." required />
						<label>Anexar arquivo de áudio: </label>
						<input type="hidden" hidden="true" class="form-control" name="idArquivoAudio" id="idArquivoAudio" /> 
						<select class="form-control" name="audios" id="audios">
							<option value="">Selecione...</option>
							<c:forEach items="${listaAudios}" var="audio">
								<option value="${audio.id}">${audio.arquivo.name} - ${audio.descricao}</option>
						</c:forEach>
						</select>
					</div>
					<div class="modal-footer">
						<div class="row text-right">
							<div class="col-md-12">
								<button id="btnEditModal" type="submit" class="btn btn-success"><img src="/resources/img/icon_check.png" /> &nbsp; Salvar</button>
								<button id="btn-signup-cancel" type="button" class="btn btn-danger" data-dismiss="modal"><img src="/resources/img/icon_cancel.png" /> &nbsp; Cancelar</button> 
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript" src="/resources/js/MapEdAbES.pt-br.js" charset="UTF-8"></script>
		<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="/resources/js/MapEdAbES.js"></script>
		<script type="text/javascript">		
			$(function() {
				var $thumbs = $("a.thumbnail");
				var $mapa = $("#mapa");
				var $saveMap = $("#saveMap");
				
				//Instanciate the Map
				var $mapEdAbes = new MapEdAbES($mapa, $thumbs);
				
				//Constant message
				var noTitleAlert = "O objeto do tipo %s não possui audiodescrição. Deseja salvar o mapa mesmo assim?";
				
				$saveMap.unbind("click").bind("click", function() {
					var mobs = $mapEdAbes.exportMobs();
					var objetoSemAudioDescricao = false;
					var nomeObjetoSemAudioDescricao;
					
					$.each(mobs, function(key, value) {
						if(!value.audioDescricao) {
							objetoSemAudioDescricao = true;
							nomeObjetoSemAudioDescricao = value.nome;
							//exit foreach statement
							return;
						} 
					});
					
					//In case all the objects are with titles, OR
					//In case you have confirmed that you accept saving the map without a description
					if(!objetoSemAudioDescricao || 
						confirm(noTitleAlert.format(nomeObjetoSemAudioDescricao))) {
						console.log(mobs);
						var tipoMapa = $("#tipoMapa").val();
						var salvarMapaLivre = "";
						if(tipoMapa == 2){
							if(confirm("Deseja salvar o mapa também do tipo LIVRE?")){
								salvarMapaLivre = "sim";
							}
						}
						$.ajax({
							url: "/Mapa/Desenho/Salvar/${idMapa}",
							type: "POST",
							dataType: "json",
							contentType: "application/json",
							data : JSON.stringify({
								dtoList: mobs, teste: 'sim'
							})
							,
							success: function(success) {
								alert(success ? "Mapa salvo com sucesso." : "Erro ao salvar o mapa.");
								
								if (success) {
									document.location = document.location;
								}
							},
							error: function() {
								alert("Erro ao requisitar função AJAX. Por favor, contate o administrador.");
							}
						});
					}
					
				});
				
				//triggers only when the DOM is loaded
				$(window).load(function() {
					$.ajax({
						url: "/Mapa/Objetos/${idMapa}",
						type: "GET",
						dataType: "json",
						success: function(json) {
							 console.log('json->' + json);
							//for each saved object, we should add individually in the map
							$.each(json, function(key, value) {
								$mapEdAbes.addMob({
									height: value.altura,
									 width: value.largura,
									 idObject: value.idObjeto,
									 image: value.imagemMapa,
									 x: value.coordenadaX,
									 y: value.coordenadaY,
									 z: value.profundidade,
									 title: value.audioDescricao,
									 nome: value.nome,
									 id: value.idMapaObjeto,
									 rotate : value.angulo,
									 arquivoAudio : value.arquivoAudio
								});
							});
						},
						error: function() {
							alert("Erro ao ler os objetos do mapa. Por favor, contate o administador.");
						}
					});
				});
				
				//initiate the map
				$mapEdAbes.init();
				
				

			});
			
			var $mob = $("<div />");
			function criar() {
				debugger;
					
					$mob.addClass("mobs");
					$mob
							.css({
								"background-image" : "url(/resources/img/bg-64x64-red.jpg)",
								"background-size" : "32px 32px",
								width : 32,
								height : 32
							});

					//Get the deserved z-index based on the object status (NEW or UPDATE)
					profundidade = 20;

					//append characteristics
					$mob.data({
						id : 99,
						image : "/resources/img/bg-64x64-red.jpg",
						idObjeto : 99,
						width : 1,
						height : 1,
						status : 1,
						title : "ANDAR",
						nome : "ANDAR TESTE",
						rotate : 0,
						"coord-z" : 20,
						arquivoAudio : undefined
					});

					var offset = {
						left : 0,
						top : 0
					};
					var $map = $("#mapa_mobs");
					$map.append($mob);
				
					var rotate = 0;
					
					_moveObj($mob, offset, rotate);

				}
			
			var _moveObj = function($obj, offset, rotate) {
				var profundidade = $obj.data("coord-z");

				//normalize positions
				offset.top = ((offset.top > 0) ? offset.top : 0);
				offset.left = ((offset.left > 0) ? offset.left : 0);

				//calculate relative position
				var pos = {
						left: parseInt(offset.left/32),
						top: parseInt(offset.top/32)
				};

				//move to absolute position
				$obj.css({
					transform: "translate3d("+ (pos.left * 32) +"px, "+ (pos.top * 32) +"px, 0) rotate("+rotate+"deg)",
					left: 0,
					top: 0,
					zIndex: 20
				});

				//append characteristics
				$obj.data({
					"coord-x": pos.left,
					"coord-y": pos.top
				});
			}
			
			function andar(){
				var offset = {
						top: $mob.data("coord-y") * 32 + 32,
						left: $mob.data("coord-x") * 32
				};
				
				var rotate = 0;
				
				_moveObj($mob, offset, rotate);
			}
			
			function andar2(){
				var offset = {
						top: $mob.data("coord-y") * 32 ,
						left: $mob.data("coord-x") * 32 + 32
				};
				
				var rotate = 0;
				
				_moveObj($mob, offset, rotate);
			}
			

		</script>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
					</div>
					<div class="col-md-3">
						<div class="clearfix">
							<a href="/Mapa/Editar/${idMapa}" class="btn btn-warning col-md-5 col-xs-12">Voltar</a>
							<button id="saveMap" class="btn btn-success col-md-6 col-md-offset-1 col-xs-12" type="button">Salvar o mapa</button>
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
						<input type="file" class="form-control" name="audioFile" id="audioFile" accept="audio/*"  />
							<input type="file" class="form-control" name="audioFile" id="audioFile" accept="audio/*"  /> 
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
						debugger;
						console.log(mobs);						
						$.ajax({
							url: "/Mapa/Desenho/Salvar/${idMapa}",
							type: "POST",
							dataType: "json",
							contentType: "application/json",
							data : JSON.stringify({
								dtoList: mobs
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
									 rotate : value.angulo
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
		</script>
	</body>
</html>
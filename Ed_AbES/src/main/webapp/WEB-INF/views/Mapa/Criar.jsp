<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
	<head>
		<title>Ed-AbES - Criação de mapa</title>
		
		<jsp:include page="../Head.jsp" />
	</head>
	<body>
		<div class="content">
			<div id="mainMenu">
				<jsp:include page="../Menu.jsp" />
			</div>
			<div id="mainBody">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="panel panel-info">
							<div class="panel-heading">
								<div class="panel-title">Novo mapa<a style="padding-left: 10px;" href="javascript: void(0);" onClick="$('#modalDicas').modal('show')"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span></a></div>
							</div>
							<div class="panel-body">
								<form id="formularioCriarMapa" class="form-horizontal" role="form" method="POST">
									<div class="form-group">
										<label class="col-md-8"><font color="red">Todas as informações são de preenchimento obrigatório.</font></label>
									</div>
									<div class="form-group">
										<label for="nomeMapa" class="col-md-4 control-label">Nome do mapa:</label>
										<div class="col-md-8">
											<input id="nomeMapa" type="text" class="form-control" name="nomeMapa"
												placeholder="Ex: Salão de festas" maxlength="20" required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Descrição:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="descricaoMapa"
												name="descricaoMapa" placeholder="Ex: Este mapa representa o salão de festas do condomínio X." required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Objetivo:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="objetivoMapa"
												name="objetivoMapa" placeholder="Ex: O objetivo deste mapa é chegar na cozinha." required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Unidade de medida:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="unidadeDeMedida"
												name="unidadeDeMedida" placeholder="Ex: Passos, quilômetros, metros..." required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Andar: </label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="andar"
												name="andar" placeholder="Ex: Primeiro, Segundo..." required onblur="ativaAtalhos()" onfocus="desativaAtalhos()"/>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-9 col-md-offset-4">
											<div class="btn-group" data-toggle="buttons">
												<label class="btn btn-primary active">
													<input type="radio" name="tipoMapa" autocomplete="off" value="1" checked> Navegação Livre
												</label>
												<label class="btn btn-primary">
													<input type="radio" name="tipoMapa" autocomplete="off" value="2"> Desafio
												</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<!-- Button -->
										<div class="col-md-offset-3 col-md-9 text-right">
											<button type="submit" class="btn btn-success">
												<img src="/resources/img/icon_check.png" /> &nbsp Salvar
											</button>
		
											<button id="formularioCancelButton" type="button" class="btn btn-danger">
												<img src="/resources/img/icon_cancel.png" /> &nbsp Cancelar
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="modalDicas" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="mateushaas" action="Sobre" method="POST">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Recomendações para criação de ambientes<a href="javascript: void(0);"><img class="runTimeTranslation" title="Recomendassoes para criassao de ambientes. 1. Identificar o sujeito, objeto ou cena a ser descrita. 2. Localizar o sujeito, objeto ou cena a ser descrita. 3. Empregar adjetivos para qualificar o sujeito, objeto ou cena da descrisao. 4. Descrever as circunstancias da assao. 5. Verificar a correspondancia entre a imagem e o texto, a fim de garantir a fidedignidade da descrissao. 6. Usar termos adequados, a area de conhecimento, abordada na descrissao. 7. Identificar os elementos relevantes, levando-se em considerassao aspectos historicos e culturais. 8. Organizar os elementos descritivos em um todo significativo. Evitar deixar elementos soltos, inserindo-os em um mesmo periodo. Comessar pelo personagem ou objeto mais significativo, qualificalo, localizalo, qualificar o onde, explicitar o tempo. 9. Mencionar cores e demais detalhes. 10. Usar o tempo verbal sempre no presente. 11. Discriminar, na descrissao de paisagens, as urbanas das campestres ou maritimas, as paisagens naturais das humanizadas. 12. Minimizar a introdussao de elementos de formatassao e cor, pois estes contribuem para disperssao no entendimento. 13. Empregar verbos para descrever a assao e adverbio para." style="padding-left: 8px; padding-bottom: 3px;" src="/resources/img/icone_som.png"></img></a></h4>
					</div>
					<div class="modal-body">
						<ul>
						  <li>Identificar o sujeito, objeto ou cena a ser descrita (O que/quem).</li>
						  <li>Localizar o sujeito, objeto ou cena a ser descrita (Onde). </li>
						  <li>Empregar adjetivos para qualificar o sujeito, objeto ou cena da descrição (Como).</li>
						  <li>Descrever as circunstâncias da ação - Faz o que/como. </li>
						  <li>Verificar a correspondência entre a imagem e o texto, a fim de garantir a fidedignidade da descrição. </li>
						  <li>Usar termos adequados, à área de conhecimento, abordada na descrição. </li>
						  <li>Identificar os elementos relevantes, levando-se em consideração aspectos históricos e culturais.</li>
						  <li>Organizar os elementos descritivos em um todo significativo. Evitar deixar elementos soltos, inserindo-os em um mesmo período. Começar pelo personagem ou objeto mais significativo (o que/quem), qualificá-lo (como), localizá-lo (onde), qualificar o onde (como), explicitar o tempo (quando). </li>
						  <li>Mencionar cores e demais detalhes. </li>
						  <li>Usar o tempo verbal sempre no presente. </li>
						  <li>Discriminar, na descrição de paisagens, as urbanas das campestres ou marítimas, as paisagens naturais das humanizadas. </li>
						  <li>Minimizar a introdução de elementos de formatação e cor, pois estes contribuem para dispersão no entendimento.</li>
						  <li>Empregar verbos para descrever a ação e advérbio para. </li>
						  
						</ul>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" onclick="hideModal('modalSobre');" data-dismiss="modal"><img src="/resources/img/icon_cancel.png" /> &nbsp Fechar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
		
		 <script type="text/javascript" src="/resources/js/Atalhos_teclado/criar_keyboard.js"></script>
		<script type="text/javascript" src="/resources/js/CriarMapa/Form.js" charset="UTF-8"></script>
	</body>
</html>
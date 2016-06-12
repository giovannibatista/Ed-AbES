<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
	<head>
		<title>Ed-AbES - Edição de mapa</title>

		<jsp:include page="../Head.jsp" />

		<script type="text/javascript" src="/resources/js/EditarMapa/Form.js" charset="UTF-8"></script>
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
								<div class="panel-title">${caracteristicas.nomeMapa}</div>
							</div>
							<div class="panel-body">
								<form id="formularioEditarMapa" class="form-horizontal" role="form" method="POST">
									<input type="hidden" name="idMapa" value="${caracteristicas.idMapa}" id="idMapa" />
									<div class="form-group">
										<label class="col-md-8"><font color="red">Todas as informações são de preenchimento obrigatório.</font></label>
									</div>
									<div class="form-group">
										<label for="nomeMapa" class="col-md-4 control-label">Nome do mapa:</label>
										<div class="col-md-8">
											<input id="nomeMapa" type="text" class="form-control" name="nomeMapa"
												placeholder="Ex: Salão de festas" value="${caracteristicas.nomeMapa}" maxlength="20" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Descrição:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="descricaoMapa"
												name="descricaoMapa" value="${caracteristicas.descricaoMapa}" placeholder="Ex: Este mapa representa o salão de festas do condomínio X." required />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Objetivo:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="objetivoMapa"
												name="objetivoMapa" value="${caracteristicas.objetivoMapa}" placeholder="Ex: O objetivo é chegar na cozinha. Ou o objetivo é navegar livremente no mapa." required />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Unidade de medida:</label>
										<div class="col-md-8">
											<p>Passos</p>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Pavimento:</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="andar"
												name="andar" value="${caracteristicas.andar}" placeholder="Ex: Primeiro, Segundo..." required"/>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-9 col-md-offset-4">
											<div class="btn-group" data-toggle="buttons">
												<c:choose>
													<c:when test="${caracteristicas.tipoMapa < 2}">
													  	<label class="btn btn-primary active">
															<input type="radio" id="tipoMapa" name="tipoMapa" autocomplete="off" value="1" checked="checked"> Navegação Livre
														</label>
														<label class="btn btn-primary">
															<input type="radio" id="tipoMapa" name="tipoMapa" autocomplete="off" value="2"> Desafio
														</label>
													</c:when>
													<c:otherwise>
												      	<label class="btn btn-primary">
															<input type="radio" id="tipoMapa" name="tipoMapa" autocomplete="off" value="1"> Navegação Livre
														</label>
														<label class="btn btn-primary active">
															<input type="radio" id="tipoMapa" name="tipoMapa" autocomplete="off" value="2" checked="checked"> Desafio
														</label>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</div>
									<div class="form-group">
										<!-- Button -->
										<div class="col-md-offset-3 col-md-9 text-right">
											<button type="submit" class="btn btn-success">
												<img src="/resources/img/icon_check.png" /> &nbsp; Salvar
											</button>
		
											<button id="formularioCancelButton" type="button" class="btn btn-danger">
												<img src="/resources/img/icon_cancel.png" /> &nbsp; Cancelar
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
	</body>
</html>
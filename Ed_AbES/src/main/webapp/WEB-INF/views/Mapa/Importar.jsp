<!DOCTYPE html> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="edabes.entidades.*"%>

<html lang="en">
	<head>
		<title>Ed-AbES - Importar mapas</title>
		
		<script type="text/javascript"> 
		function importarMapa(idMapa) {
			
			if (confirm("Deseja importar o mapa?")) {
				document.location = "/Mapa/Importar/" + idMapa;
			} else {
				return (false);	
			}
		}
		</script>
		
		<jsp:include page="../Head.jsp" />
	</head>
	<body>
		<div class="content">
			<div id="mainMenu">
				<jsp:include page="../Menu.jsp" />
			</div>
			<div id="mainBody">
				<div class="col-md-12">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="panel-title">Listagem de mapas habilitados</div>
						</div>
						<div class="panel-body">
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>Nome do Mapa</th>
										<th>Descrição</th>
										<th>Autor</th>
										<th>Data</th>
										<th>Tipo do Mapa</th>
										<th class="col-md-3">Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${lista}" var="mapa">
										<tr>
											<td>${mapa.nomeMapa}</td>
											<td>${mapa.descricaoMapa}</td>
											<td>${mapa.nomeCriador}</td>
											<td>${mapa.dataDeCriacao}</td>
											<c:choose> 
											  <c:when test="${mapa.tipoMapa == 1}">
											    <td>Navegação Livre</td>
											  </c:when>
											  <c:otherwise>
											    <td>Desafio</td>
											  </c:otherwise>
											</c:choose>
											
											<td>
												<a onclick="javascript:importarMapa(${mapa.mapaId})" class="btn btn-warning">Importar</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<c:if test="${mapaImportado == 'importado'}">
							<script type="text/javascript">
								alert("Mapa importado");
							</script>
						</c:if> 
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
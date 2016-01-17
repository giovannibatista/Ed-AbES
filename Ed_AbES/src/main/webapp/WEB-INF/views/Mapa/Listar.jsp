<!DOCTYPE html> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="edabes.entidades.*"%>

<html lang="en">
	<head>
		<title>Ed-AbES - Listar mapas</title>
		
		<script type="text/javascript"> 
		function excluirMapa(idMapa) {
			
			if (confirm("Deseja excluir o mapa?")) {
				document.location = "/Mapa/Excluir/" + idMapa;
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
							<div class="panel-title">Listagem de mapas</div>
						</div>
						<div class="panel-body">
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>Nome do Mapa</th>
										<th>Descrição</th>
										<th>Objetivo</th>
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
											<td>${mapa.objetivoMapa}</td>
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
												<a href="/Mapa/Editar/${mapa.mapaId}" class="btn btn-success">Editar</a>
												<c:if test="${mapa.importado == false}">
													<a href="/Mapa/Exportar/${mapa.mapaId}" class="btn btn-warning" target="_blank">Exportar</a>
												</c:if>
												<a onclick="javascript:excluirMapa(${mapa.mapaId})" class="btn btn-danger">Excluir</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<c:if test="${mapaExcluido == 'excluido'}">
							<script type="text/javascript">
								alert("Mapa excluido");
							</script>
						</c:if>
						<c:if test="${exportado == 'true'}">
							<script type="text/javascript">
								alert("Mapa exportado com sucesso");
							</script>
						</c:if>  
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
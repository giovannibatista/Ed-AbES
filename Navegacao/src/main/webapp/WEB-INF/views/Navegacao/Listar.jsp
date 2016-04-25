<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.edabes.dto.*"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Iniciar Navegação
	Públicos</title>
<jsp:include page="../Imports.jsp" />

<link rel="stylesheet"
	href="<c:url value="/resources/css/Navegacao/listar.css" />" >
	
<script>
	function abrirResumo(idMapa) {
		document.location = "/Navegacao/Resumo/" + idMapa;
	}
</script>

</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main" id="conteudo">
		<h1>Iniciar navegação</h1>
		<p>Para iniciar uma navegação, escolha um dos mapas salvos na
			tabela abaixo.</p>
		<p>Para navegar entre a lista de mapas salvos, utilize as teclas
			de atalho de navegação em tabelas. O uso do mouse também é permitido.
		</p>
		<p>Caso você não tenha nenhum mapa salvo, acesse a opção de menu
			"Mapas públicos", utilizando o atalho "Alt 2". Fazendo isto, você
			poderá verificar os mapas disponíveis e escolher um ou ou mais mapas
			para navegação. Para isto, selecione a opção "Salvar mapa" quando
			estiver na linha do mapa que desejar salvar. A tabela apresenta o
			Nome do Mapa, Descrição, Tipo do Mapa e Data de alteração.</p>

		<div id="mapasSalvosArea">
			<c:choose>
				<c:when test="${not empty mapas}">

					<table border="1" id="mapasSalvos" class="listas">
						<caption>Tabela dos mapas públicos salvos.</caption>
						<thead>
							<tr>
								<th scope="col">Nome do Mapa</th>
								<th scope="col">Descrição</th>
								<th scope="col">Tipo do Mapa</th>
								<th scope="col">Data de alteração</th>
								<th scope="col">Ações</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${mapas}" var="mapa">
								<tr onclick="javascript: abrirResumo(${mapa.id});">
									<th scope="row">${mapa.nome}</th>
									<td>${mapa.descricao}</td>
									<c:choose>
										<c:when test="${mapa.tipoMapa == 1}">
											<td>Navegação Livre</td>
										</c:when>
										<c:otherwise>
											<td>Desafio</td>
										</c:otherwise>
									</c:choose>
									<td>${mapa.dataAlteracao}</td>
									<td><input type="button" id="salvarMapaBotao"
										onclick="javascript: abrirResumo(${mapa.id});"
										value="Iniciar Navegação do ${mapa.nome}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<div id="blocoListaMapasVazio" class="blocoListaVazio">
						<p>Nenhum mapa salvo. Para iniciar uma navegação é necessário
							salvar um mapa público. Para acessar os Mpas Públicos, utilize a
							tecla de atalho Alt 2.</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>
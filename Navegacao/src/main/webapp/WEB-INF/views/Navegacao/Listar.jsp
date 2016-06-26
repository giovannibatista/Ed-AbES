<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.edabes.dto.*"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Iniciar Navega��o
	P�blicos</title>
<jsp:include page="../Imports.jsp" />

<link rel="stylesheet"
	href="<c:url value="/resources/css/Navegacao/listar.css" />">

<script>
	function abrirResumo(idMapa) {
		document.location = "/Navegacao/Resumo/" + idMapa;
	}
</script>

</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main" id="conteudo">
		<h1>Iniciar navega��o</h1>
		<p>Para iniciar uma navega��o, escolha um dos mapas salvos na
			tabela abaixo.</p>
		<p>Para navegar entre a lista de mapas salvos, utilize as teclas
			de atalho de navega��o em tabelas. O uso do mouse tamb�m � permitido.
		</p>
		<p>Caso voc� n�o tenha nenhum mapa salvo, acesse a op��o de menu
			"Mapas p�blicos", utilizando o atalho "Alt 2". Fazendo isto, voc�
			poder� verificar os mapas dispon�veis e escolher um ou mais mapas
			para salvar. Lembrando que para que a lista de mapas salvos apareca
			aqui � necess�rio estar logado no M�dulo de Navega��o.</p>

		<div id="mapasSalvosArea">
			<c:choose>
				<c:when test="${not empty mapas}">

					<table border="1" id="mapasSalvos" class="listas">
						<caption>Tabela dos mapas p�blicos salvos.</caption>
						<thead>
							<tr>
								<th scope="col">Nome do Mapa</th>
								<th scope="col">Descri��o</th>
								<th scope="col">Tipo do Mapa</th>
								<th scope="col">Data de altera��o</th>
								<th scope="col">A��es</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${mapas}" var="mapa">
								<tr onclick="javascript: abrirResumo(${mapa.id});">
									<th scope="row">${mapa.nome}</th>
									<td>${mapa.descricao}</td>
									<td>${mapa.descricaoTipoMapa}</td>
									<td>${mapa.dataAlteracao}</td>
									<td><input type="button" id="abriResumoBotao${mapa.id}"
										onclick="javascript: abrirResumo(${mapa.id});"
										value="Iniciar Navega��o do ${mapa.nome}"
										aria-label="Bot�o para iniciar navega��o do Mapa. Tecle Enter para abrir resumo do mapa." /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<div id="blocoListaMapasVazio" class="blocoListaVazio">
						<p>Nenhum mapa salvo. Para iniciar uma navega��o � necess�rio
							salvar um mapa p�blico. Para acessar os Mapas P�blicos, utilize a
							tecla de atalho Alt 2.</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<a href="#conteudo">Voltar para o topo</a>
	</div>
</body>
</html>
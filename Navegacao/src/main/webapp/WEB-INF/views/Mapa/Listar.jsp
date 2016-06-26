<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Listar Mapas
	P�blicos</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/Mapa/mapalistar.js" />"></script>

<link rel="stylesheet"
	href="<c:url value="/resources/css/Mapa/listar.css" />">

</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main" id="conteudo">
		<h1>Lista de Mapas P�blicos</h1>
		<p>Esta tela apresenta a lista dos mapas p�blicos disponibilizados
			pelos usu�rios do Ed-AbES - M�dulo de Constru��o para possam ser
			explorados no M�dulo de Navega��o. Para navegar entre a lista de
			mapas p�blicos, utilize as teclas de atalho de navega��o em tabelas.
			O uso do mouse tamb�m � permitido.</p>
		<p>Qualquer mapa listado aqui pode ser salvo para navega��o
			futura. Ao salvar um mapa, ele aparecer� na tela "Iniciar navega��o",
			que pode ser acessada pelo menu principal. Para salvar o mapa voc�
			pode pressionar a tecla Enter a qualquer momento da leitura da linha
			do mapa desejado. Caso voc� esteja logado no sistema, ao utilizar o
			recurso "Salvar Mapa", o mapa ser� salvo em seu perfil e poder�
			acessar futuramente o mapa diretamente no menu "Iniciar Navega��o".
			Caso voc� n�o esteja logado, o mapa ser� salvo para a navega��o,
			por�m ao fechar a aplica��o, perder� os mapas salvos.</p>

		<div id="mapasPublicosArea">

			<table border="1" id="mapasPublicos" class="listas">
				<caption>Tabela dos mapas p�blicos constru�dos no m�dulo
					de constru��o.</caption>
				<thead>
					<tr>
						<th scope="col">Nome do mapa</th>
						<th scope="col">Descri��o</th>
						<th scope="col">Tipo do mapa</th>
						<th scope="col">Data de altera��o</th>
						<th scope="col">A��es</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mapas}" var="mapa">
						<tr >
							<th onclick="javascript: salvarMapa(${mapa.id});" scope="row">${mapa.nome}</th>
							<td onclick="javascript: salvarMapa(${mapa.id});">${mapa.descricao}</td>
							<td onclick="javascript: salvarMapa(${mapa.id});">${mapa.descricaoTipoMapa}</td>
							<td onclick="javascript: salvarMapa(${mapa.id});">${mapa.dataAlteracao}</td>
							<td><input type="button" id="salvarMapaBotao${mapa.id}"
								onclick="javascript: salvarMapa(${mapa.id});"
								value="Salvar ${mapa.nome}"
								aria-label="Bot�o para salvar o Mapa. Tecle Enter para salvar." /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<a href="#conteudo">Voltar para o topo</a>
	</div>
</body>
</html>
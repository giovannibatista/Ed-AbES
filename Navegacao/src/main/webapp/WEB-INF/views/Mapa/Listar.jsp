<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Listar Mapas
	Públicos</title>
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
		<h1>Lista de Mapas Públicos</h1>
		<p>Esta tela apresenta a lista dos mapas públicos disponibilizados
			pelos usuários do Ed-AbES - Módulo de Construção para possam ser
			explorados no Módulo de Navegação. Para navegar entre a lista de
			mapas públicos, utilize as teclas de atalho de navegação em tabelas.
			O uso do mouse também é permitido.</p>
		<p>Qualquer mapa listado aqui pode ser salvo para navegação
			futura. Ao salvar um mapa, ele aparecerá na tela "Iniciar navegação",
			que pode ser acessada pelo menu principal. Para salvar o mapa você
			pode pressionar a tecla Enter a qualquer momento da leitura da linha
			do mapa desejado. Caso você esteja logado no sistema, ao utilizar o
			recurso "Salvar Mapa", o mapa será salvo em seu perfil e poderá
			acessar futuramente o mapa diretamente no menu "Iniciar Navegação".
			Caso você não esteja logado, o mapa será salvo para a navegação,
			porém ao fechar a aplicação, perderá os mapas salvos.</p>

		<div id="mapasPublicosArea">

			<table border="1" id="mapasPublicos" class="listas">
				<caption>Tabela dos mapas públicos construídos no módulo
					de construção.</caption>
				<thead>
					<tr>
						<th scope="col">Nome do mapa</th>
						<th scope="col">Descrição</th>
						<th scope="col">Tipo do mapa</th>
						<th scope="col">Data de alteração</th>
						<th scope="col">Ações</th>

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
								aria-label="Botão para salvar o Mapa. Tecle Enter para salvar." /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<a href="#conteudo">Voltar para o topo</a>
	</div>
</body>
</html>
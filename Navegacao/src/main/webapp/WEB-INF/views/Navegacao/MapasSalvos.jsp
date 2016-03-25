<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Iniciar Navegação
	Públicos</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/navegacao.js" />"></script>
</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main">
		<h1>Iniciar navegação</h1>
		<p>Para inicar uma navegação, escolha um dos mapas salvos. Para acessar utilize as teclas direcionais ou
			tabulação para navegar na tabela de mapas salvos...</p>

		<div id="mapasPublicosArea">
			<table border="1" id="mapasPublicos">
				<caption>Tabela dos mapas públicos salvos.</caption>
				<thead>
					<tr>
						<th scope="col">Nome do Mapa</th>
						<th scope="col">Descrição</th>
						<th scope="col">Objetivo</th>
						<th scope="col">Tipo do Mapa</th>
						<th scope="col">Andar</th>
						<th scope="col">Autor</th>
						<th scope="col">Data de criação</th>
						<th scope="col">Ações</th>

					</tr>
				</thead>
				<tbody>
					<tr onclick="javascript: abrirResumo(1);">
						<th scope="row" onclick="javascript: abrirResumo(1);">Mapa 1
						</td>
						<td>Descrição do mapa 1</td>
						<td>O Objetivo do mapa 1 é tal...</td>
						<td>Desafio</td>
						<td>Primeiro</td>
						<td>João</td>
						<td>19/03/2016</td>
						<td><input type="button" id="salvarMapaBotao"
								onclick="javascript: abrirResumo(1);" value="Iniciar Navegação do Mapa 1" /></td>
					</tr>
					<tr onclick="javascript: abrirResumo(2);">
						<th scope="row">Mapa 2
						</td>
						<td>Descrição do mapa 2 é tal...</td>
						<td>O Objetivo do mapa 2 é tal...</td>
						<td>Livre</td>
						<td>Segundo</td>
						<td>Maria</td>
						<td>01/02/2016</td>
						<td><input type="button" id="salvarMapaBotao"
								onclick="javascript: abrirResumo(2);" value="Iniciar Navegação do Mapa 2" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
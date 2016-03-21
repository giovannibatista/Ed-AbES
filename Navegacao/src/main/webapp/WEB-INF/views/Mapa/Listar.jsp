<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Listar Mapas
	P�blicos</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/mapalistar.js" />"></script>
</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main">
		<h1>Listar Mapas P�blicos...</h1>
		<p>Esta tela apresenta a lista dos mapas p�blicos disponibilizados
			pelos usu�rios. Para acessar utilize as teclas direcionais ou
			tabula��o para navegar na tabela de mapas p�blicos...</p>

		<div id="mapasPublicosArea">
			<table border="1" id="mapasPublicos">
				<caption>Tabela dos mapas p�blicos constru�dos no m�dulo
					de constru��o.</caption>
				<thead>
					<tr>
						<th scope="col">Nome do Mapa</th>
						<th scope="col">Descri��o</th>
						<th scope="col">Objetivo</th>
						<th scope="col">Tipo do Mapa</th>
						<th scope="col">Andar</th>
						<th scope="col">Autor</th>
						<th scope="col">Data</th>
						<th scope="col">A��es</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row" onclick="javascript: salvarMapa(1);">Mapa 1
						</td>
						<td>Descri��o do mapa 1</td>
						<td>O Objetivo do mapa 1 � tal...</td>
						<td>Desafio</td>
						<td>Primeiro</td>
						<td>Jo�o</td>
						<td>19/03/2016</td>
						<td><input type="button" id="salvarMapaBotao"
								onclick="javascript: salvarMapa(1);" value="Salvar Mapa 1"/></td>
					</tr>
					<tr>
						<th scope="row">Mapa 2
						</td>
						<td>Descri��o do mapa 2 � tal...</td>
						<td>O Objetivo do mapa 2 � tal...</td>
						<td>Livre</td>
						<td>Segundo</td>
						<td>Maria</td>
						<td>01/02/2016</td>
						<td><input type="button" id="salvarMapaBotao"
								onclick="javascript: salvarMapa(2);" value="Salvar Mapa 2" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
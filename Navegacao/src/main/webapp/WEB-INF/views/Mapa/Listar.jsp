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
	
<link rel="stylesheet" href="<c:url value="/resources/css/Mapa/listar.css" />">

</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main" id="conteudo">
		<h1>Listar mapas p�blicos...</h1>
		<p>Esta tela apresenta a lista dos mapas p�blicos
			disponibilizados pelos usu�rios do Ed-AbES. Para navegar entre a
			lista de mapas p�blicos, utilize as teclas de atalho de navega��o em
			tabelas. O uso do mouse tamb�m � permitido. Qualquer mapa listado
			aqui pode ser salvo para navega��o futura. Ao salvar um mapa, ele
			aparecer� na tela "Iniciar navega��o", que pode ser acessada pelo
			menu principal.</p>

		<div id="mapasPublicosArea">
			<table border="1" id="mapasPublicos">
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
					<tr onclick="javascript: salvarMapa(1);">
						<th scope="row" >Mapa 1
						</td>
						<td>Descri��o do mapa 1</td>
						<td>Desafio</td>
						<td>19/03/2016</td>
						<td><input type="button" id="salvarMapaBotao" alt="Bot�o para salvar o Mapa. Tecle Enter para salvar"
								onclick="javascript: salvarMapa(1);" value="Salvar Mapa 1"/></td>
					</tr>
					<tr onclick="javascript: salvarMapa(2);">
						<th scope="row" >Mapa 2
						</td>
						<td>Descri��o do mapa 2 � tal...</td>
						<td>Livre</td>
						<td>01/02/2016</td>
						<td><input type="button" id="salvarMapaBotao" alt="Bot�o para salvar o Mapa. Tecle Enter para salvar"
								onclick="javascript: salvarMapa(2);" value="Salvar Mapa 2" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
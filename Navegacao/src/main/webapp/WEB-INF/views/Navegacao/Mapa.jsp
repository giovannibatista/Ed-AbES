<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Navega��o no Mapa
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
		<h1>Navega��o no Mapa 1</h1>
		<p></p>
				
		<div id="acoesNavegacao">
			<h2>Comandos para navega��o</h2>
			<button id="encerrarNavegacaoBotao" onclick="javascript: ">Encerrar Navega��o</button>
			<button id="pararNavegacaoBotao" onclick="javascript: ">Parar Navega��o</button>
			
			<h3>Controles de som</h3>
			<button id="pararAudioBotao" onclick="javascript: ">Parar o �udio</button>
		
		</div>
	</div>
</body>
</html>
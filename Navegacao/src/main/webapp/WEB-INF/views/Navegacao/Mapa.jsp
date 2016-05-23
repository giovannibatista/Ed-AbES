<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Navegação no Mapa
	Públicos</title>
<jsp:include page="../Imports.jsp" />

<link rel="stylesheet"
	href="<c:url value="/resources/css/Navegacao/mapa.css" />">
	
<script type="text/javascript"
	src="<c:url value="/resources/js/lib/easytimer.js" />"></script>

	
<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/audio.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/navegacao.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/mapa.js" />"></script>


<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/teclasatalhomapa.js" />"></script>

<script type="text/javascript">
	
</script>

</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main" id="conteudo">
		<h1>Navegação no Mapa: ${mapa.nome}</h1>
		
		<input type="button" onclick="javascript:playText()" value="Play">
		<input type="button" onclick="javascript:pauseText()" value="Pause">
		<input type="button" onclick="javascript:resumeText()" value="Resume">
		
		<audio src="" class="speech" hidden="true"></audio>
		
		<div id="blocoMapa">
			<div id="mapa">
				<input type="hidden" id="idMapa" value="${mapa.id}">
			</div>
		</div>
	</div>
</body>
</html>
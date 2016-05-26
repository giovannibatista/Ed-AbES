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
	src="<c:url value="/resources/js/Navegacao/navegacao.js" />"
	charset="utf-8"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/mapa.js" />" charset="utf-8"></script>


<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/teclasatalhomapa.js" />"
	charset="utf-8"></script>

<script type="text/javascript">
	
</script>

</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main" id="conteudo">
		<h1>Navegação no Mapa: ${mapa.nome}</h1>
		<div id="blocoMapa">
			<audio src="" class="speech" hidden="true"></audio>
			<div id="mapa">
				<input type="hidden" id="idMapa" value="${mapa.id}"> <input
					type="hidden" id="nomeMapa" value="${mapa.nome}"> <input
					type="hidden" id="descricaoMapa" value="${mapa.descricao}">
				<input type="hidden" id="objetivoMapa" value="${mapa.objetivo}">
				<input type="hidden" id="andarMapa" value="${mapa.andar}">
			</div>
		</div>
	</div>
</body>
</html>
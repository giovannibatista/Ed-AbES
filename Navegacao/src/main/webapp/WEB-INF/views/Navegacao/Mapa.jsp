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
		<h1>Navegação no Mapa 1</h1>
		<p>...</p>

		<div id="blocoMapa">
			<h2>Mapa 1</h2>

			<div id="mapa">
				<input type="hidden" id="idMapa" value="${idMapa}">
			</div>
		</div>
	</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Navega��o no Mapa
	P�blicos</title>
<jsp:include page="../Imports.jsp" />

<link rel="stylesheet"
	href="<c:url value="/resources/css/Navegacao/mapa.css" />">

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/mapa.js" />"></script>


<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/teclasatalhomapa.js" />"></script>

</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main">
		<h1>Navega��o no Mapa 1</h1>
		<p>...</p>

		<div id="blocoMapa">
			<h2>Mapa 1</h2>

			<div id="mapa">
				<img alt="Esta � uma imagem de exemplo de um mapa de navega��o"
					id="mapaImg" name="mapaImg"
					src="<c:url value="/resources/img/mapa.png" />">
			</div>
		</div>
	</div>
</body>
</html>
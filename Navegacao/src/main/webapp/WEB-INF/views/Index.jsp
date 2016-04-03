<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Inicial</title>
<jsp:include page="Imports.jsp" />

<link rel="stylesheet"
	href="<c:url value="/resources/css/index.css" />">


</head>
<body>
	<header role="banner">
		<jsp:include page="Menu.jsp" />
	</header>
	<main class="main">
	
		<h1>Ed-AbES - M�dulo de Navega��o!</h1>
		<p>O Ed-AbES - M�dulo de Navega��o permite que voc� navegue em
		ambientes reais, previamente constru�dos em um ambiente virtual, assim
		conhecendo o ambiente antes de se deslocar at� o espa�o f�sico e com
		isto, criando mapas mentais que dever�o facilitar o deslocamento in
		loco.</p>
		<p>Para acessar o menu, os atalhos s�o Alt + tecla num�rica de 1 a 7.</p>
		<p>Por exemplo, para acessar a op��o de Teclas de Atalho, digite "Alt 5". Para conhecer mais sobre o Ed-AbES, digite "Alt 4".</p>
		<p>O uso do mouse permanece dispon�vel para intera��o com o sistema.</p>
	</main>
</body>
</html>
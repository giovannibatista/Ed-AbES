<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Inicial</title>
<jsp:include page="Imports.jsp" />

<link rel="stylesheet"
	href="<c:url value="/resources/css/index.css" />">


</head>
<body>
	<header role="banner">
		<jsp:include page="Menu.jsp" />
	</header>
	<main class="main">
	
		<h1>Ed-AbES - Módulo de Navegação!</h1>
		<p>O Ed-AbES - Módulo de Navegação permite que você navegue em
		ambientes reais, previamente construídos em um ambiente virtual, assim
		conhecendo o ambiente antes de se deslocar até o espaço físico e com
		isto, criando mapas mentais que deverão facilitar o deslocamento in
		loco.</p>
		<p>Para acessar o menu, os atalhos são Alt + tecla numérica de 1 a 7.</p>
		<p>Por exemplo, para acessar a opção de Teclas de Atalho, digite "Alt 5". Para conhecer mais sobre o Ed-AbES, digite "Alt 4".</p>
		<p>O uso do mouse permanece disponível para interação com o sistema.</p>
	</main>
</body>
</html>
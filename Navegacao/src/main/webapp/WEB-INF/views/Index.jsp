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
		<p>
			Bem vindo ao m�dulo de navega��o do Ed-AbES. Esta aplica��o � respons�vel pela navega��o em ambientes virtuais. 
			Para acessar o menu, utilize a navega��o pelas teclas padr�o de navega��o ou utilize as teclas de atalho da aplica��o. Para tal, pressione
			a tecla Atl mais uma tecla num�rica, de 1 at� 7, para acessar um item do menu. 
		</p>
	</main>
</body>
</html>
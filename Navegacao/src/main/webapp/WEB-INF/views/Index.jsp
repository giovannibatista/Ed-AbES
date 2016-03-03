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
	<div role="main" class="main">
	
		<h1>Ed-AbES - M�dulo de Navega��o!</h1>
		<p>
			Bem vindo ao m�dulo de navega��o do Ed-AbES., esta aplica��o � respons�vel pela navega��o em ambientes virtuais. 
			Para acessar o menu, utilize a navega��o pelas teclas padr�o de navega��o ou utilizando as teclas de atalho, pressionando
			a tecla Atl mais uma tecla num�rica, de 1 at� 7. 
		</p>
	</div>
</body>
</html>
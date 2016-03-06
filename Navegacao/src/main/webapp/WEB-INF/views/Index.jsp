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
		<p>
			Bem vindo ao módulo de navegação do Ed-AbES. Esta aplicação é responsável pela navegação em ambientes virtuais. 
			Para acessar o menu, utilize a navegação pelas teclas padrão de navegação ou utilize as teclas de atalho da aplicação. Para tal, pressione
			a tecla Atl mais uma tecla numérica, de 1 até 7, para acessar um item do menu. 
		</p>
	</main>
</body>
</html>
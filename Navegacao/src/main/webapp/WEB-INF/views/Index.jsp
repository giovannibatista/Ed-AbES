<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Inicial</title>
<jsp:include page="Imports.jsp" />

<link rel="stylesheet" href="<c:url value="/resources/css/index.css" />">


</head>
<body>
	<header role="banner">
		<jsp:include page="Menu.jsp" />
	</header>
	<main class="main">

	<h1>Ed-AbES - Módulo de Navegação!</h1>
	<p>O Ed-AbES é um projeto desenvolvido para navegação virtual de
		pessoas com deficiência visual composto por dois módulos: o Módulo de
		Construção e o Módulo de Navegação.</p>
	<p>O Ed-AbES - Módulo de Construção tem como objetivo permitir a
		criação de um mapa virtual, por pessoas videntes, que modele um
		ambiente real ou não. Estes ambientes podem ser quartos, cozinha, sala
		de aula, escritórios, jardins, entre outros.</p>
	<p>Neste momento, você está utilizando o Ed-AbES - Módulo de
		Navegação, que permite que uma pessoa com deficiência visual navegue
		nos mapas criados no Módulo de Construção, com o objetivo de conhecer
		e explorar os espaços que foram modelados. Esta navegação pode ajudar
		na locomoção no espaço físico, caso o mapa seja de um espaço real.</p>
	<p>Neste módulo estão disponíveis mapas já prontos, não permitindo
		a criação de novos mapas. Para isto, deve-se usar o Módulo de
		Construção.</p>
	<p>Para acessar o menu principal da aplicação, os atalhos são Alt +
		tecla numérica de 1 a 7. Por exemplo, para acessar a opção de Teclas
		de Atalho, digite "Alt 5". Para conhecer mais características sobre o
		Ed-AbES, digite "Alt 4".</p>
	<p>Para começar o uso do Ed-AbES - Módulo de Navegação, você pode
		acessar a opção de Teclas de Atalho da aplicação, digitando o atalho
		"Alt 5". O uso do mouse permanece disponível para interação com o
		sistema.</p>
	</main>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Inicial</title>
<jsp:include page="Imports.jsp" />

<link rel="stylesheet" href="<c:url value="/resources/css/index.css" />">


</head>
<body>
	<header role="banner">
		<jsp:include page="Menu.jsp" />
	</header>
	<main class="main">

	<h1>Ed-AbES - M�dulo de Navega��o!</h1>
	<p>O Ed-AbES � um projeto desenvolvido para navega��o virtual de
		pessoas com defici�ncia visual composto por dois m�dulos: o M�dulo de
		Constru��o e o M�dulo de Navega��o.</p>
	<p>O Ed-AbES - M�dulo de Constru��o tem como objetivo permitir a
		cria��o de um mapa virtual, por pessoas videntes, que modele um
		ambiente real ou n�o. Estes ambientes podem ser quartos, cozinha, sala
		de aula, escrit�rios, jardins, entre outros.</p>
	<p>Neste momento, voc� est� utilizando o Ed-AbES - M�dulo de
		Navega��o, que permite que uma pessoa com defici�ncia visual navegue
		nos mapas criados no M�dulo de Constru��o, com o objetivo de conhecer
		e explorar os espa�os que foram modelados. Esta navega��o pode ajudar
		na locomo��o no espa�o f�sico, caso o mapa seja de um espa�o real.</p>
	<p>Neste m�dulo est�o dispon�veis mapas j� prontos, n�o permitindo
		a cria��o de novos mapas. Para isto, deve-se usar o M�dulo de
		Constru��o.</p>
	<p>Para acessar o menu principal da aplica��o, os atalhos s�o Alt +
		tecla num�rica de 1 a 7. Por exemplo, para acessar a op��o de Teclas
		de Atalho, digite "Alt 5". Para conhecer mais caracter�sticas sobre o
		Ed-AbES, digite "Alt 4".</p>
	<p>Para come�ar o uso do Ed-AbES - M�dulo de Navega��o, voc� pode
		acessar a op��o de Teclas de Atalho da aplica��o, digitando o atalho
		"Alt 5". O uso do mouse permanece dispon�vel para intera��o com o
		sistema.</p>
	</main>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela de login do usu�rio</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/Usuario/login.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Usuario/teclasatalhoeditar.js" />"></script>

<link rel="stylesheet"
	href="<c:url value="/resources/css/Usuario/login.css" />">
</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main" id="conteudo">
		<h1>Identifica��o</h1>

		<p id="msg" role="alert" aria-atomic="true"></p>

		<c:if test="${cadastro == true}">
			<c:if test="${verificacaoCadastro == true}">
				<script type="text/javascript">
					$('#msg').html('');
					$('#msg').append('<p>Usu�rio cadastrado com sucesso!</p>');

					alert("Usu�rio cadastrado com sucesso");
				</script>
			</c:if>
		</c:if>
		
		<c:if test="${cadastro == true}">
			<c:if test="${verificacaoCadastro == true}">
				<script type="text/javascript">
					$('#msg').html('');
					$('#msg').append('<p>Usu�rio cadastrado com sucesso!</p>');

					alert("Usu�rio cadastrado com sucesso");
				</script>
			</c:if>
		</c:if>
		

		<p>Esta tela apresenta as op��es de voc� criar um novo usu�rio no
			sistema Ed-AbES - M�dulo de navega��o ou efetuar o login com sua
			conta j� existente!</p>

		<div id="novoUsuarioForm">
			<h2>Sou um novo usu�rio!</h2>
			<p>
				<label for="email">Digite seu email : </label> <input type="email"
					name="novoEmail" id="novoEmail" value=""
					aria-label="Informe seu email para um novo usu�rio!"
					placeholder="Exemplo: bruna@mail.com" class="inputUsuario" />
			</p>

			<input type="button" id="salvarUsuarioBotao"
				name="salvarUsuarioBotao" value="Continuar com o cadastro"
				aria-label="Bot�o para continuar com o cadastro do usu�rio"
				onclick="javascript: novoUsuario();" />
		</div>

		<div id="loginForm">
			<h2>J� sou cadastrado!</h2>
			<p>Informe seu e-mail e senha para efetuar o login!</p>
			<p>
				<label for="emailLogin">Digite seu email : </label> <input
					type="email" name="emailLogin" id="emailLogin"
					aria-label="Informe seu email efetuar login!"
					placeholder="Exemplo: bruna@mail.com" value="" class="inputUsuario" />
			</p>
			<p>
				<label for="senha">Digite sua Senha : </label> <input
					type="password" name="Senha" id="senha" value=""
					class="inputUsuario" />
			</p>

			<input type="button" id="loginBotao" name="loginBotao"
				value="Efetuar login"
				aria-label="Bot�o para efetuar login e acessar a aplica��o"
				onclick="javascript: efetuarLogin();" />
		</div>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
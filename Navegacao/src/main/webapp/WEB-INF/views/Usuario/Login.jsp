<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela do usu�rio</title>

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



		<p id="msg" role="alert" aria-live="polite"></p>

		<c:if test="${cadastro == true}">
			<c:choose>
				<c:when test="${inclusao == true}">
					<script type="text/javascript">
						console.log('1');
						$('#msg').html('');
						$('#msg').append(
								'<p>Usu�rio cadastrado com sucesso!</p>');
					</script>
				</c:when>
				<c:otherwise>
					<script type="text/javascript">
						console.log('1');
						$('#msg').html('');
						$('#msg')
								.append('<p>Usu�rio alterado com sucesso!</p>');
					</script>
				</c:otherwise>
			</c:choose>
		</c:if>

		<c:if test="${erroLogin == true}">
			<script type="text/javascript">
				$('#msg').html('');
				$('#msg')
						.append(
								'<p>Email ou senha incorretos. Efetuar o login novamente!</p>');
			</script>
		</c:if>

		<c:choose>
			<c:when test="${not empty usuario}">
			
					<h1>Usu�rio logado: ${usuario.nome}</h1>
			

				<p>Esta tela apresenta as op��es de voc� criar um novo usu�rio
					no sistema Ed-AbES - M�dulo de navega��o, efetuar o login com sua
					conta j� existente e efetuar logout, caso voc� esteja logado com
					sua conta!</p>

				<div id="editarUsuarioForm">
					<h2>Quero editar meu usu�rio!</h2>
					<input type="button" id="editarUsuarioBotao"
						name="editarUsuarioBotao" value="Editar meu usu�rio"
						aria-label="Bot�o para editar o cadastro do usu�rio"
						onclick="javascript: editarUsuario();" />
				</div>

				<div id="logoutUsuarioForm">
					<h2>Desejo efetuar o logout da aplica��o!</h2>

					<input type="button" id="logoutUsuarioBotao"
						name="logoutUsuarioBotao" value="Efetuar logout"
						aria-label="Bot�o para sair da sua conta"
						onclick="javascript: logout();" />
				</div>

			</c:when>
			<c:otherwise>
			
					<h1>Identifica��o</h1>
			

				<p>Esta tela apresenta as op��es de voc� criar um novo usu�rio
					no sistema Ed-AbES - M�dulo de navega��o ou efetuar o login com sua
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

				<form id="loginForm" method="POST" action="/Usuario/EfetuarLogin">

					<h2>J� sou cadastrado!</h2>
					<p>Informe seu e-mail e senha para efetuar o login!</p>
					<p>
						<label for="emailLogin">Digite seu email : </label> <input
							type="email" name="email" id="email"
							aria-label="Informe seu email efetuar login!"
							placeholder="Exemplo: bruna@mail.com" value=""
							class="inputUsuario" />
					</p>
					<p>
						<label for="senha">Digite sua Senha : </label> <input
							type="password" name="senha" id="senha" value=""
							class="inputUsuario" />
					</p>

					<input type="submit" id="loginBotao" name="loginBotao"
						value="Efetuar login"
						aria-label="Bot�o para efetuar login e acessar a aplica��o!" />
				</form>

			</c:otherwise>
		</c:choose>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela do usuário</title>

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
								'<p>Usuário cadastrado com sucesso!</p>');
					</script>
				</c:when>
				<c:otherwise>
					<script type="text/javascript">
						console.log('1');
						$('#msg').html('');
						$('#msg')
								.append('<p>Usuário alterado com sucesso!</p>');
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
			
					<h1>Usuário logado: ${usuario.nome}</h1>
			

				<p>Esta tela apresenta as opções de você criar um novo usuário
					no sistema Ed-AbES - Módulo de navegação, efetuar o login com sua
					conta já existente e efetuar logout, caso você esteja logado com
					sua conta!</p>

				<div id="editarUsuarioForm">
					<h2>Quero editar meu usuário!</h2>
					<input type="button" id="editarUsuarioBotao"
						name="editarUsuarioBotao" value="Editar meu usuário"
						aria-label="Botão para editar o cadastro do usuário"
						onclick="javascript: editarUsuario();" />
				</div>

				<div id="logoutUsuarioForm">
					<h2>Desejo efetuar o logout da aplicação!</h2>

					<input type="button" id="logoutUsuarioBotao"
						name="logoutUsuarioBotao" value="Efetuar logout"
						aria-label="Botão para sair da sua conta"
						onclick="javascript: logout();" />
				</div>

			</c:when>
			<c:otherwise>
			
					<h1>Identificação</h1>
			

				<p>Esta tela apresenta as opções de você criar um novo usuário
					no sistema Ed-AbES - Módulo de navegação ou efetuar o login com sua
					conta já existente!</p>


				<div id="novoUsuarioForm">
					<h2>Sou um novo usuário!</h2>
					<p>
						<label for="email">Digite seu email : </label> <input type="email"
							name="novoEmail" id="novoEmail" value=""
							aria-label="Informe seu email para um novo usuário!"
							placeholder="Exemplo: bruna@mail.com" class="inputUsuario" />
					</p>

					<input type="button" id="salvarUsuarioBotao"
						name="salvarUsuarioBotao" value="Continuar com o cadastro"
						aria-label="Botão para continuar com o cadastro do usuário"
						onclick="javascript: novoUsuario();" />
				</div>

				<form id="loginForm" method="POST" action="/Usuario/EfetuarLogin">

					<h2>Já sou cadastrado!</h2>
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
						aria-label="Botão para efetuar login e acessar a aplicação!" />
				</form>

			</c:otherwise>
		</c:choose>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
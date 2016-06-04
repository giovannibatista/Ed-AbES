<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela de edição do
	usuário</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/Usuario/editar.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Usuario/teclasatalhoeditar.js" />"></script>

<link rel="stylesheet"
	href="<c:url value="/resources/css/Usuario/editar.css" />">
</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main" id="conteudo">
		<h1>Informações do usuário</h1>

		<form id="usuarioForm">
			<p>
				<label for="nomeUsuario">Nome : </label> <input type="text"
					name="nome" id="nome" value="Giovanni" class="inputUsuario" /> <input
					type="hidden" name="id" id="id" value="1" />
			</p>
			<p>
				<label>Sobrenome : </label> <input type="text" name="sobrenome"
					id="sobrenome" value="Carlos" class="inputUsuario" />
			</p>
			<p>
				<label>E-mail : </label> <input type="email" name="email" id="email"
					value="giovanni.bat@gmail.com" class="inputUsuario" />
			</p>
			<p>
				<label>Ano de Nascimento : </label> <input type="text"
					name="anoNascimento" id="anoNascimento" value="1990"
					class="inputUsuario" />
			</p>
			<p>
				<label>Gênero : </label> <input type="radio" name="genero" value="M"
					id="masculino" /> <label for="masculino">Masculino</label> <input
					type="radio" name="genero" value="F" id="feminino" /> <label
					for="feminino">Feminino</label>

			</p>
			<p>
				<label>Cidade : </label> <input type="text" name="cidade"
					id="cidade" value="Porto Alegre" class="inputUsuario" />
			</p>
			<p>
				<label>País : </label> <input type="text" name="pais" id="pais"
					value="Brasil" class="inputUsuario" />
			</p>
			<p>
				<label>Senha : </label> <input type="password" name="Senha"
					id="senha" value="123456" class="inputUsuario" />
			</p>
			<p>
				<label>Confirmar senha : </label> <input type="password"
					name="confirmaSenha" id="confirmaSenha" value="123456"
					class="inputUsuario" />
			</p>
			<p>
				<input type="button" id="salvarUsuarioBotao"
					name="salvarUsuarioBotao" value="Salvar usuário"
					aria-label="Botão para salvar as informações do usuário - Atalho Alt S"
					onclick="javascript: salvarUsuario(1)" /> <input type="button"
					id="cancelarALteracoesBotao" name="cancelarAlteracoesBotao"
					value="Cancelar alterações"
					aria-label="Botão para cancelar as informações alteradas do usuário - Atalho Alt C"
					onclick="javascript: cancelarAlteracoesUsuario()" />
			</p>
		</form>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
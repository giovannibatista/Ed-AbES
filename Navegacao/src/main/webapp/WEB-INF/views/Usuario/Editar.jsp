<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela de edi��o do
	usu�rio</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/Usuario/editar.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Usuario/teclasatalhoeditar.js" />"></script>

<link rel="stylesheet" href="<c:url value="/resources/css/Usuario/editar.css" />">
</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main">
		<h1>Informa��es do usu�rio</h1>

		<form id="usuarioForm">
			<p>
				<label for="nomeUsuario">Nome : </label> 
				<input type="text" name="nome" id="nome" value="Giovanni" class="inputFullWidth"/>
				<input type="hidden" name="id" id="id" value="1" />
			</p>
			<p>
				<label>Sobrenome : </label>
				<input type="text" name="sobrenome" id="sobrenome" value="Carlos" class="inputFullWidth"/> 
			</p>
			<p>
				<label>E-mail : </label>
				<input type="email" name="email" id="email" value="giovanni.bat@gmail.com" class="inputFullWidth"/> 
			</p>
			<p>
				<label>Ano de Nascimento : </label>
				<input type="" name="anoNascimento" id="anoNascimento" value="1990" class="inputFullWidth"/> 
			</p>
			<p>
				<label>G�nero : </label>
				<input type="radio" name="genero" value="M" id="masculino"/> <label for="masculino">Masculino</label>
				<input type="radio" name="genero" value="F" id="feminino"/> <label for="feminino">Feminino</label> 
				
			</p>
			<p>
				<label>Cidade : </label>
				<input type="text" name="cidade" id="cidade" value="Porto Alegre" class="inputFullWidth"/> 
			</p>
			<p>
				<label>Pa�s : </label>
				<input type="text" name="pais" id="pais" value="Brasil" class="inputFullWidth"/> 
			</p>
			<p>
				<label>Senha : </label>
				<input type="password" name="Senha" id="senha" value="123456" class="inputFullWidth"/> 
			</p>
			<p>
				<label>Confirmar senha : </label>
				<input type="password" name="confirmaSenha" id="confirmaSenha" value="123456" class="inputFullWidth"/> 
			</p>
			<p>
				<input type="button" id="salvarUsuarioBotao"
					name="salvarUsuarioBotao" value="Salvar usu�rio"
					alt="Bot�o para salvar as informa��es do usu�rio - Atalho Alt + S"
					onclick="javascript: salvarUsuario(1)" /> 
					
				<input type="button" id="cancelarALteracoesBotao" name="cancelarAlteracoesBotao" value="Cancelar altera��es"
					alt="Bot�o para cancelar as informa��es alteradas do usu�rio - Atalho Alt + C"
					onclick="javascript: cancelarAlteracoesUsuario()" />
			</p>
		</form>
	</div>
</body>
</html>
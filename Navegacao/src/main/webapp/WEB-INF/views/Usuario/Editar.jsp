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

<link rel="stylesheet"
	href="<c:url value="/resources/css/Usuario/editar.css" />">
</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main" id="conteudo">
		<c:choose>
			<c:when test="${logado == true}">
				<h1>Edi��o do usu�rio</h1>
			</c:when>
			<c:otherwise>
				<h1>Novo do usu�rio</h1>
			</c:otherwise>

		</c:choose>

		<c:if test="${cadastro == false}">
			<script type="text/javascript">
				$('#errors').html('');
				$('#errors').append('<p>Ocorreu um erro ao cadastrar o usu�rio!</p>');
			</script>
		</c:if>

		<p>
			Os campos obrigat�rios est�o marcados com asterisco (<abbr
				class="req" title="Campo Obrigat�rio">*</abbr>).
		</p>
		<form id="usuarioForm" method="POST" action="Salvar">
			<p id="errors" role="alert" aria-live="polite"></p>
			<p>
				<label for="nome">Nome<abbr class="req"
					title="Campo Obrigat�rio">*</abbr>:
				</label> <input type="text" name="nome" id="nome" value="${usuario.nome}"
					class="inputUsuario" placeholder="Exemplo: Jo�o" /> <input
					type="hidden" name="id" id="id" value="${usuario.id}" />
			</p>
			<p>
				<label for="sobrenome">Sobrenome<abbr class="req"
					title="Campo Obrigat�rio">*</abbr>:
				</label> <input type="text" name="sobrenome" id="sobrenome"
					value="${usuario.sobrenome}" class="inputUsuario"
					placeholder="Exemplo: Silva" />
			</p>
			<p>
				<label for="email">E-mail<abbr class="req"
					title="Campo Obrigat�rio">*</abbr>:
				</label> <input type="email" name="email" id="email" readonly="readonly"
					value="${usuario.email}" class="inputUsuario"
					placeholder="Exemplo: joao@email.com" />
			</p>
			<p>
				<label for="anoNascimento">Ano de Nascimento: </label> <input
					type="text" name="anoNascimento" id="anoNascimento"
					value="${usuario.anoNascimento}" class="inputUsuario"
					placeholder="Exemplo: 1990" />
			</p>
			<p>
				<label for="cidade">Cidade: </label> <input type="text"
					name="cidade" id="cidade" value="${usuario.cidade}"
					class="inputUsuario" placeholder="Exemplo: Porto Alegre" />
			</p>
			<p>
				<label for="pais">Pa�s: </label> <input type="text" name="pais"
					id="pais" value="${usuario.pais}" class="inputUsuario"
					placeholder="Exemplo: Brasil" />
			</p>
			<p>
				<label for="senha">Senha<abbr class="req"
					title="Campo Obrigat�rio">*</abbr>:
				</label> <input type="password" name="Senha" id="senha"
					value="${usuario.senha}" class="inputUsuario" placeholder="Senha" />
			</p>
			<p>
				<label for="confirmaSenha">Confirmar senha<abbr class="req"
					title="Campo Obrigat�rio">*</abbr>:
				</label> <input type="password" name="confirmaSenha" id="confirmaSenha"
					value="${usuario.senha}" class="inputUsuario"
					placeholder="Confirmar senha"
					aria-label="A senha deve ser a mesma informada anteriormente"
					required oninput="validaSenha(this)" />
			</p>
			<p>
				<input type="Submit" id="salvarUsuarioBotao"
					name="salvarUsuarioBotao" value="Salvar usu�rio"
					aria-label="Bot�o para salvar as informa��es do usu�rio - Atalho Alt S"
					onclick="javascript: salvarUsuario(${usuario.id})" /> <input
					type="button" id="cancelarALteracoesBotao"
					name="cancelarAlteracoesBotao" value="Cancelar altera��es"
					aria-label="Bot�o para cancelar as informa��es alteradas do usu�rio - Atalho Alt C"
					onclick="javascript: cancelarAlteracoesUsuario()" />
			</p>
		</form>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
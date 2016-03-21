<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Navega��o no Mapa
	P�blicos</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/mapalistar.js" />"></script>
	
<link rel="stylesheet" href="<c:url value="/resources/css/resumo.css" />">
</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main">
		<h1>Navega��o no Mapa 1</h1>
		<p>Para iniciar a navega��o no Mapa 1, pressione a tecla "Alt +
			I". Caso queira retornar para a tela anterior,
			pressione a tecla "Alt + V"...</p>

		<div id="informacaoMapa">
			<h2>Informa��es do Mapa</h2>
			<form id="mapaForm">
				<p>
					<label for="nomeMapa">Nome do Mapa : </label> 
					<input type="text"
						name="nomeMapa" id="nomeMapa" value="Mapa 1"  readonly="readonly">
				</p>
				<p>
					<label for="descricao">Descri��o : </label> 
					<input type="text"
						name="descricao" id="descricao" value="Descri��o do mapa 1"  readonly="readonly">
				</p>
				<p>
					<label for="objetivo">Objetivo : </label> 
					<input type="text"
						name="objetivo" id="objetivo" value="O Objetivo do mapa 1 � tal..."  readonly="readonly">
				</p>
				<p>
					<label for="unidadeMedida">Unidade de Medida : </label> 
					<input type="text"
						name="unidadeMedida" id="unidadeMedida" value="Passos"  readonly="readonly">
				</p>
				<p>
					<label for="andar">Andar : </label> 
					<input type="text"
						name="andar" id="andar" value="Primeiro"  readonly="readonly">
				</p>
				<p>
					<label for="Autor">Autor : </label> 
					<input type="text"
						name="autor" id="autor" value="Jo�o"  readonly="readonly">
				</p>
				<p>
					<label for="dataCriacao">Data de Cria��o : </label> 
					<input type="text"
						name="dataCriacao" id="dataCriacao" value="19/03/2016"  readonly="readonly">
				</p>
			</form>
		</div>
				
		<div id="acoesNavegacao">
			<h2>A��es da navega��o do mapa</h2>
			<input type="button"
				alt="Bot�o Iniciar Navega��o - Atalho Alt + I para Iniciar Navega��o"
				id="iniciarNavegacaoBotao" onclick="javascript: " value="Iniciar Navega��o" />
			<input type="button"
				alt="Bot�o Voltar para tela de escolha dos mapas salvos - Atalho Alt + V para voltar."
				id="voltarBotao" onclick="javascript: " value="Voltar para tela anterior" />

		</div>
	</div>
</body>
</html>
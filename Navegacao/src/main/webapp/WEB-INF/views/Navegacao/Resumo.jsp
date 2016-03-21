<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Navegação no Mapa
	Públicos</title>
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
		<h1>Navegação no Mapa 1</h1>
		<p>Para iniciar a navegação no Mapa 1, pressione a tecla "Alt +
			I". Caso queira retornar para a tela anterior,
			pressione a tecla "Alt + V"...</p>

		<div id="informacaoMapa">
			<h2>Informações do Mapa</h2>
			<form id="mapaForm">
				<p>
					<label for="nomeMapa">Nome do Mapa : </label> 
					<input type="text"
						name="nomeMapa" id="nomeMapa" value="Mapa 1"  readonly="readonly">
				</p>
				<p>
					<label for="descricao">Descrição : </label> 
					<input type="text"
						name="descricao" id="descricao" value="Descrição do mapa 1"  readonly="readonly">
				</p>
				<p>
					<label for="objetivo">Objetivo : </label> 
					<input type="text"
						name="objetivo" id="objetivo" value="O Objetivo do mapa 1 é tal..."  readonly="readonly">
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
						name="autor" id="autor" value="João"  readonly="readonly">
				</p>
				<p>
					<label for="dataCriacao">Data de Criação : </label> 
					<input type="text"
						name="dataCriacao" id="dataCriacao" value="19/03/2016"  readonly="readonly">
				</p>
			</form>
		</div>
				
		<div id="acoesNavegacao">
			<h2>Ações da navegação do mapa</h2>
			<input type="button"
				alt="Botão Iniciar Navegação - Atalho Alt + I para Iniciar Navegação"
				id="iniciarNavegacaoBotao" onclick="javascript: " value="Iniciar Navegação" />
			<input type="button"
				alt="Botão Voltar para tela de escolha dos mapas salvos - Atalho Alt + V para voltar."
				id="voltarBotao" onclick="javascript: " value="Voltar para tela anterior" />

		</div>
	</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Resumo no Mapa
	Públicos</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/navegacao.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/teclasatalhoresumo.js" />"></script>

<link rel="stylesheet" href="<c:url value="/resources/css/Navegacao/resumo.css" />">
</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main" id="conteudo">
		<h1>Resumo no Mapa 1</h1>
		<p>A seguir serão lidas das informações sobre o mapa que você escolheu para navegar. 
		</p>
		<p>Para iniciar a navegação, você pode acessar o botão "Iniciar
			Navegação" pela navegação pela tecla TAB ou as setas cima/baixo, após
			ter ouvido as informações do mapa ou pela tecla de atalho "Alt I".
			Para retornar a tela anterior, de seleção dos mapas salvos, o botão
			poderá ser acessado pela tecla de atalho "Alt V" ou pelo atalho do
			menu principal que é Alt 2 e lista os mapas públicos disponíveis para
			escolha.</p>

		<div id="informacaoMapa">
			<h2>Informações do Mapa</h2>
			<form id="mapaForm">
				<p>
					<label for="nomeMapa">Nome do mapa : </label> 
					<input type="text"
						name="nomeMapa" id="nomeMapa" value="Mapa 1"  readonly="readonly" />
						<input type="hidden" name="idMapa" id="idMapa" value="1" />
				</p>
				<p>
					<label for="descricao">Descrição : </label> 
					<input type="text"
						name="descricao" id="descricao" value="Descrição do mapa 1"  readonly="readonly" />
				</p>
				<p>
					<label for="objetivo">Objetivo : </label> 
					<input type="text"
						name="objetivo" id="objetivo" value="O Objetivo do mapa 1 é tal..."  readonly="readonly" />
				</p>
				<p>
					<label for="unidadeMedida">Unidade de medida : </label> 
					<input type="text"
						name="unidadeMedida" id="unidadeMedida" value="Passos"  readonly="readonly" />
				</p>
				<p>
					<label for="andar">Andar : </label> 
					<input type="text"
						name="andar" id="andar" value="Primeiro"  readonly="readonly" />
				</p>
				<p>
					<label for="autor">Autor : </label> 
					<input type="text"
						name="autor" id="autor" value="João"  readonly="readonly" />
				</p>
				<p>
					<label for="dataCriacao">Data de criação : </label> 
					<input type="text"
						name="dataCriacao" id="dataCriacao" value="19/03/2016"  readonly="readonly" />
				</p>
			</form>
		</div>
				
		<div id="acoesNavegacao">
			<h2>Ações da navegação do mapa</h2>
			<input type="button"
				alt="Botão Iniciar Navegação - Atalho Alt I para Iniciar Navegação"
				id="iniciarNavegacaoBotao" onclick="javascript: iniciarNavegacao(1)" value="Iniciar Navegação" />
			<input type="button"
				alt="Botão Voltar para tela de escolha dos mapas salvos - Atalho Alt V para voltar."
				id="voltarBotao" onclick="javascript: voltarMapasSalvos();" value="Voltar para tela anterior" />

		</div>
	</div>
</body>
</html>
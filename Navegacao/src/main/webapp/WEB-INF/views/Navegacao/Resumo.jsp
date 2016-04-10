<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Resumo no Mapa
	P�blicos</title>
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
		<h1>Resumo do ${mapa.nome}</h1>
		<p>A seguir ser�o lidas das informa��es sobre o mapa que voc� escolheu para navegar. 
		</p>
		<p>Para iniciar a navega��o, voc� pode acessar o bot�o "Iniciar
			Navega��o" pela navega��o pela tecla TAB ou as setas cima/baixo, ap�s
			ter ouvido as informa��es do mapa ou pela tecla de atalho "Alt I".
			Para retornar a tela anterior, de sele��o dos mapas salvos, o bot�o
			poder� ser acessado pela tecla de atalho "Alt V" ou pelo atalho do
			menu principal que � Alt 2 e lista os mapas p�blicos dispon�veis para
			escolha.</p>

		<div id="informacaoMapa">
			<h2>Informa��es do Mapa</h2>
			<form id="mapaForm">
				<p>
					<label for="nomeMapa">Nome do mapa : </label> 
					<input type="text"
						name="nomeMapa" id="nomeMapa" value="${mapa.nome}"  readonly="readonly" />
						<input type="hidden" name="idMapa" id="idMapa" value="${mapa.id}" />
				</p>
				<p>
					<label for="descricao">Descri��o : </label> 
					<input type="text"
						name="descricao" id="descricao" value="${mapa.descricao}"  readonly="readonly" />
				</p>
				<p>
					<label for="objetivo">Objetivo : </label> 
					<input type="text"
						name="objetivo" id="objetivo" value="${mapa.objetivo}"  readonly="readonly" />
				</p>
				<p>
					<label for="unidadeMedida">Unidade de medida : </label> 
					<input type="text"
						name="unidadeMedida" id="unidadeMedida" value="${mapa.unidadeDeMedida}"  readonly="readonly" />
				</p>
				<p>
					<label for="andar">Andar : </label> 
					<input type="text"
						name="andar" id="andar" value="${mapa.andar}"  readonly="readonly" />
				</p>
				<p>
					<label for="autor">Autor : </label> 
					<input type="text"
						name="autor" id="autor" value="${mapa.nomeCriador}"  readonly="readonly" />
				</p>
				<p>
					<label for="dataCriacao">Data de cria��o : </label> 
					<input type="text"
						name="dataCriacao" id="dataCriacao" value="${mapa.dataCriacao}"  readonly="readonly" />
				</p>
				<p>
					<label for="dataAlteracao">Data de altera��o : </label> 
					<input type="text"
						name="dataAlteracao" id="dataAlteracao" value="${mapa.dataAlteracao}"  readonly="readonly" />
				</p>
			</form>
		</div>
				
		<div id="acoesNavegacao">
			<h2>A��es da navega��o do mapa</h2>
			<input type="button"
				alt="Bot�o Iniciar Navega��o - Atalho Alt I para Iniciar Navega��o"
				id="iniciarNavegacaoBotao" onclick="javascript: iniciarNavegacao(${mapa.id})" value="Iniciar Navega��o" />
			<input type="button"
				alt="Bot�o Voltar para tela de escolha dos mapas salvos - Atalho Alt V para voltar."
				id="voltarBotao" onclick="javascript: voltarMapasSalvos();" value="Voltar para tela anterior" />

		</div>
	</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Resumo no Mapa
	Públicos</title>
<jsp:include page="../Imports.jsp" />


<script type="text/javascript">
	function iniciarNavegacao(idMapa) {
		document.location = "/Navegacao/Mapa/" + idMapa;
	}
	
	function voltarListaMapas() {
		document.location = "/Navegacao/Listar/";
	}
</script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/teclasatalhoresumo.js" />"></script>

<link rel="stylesheet"
	href="<c:url value="/resources/css/Navegacao/resumo.css" />">
</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main" id="conteudo">
		<h1>Resumo do ${mapa.nome}</h1>
		<p>A seguir serão lidas das informações sobre o mapa que você
			escolheu para navegar.</p>
		<p>Para iniciar a navegação, você pode acessar o botão "Iniciar
			Navegação" pressionar a tecla de atalho "Alt I". Para voltar para a
			tela anterior, de seleção de mapas salvos, você pode pressionar o
			botão "Voltar" ou usar a tecla de atalho "Alt V". Caso deseje acessar
			a lista dos mapas públicos, utilize o atalho do menu principal que é
			"Alt 2", que listará os mapas públicos disponíveis para navegar.</p>
		<p>Quando iniciar a navegação no mapa, é recomendado que desligue
			o leitor de tela para uma melhor experiência. Pois poderá ocorrer
			colisão de teclas de atalho e sobreposição do som da aplicação e do
			leitor de tela.</p>

		<div id="informacaoMapa">
			<h2>Informações do Mapa</h2>
			<div id="mapaForm">
				<p>
					<label for="nomeMapa">Nome do mapa : </label> <input type="text"
						name="nomeMapa" id="nomeMapa" value="${mapa.nome}"
						readonly="readonly" /> <input type="hidden" name="idMapa"
						id="idMapa" value="${mapa.id}" />
				</p>
				<p>
					<label for="descricao">Descrição : </label> <input type="text"
						name="descricao" id="descricao" value="${mapa.descricao}"
						readonly="readonly" />
				</p>
				<p>
					<label for="tipo">Tipo do Mapa : </label> <input type="text"
						name="tipo" id="tipo" value="${mapa.descricaoTipoMapa}"
						readonly="readonly" />
				</p>
				<p>
					<label for="objetivo">Objetivo : </label> <input type="text"
						name="objetivo" id="objetivo" value="${mapa.objetivo}"
						readonly="readonly" />
				</p>
				<p>
					<label for="andar">Pavimento : </label> <input type="text"
						name="andar" id="andar" value="${mapa.andar}" readonly="readonly" />
				</p>
				<p>
					<label for="autor">Autor : </label> <input type="text" name="autor"
						id="autor" value="${mapa.nomeCriador}" readonly="readonly" />
				</p>
				<p>
					<label for="dataCriacao">Data de criação : </label> <input
						type="text" name="dataCriacao" id="dataCriacao"
						value="${mapa.dataCriacao}" readonly="readonly" />
				</p>
				<p>
					<label for="dataAlteracao">Data de alteração : </label> <input
						type="text" name="dataAlteracao" id="dataAlteracao"
						value="${mapa.dataAlteracao}" readonly="readonly" />
				</p>
			</div>
		</div>

		<div id="acoesNavegacao">
			<h2>Ações da navegação do mapa</h2>
			<input type="button"
				aria-label="Iniciar Navegação - Tecla de atalho Alt I para Iniciar Navegação."
				id="iniciarNavegacaoBotao"
				onclick="javascript: iniciarNavegacao(${mapa.id})"
				value="Iniciar Navegação" accesskey="i" /> <input type="button"
				aria-label="Voltar para tela de escolha dos mapas salvos - Tecla de atalho Alt Vê para voltar."
				id="voltarBotao" onclick="javascript: voltarListaMapas();"
				value="Voltar para tela anterior" accesskey="v" />

		</div>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
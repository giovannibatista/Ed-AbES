<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Histórico de
	navegações</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/Historico/historiconavegacao.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/Historico/teclasatalhohistorico.js" />"></script>

</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main" id="conteudo">
		<h1>Log do histórico de navegação do Mapa: ${historicoNavegacao.mapa.nome} </h1>
		
		<input type="button" id="voltarListaHistoricoBotao" value="Voltar"
			alt="Voltar para lista de histórico de navegação"
			onclick="javascript: document.location = '/Historico/Listar'">
	
		<article id="logHistoricoNavegacao">
			<p>${historicoNavegacao.log}</p>
		</article>

	</div>
</body>
</html>
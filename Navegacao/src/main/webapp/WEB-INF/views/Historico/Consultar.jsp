<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Hist�rico de
	navega��o</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/Historico/historiconavegacao.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/Historico/teclasatalhohistorico.js" />"></script>

</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main" id="conteudo">
		<h1>Log do hist�rico de navega��o do Mapa:
			${historicoNavegacao.mapa.nome}</h1>

		<input type="button" id="voltarListaHistoricoBotao" value="Voltar"
			aria-label="Voltar para lista de hist�rico de navega��o"
			onclick="javascript: document.location = '/Historico/Listar'">

		<article id="logHistoricoNavegacao">
			<p>${historicoNavegacao.log}</p>
		</article>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Navega��o no Mapa
	P�blicos</title>
<jsp:include page="../Imports.jsp" />

<link rel="stylesheet"
	href="<c:url value="/resources/css/Navegacao/mapa.css" />">

<script type="text/javascript"
	src="<c:url value="/resources/js/lib/easytimer.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/audio.js" />"
	charset="utf-8"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/historico.js" />"
	charset="utf-8"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/navegacao.js" />"
	charset="utf-8"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/mapa.js" />" charset="utf-8"></script>


<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/teclasatalhomapa.js" />"
	charset="utf-8"></script>

<script type="text/javascript">
	
</script>

</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main" id="conteudo">
		<h1>Navega��o no Mapa: ${mapa.nome}</h1>
		<div id="blocoMapa">
			<audio class="speech" style="diplay: none;"></audio>
			<div id="mapa">
				<input type="hidden" id="idMapa" value="${mapa.id}"> <input
					type="hidden" id="nomeMapa" value="${mapa.nome}"> <input
					type="hidden" id="descricaoMapa" value="${mapa.descricao}">
				<input type="hidden" id="objetivoMapa" value="${mapa.objetivo}">
				<input type="hidden" id="andarMapa" value="${mapa.andar}"> <input
					type="hidden" id="descricaoTipoMapa"
					value="${mapa.descricaoTipoMapa}"> <input type="hidden"
					id="idUsuario" value="${usuario.id}">
			</div>
		</div>
	</div>
</body>
</html>
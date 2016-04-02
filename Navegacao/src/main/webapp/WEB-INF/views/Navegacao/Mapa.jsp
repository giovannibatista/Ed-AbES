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
	src="<c:url value="/resources/js/Navegacao/mapa.js" />"></script>

	
<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/teclasatalhomapa.js" />"></script>

</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main">
		<h1>Navega��o no Mapa 1</h1>
		<p>...</p>
		
		<div id="blocoNavegacaoMapa">			
			<div id="blocoAcoesNavegacao">
				<h2>Comandos para navega��o</h2>
				<input type="button"
					alt="Bot�o para encerrar a navega��o - Atalho Alt E."
					id="encerrarNavegacaoBotao" onclick="javascript: encerrarNavegacao()" value="Encerrar Navega��o" />
				
				<input type="button"
					alt="Bot�o para parar a navega��o. Voc� poder� retomar a navega��o posteriormente - Atalho Alt S."
					id="pararNavegacaoBotao" onclick="javascript: pararNavegacao()" value="Para Navega��o" />
				
				<input type="hidden"
					alt="Bot�o para retomar a navega��o. Atalho Alt S."
					id="retomarNavegacaoBotao" onclick="javascript: retomarNavegacao()" value="Retomar Navega��o" />
			
				<div id="blocoControlesSom">
					<h3>Controles de som</h3>
					
					<input type="button"
						alt="Bot�o para parar o �udio da aplica��o. - Atalho Alt P."
						id="pararAudioBotao" onclick="javascript: pararAudioNavegacao()" value="Para o �udio" />
				</div>
				
				<div id="blocoTempoNavegaco">
					<h3>Tempo de Navega��o</h3>
	
					<input type="text" readonly="readonly" name="tempoNavegacao"
						id="tempoNavegacao" value="00:35:47"
						alt="Campo tempo de navega��o. Formato do campo hora, minuto e segundo." />
						
					<input type="button" alt="Bot�o para retornar o tempo de navega��o do usu�rio. Atalho Alt T"
						id="tempoNavegacaoBotao" name="tempoNavegacaoBotao" value="Retornar tempo" onclick="javascript: reproduzirTempoNavegacao()"/>
				</div>
				
				<div id="blocoLogNavegacao">
					<h3>Log da Navega��o</h3>
				
					<input type="button" alt="Bot�o para reproduzir o �udio do log atual da navega��o. Atalho Alt L"
						id="logNavegacaoBotao" name="logNavegacaoBotao" value="Reproduzir o log da navega��o" onclick="javascript: reproduzirLogNavegacao()" />
					
					<textarea rows="5" cols="40" id="logNavegacao" name="logNavegacao" readonly="readonly"></textarea>
				
				</div>
			</div>
			<div id="blocoMapa">
				<h2>Mapa 1</h2>
	
				<img alt="Esta � uma imagem de exemplo de um mapa de navega��o"
					id="mapaImg" name="mapaImg"
					src="<c:url value="/resources/img/mapa.png" />">
			</div>
		</div>
	</div>
</body>
</html>
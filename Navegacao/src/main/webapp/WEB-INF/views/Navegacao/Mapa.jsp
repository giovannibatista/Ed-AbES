<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Navegação no Mapa
	Públicos</title>
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
		<h1>Navegação no Mapa 1</h1>
		<p>...</p>
		
		<div id="blocoNavegacaoMapa">			
			<div id="blocoAcoesNavegacao">
				<h2>Comandos para navegação</h2>
				<input type="button"
					alt="Botão para encerrar a navegação - Atalho Alt E."
					id="encerrarNavegacaoBotao" onclick="javascript: encerrarNavegacao()" value="Encerrar Navegação" />
				
				<input type="button"
					alt="Botão para parar a navegação. Você poderá retomar a navegação posteriormente - Atalho Alt S."
					id="pararNavegacaoBotao" onclick="javascript: pararNavegacao()" value="Para Navegação" />
				
				<input type="hidden"
					alt="Botão para retomar a navegação. Atalho Alt S."
					id="retomarNavegacaoBotao" onclick="javascript: retomarNavegacao()" value="Retomar Navegação" />
			
				<div id="blocoControlesSom">
					<h3>Controles de som</h3>
					
					<input type="button"
						alt="Botão para parar o áudio da aplicação. - Atalho Alt P."
						id="pararAudioBotao" onclick="javascript: pararAudioNavegacao()" value="Para o áudio" />
				</div>
				
				<div id="blocoTempoNavegaco">
					<h3>Tempo de Navegação</h3>
	
					<input type="text" readonly="readonly" name="tempoNavegacao"
						id="tempoNavegacao" value="00:35:47"
						alt="Campo tempo de navegação. Formato do campo hora, minuto e segundo." />
						
					<input type="button" alt="Botão para retornar o tempo de navegação do usuário. Atalho Alt T"
						id="tempoNavegacaoBotao" name="tempoNavegacaoBotao" value="Retornar tempo" onclick="javascript: reproduzirTempoNavegacao()"/>
				</div>
				
				<div id="blocoLogNavegacao">
					<h3>Log da Navegação</h3>
				
					<input type="button" alt="Botão para reproduzir o áudio do log atual da navegação. Atalho Alt L"
						id="logNavegacaoBotao" name="logNavegacaoBotao" value="Reproduzir o log da navegação" onclick="javascript: reproduzirLogNavegacao()" />
					
					<textarea rows="5" cols="40" id="logNavegacao" name="logNavegacao" readonly="readonly"></textarea>
				
				</div>
			</div>
			<div id="blocoMapa">
				<h2>Mapa 1</h2>
	
				<img alt="Esta é uma imagem de exemplo de um mapa de navegação"
					id="mapaImg" name="mapaImg"
					src="<c:url value="/resources/img/mapa.png" />">
			</div>
		</div>
	</div>
</body>
</html>
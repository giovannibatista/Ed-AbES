<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Histórico de navegações</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/historico.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/teclasatalhohistorico.js" />"></script>
	
</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main" id="conteudo">
		<h1>Histórico de Navegações</h1>
		
		<p>Esta tela apresenta os históricos das navegações realizadas
			pelo usuário em determinado mapa, exibindo informações sobre o tempo
			de navegação, log da navegação e data de navegação.</p>
		<p>Para reproduzir o log dos movimentos realizados em uma
			determinada navegação, navegue pela tabela abaixo e tecle enter no
			registro desejado.</p>
		<p>O log da navegação consiste em mostrar os movimentos realizados
			durante a navegação nos mapas. Por exemplo: jogador moveu-se para
			cima/norte, jogador deu um passo a frente, jogador abriu um porta.</p>

		<div id="blocoControlesSom">
			<h2>Controles de som</h2>
			<input type="button" id="controleSomBotao" name="controleSomBotao" value="Pausar o áudio"
				alt="Botão pausar o áudio. Para parar a reprodução do log de navegação, tecle Alt P." onclick="javascript: pararAudio()"/>
		</div>
		
		<div id="blocoListaHistoricoNavegacao">
						
			<table border="1" id="historicoNavegacoes">
				<caption>Tabela de histórico das navegações realizadas.</caption>
				<thead>
					<tr>
						<th scope="col">Nome do mapa</th>
						<th scope="col">Data de navegação</th>
						<th scope="col">Tempo de navegação</th>
						<th scope="col">Log da navegação</th>
					</tr>
				</thead>
				<tbody>
					<tr onclick="javascript: reproduzirLogNavegacao(1);">
						<th scope="row" >Mapa 1
						<td>12/11/2015</td>
						<td>00:35:54</td>
						<td><input type="button" id="reproduzirLogNavegacaoBotao" alt="Botão reproduzir log da navegação. Tecle Enter para reproduzir o log dos movimentos realizados."
								onclick="javascript: reproduzirLogNavegacao(1);" value="Reproduzir Log de Navegação"/></td>
					</tr>
					<tr onclick="javascript: reproduzirLogNavegacao(2);">
						<th scope="row" >Mapa 2
						<td>12/11/2014</td>
						<td>00:14:34</td>
						<td><input type="button" id="reproduzirLogNavegacaoBotao" alt="Botão reproduzir log da navegação. Tecle Enter para reproduzir o log dos movimentos realizados."
								onclick="javascript: reproduzirLogNavegacao(2);" value="Reproduzir Log de Navegação"/></td>
					</tr>
				</tbody>
			</table>
		
		</div>
	</div>
</body>
</html>
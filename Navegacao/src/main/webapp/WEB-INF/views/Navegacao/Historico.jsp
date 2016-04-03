<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Hist�rico de navega��es</title>
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
		<h1>Hist�rico de Navega��es</h1>
		
		<p>Esta tela apresenta os hist�ricos das navega��es realizadas
			pelo usu�rio em determinado mapa, exibindo informa��es sobre o tempo
			de navega��o, log da navega��o e data de navega��o.</p>
		<p>Para reproduzir o log dos movimentos realizados em uma
			determinada navega��o, navegue pela tabela abaixo e tecle enter no
			registro desejado.</p>
		<p>O log da navega��o consiste em mostrar os movimentos realizados
			durante a navega��o nos mapas. Por exemplo: jogador moveu-se para
			cima/norte, jogador deu um passo a frente, jogador abriu um porta.</p>

		<div id="blocoControlesSom">
			<h2>Controles de som</h2>
			<input type="button" id="controleSomBotao" name="controleSomBotao" value="Pausar o �udio"
				alt="Bot�o pausar o �udio. Para parar a reprodu��o do log de navega��o, tecle Alt P." onclick="javascript: pararAudio()"/>
		</div>
		
		<div id="blocoListaHistoricoNavegacao">
						
			<table border="1" id="historicoNavegacoes">
				<caption>Tabela de hist�rico das navega��es realizadas.</caption>
				<thead>
					<tr>
						<th scope="col">Nome do mapa</th>
						<th scope="col">Data de navega��o</th>
						<th scope="col">Tempo de navega��o</th>
						<th scope="col">Log da navega��o</th>
					</tr>
				</thead>
				<tbody>
					<tr onclick="javascript: reproduzirLogNavegacao(1);">
						<th scope="row" >Mapa 1
						<td>12/11/2015</td>
						<td>00:35:54</td>
						<td><input type="button" id="reproduzirLogNavegacaoBotao" alt="Bot�o reproduzir log da navega��o. Tecle Enter para reproduzir o log dos movimentos realizados."
								onclick="javascript: reproduzirLogNavegacao(1);" value="Reproduzir Log de Navega��o"/></td>
					</tr>
					<tr onclick="javascript: reproduzirLogNavegacao(2);">
						<th scope="row" >Mapa 2
						<td>12/11/2014</td>
						<td>00:14:34</td>
						<td><input type="button" id="reproduzirLogNavegacaoBotao" alt="Bot�o reproduzir log da navega��o. Tecle Enter para reproduzir o log dos movimentos realizados."
								onclick="javascript: reproduzirLogNavegacao(2);" value="Reproduzir Log de Navega��o"/></td>
					</tr>
				</tbody>
			</table>
		
		</div>
	</div>
</body>
</html>
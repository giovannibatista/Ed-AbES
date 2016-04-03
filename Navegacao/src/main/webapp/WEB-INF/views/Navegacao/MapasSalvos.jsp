<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Iniciar Navega��o
	P�blicos</title>
<jsp:include page="../Imports.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/js/Navegacao/navegacao.js" />"></script>
</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>

	<div role="main" id="conteudo">
		<h1>Iniciar navega��o</h1>
		<p>Para iniciar uma navega��o, escolha um dos mapas salvos na
			tabela abaixo.</p>
		<p>Para navegar entre a lista de mapas salvos, utilize as teclas
			de atalho de navega��o em tabelas. O uso do mouse tamb�m � permitido.
		</p>
		<p>Caso voc� n�o tenha nenhum mapa salvo, acesse a op��o de menu
			"Mapas p�blicos", utilizando o atalho "Alt 2". Fazendo isto, voc�
			poder� verificar os mapas dispon�veis e escolher um ou ou mais mapas
			para navega��o. Para isto, selecione a op��o "Salvar mapa" quando
			estiver na linha do mapa que desejar salvar. A tabela apresenta o
			Nome do Mapa, Descri��o, Tipo do Mapa e Data de altera��o.</p>

		<div id="mapasSalvosArea">
			<table border="1" id="mapasSalvos">
				<caption>Tabela dos mapas p�blicos salvos.</caption>
				<thead>
					<tr>
						<th scope="col">Nome do Mapa</th>
						<th scope="col">Descri��o</th>
						<th scope="col">Tipo do Mapa</th>
						<th scope="col">Data de altera��o</th>
						<th scope="col">A��es</th>

					</tr>
				</thead>
				<tbody>
					<tr onclick="javascript: abrirResumo(1);">
						<th scope="row" onclick="javascript: abrirResumo(1);">Mapa 1
						</th>
						<td>Descri��o do mapa 1</td>
						<td>Desafio</td>
						<td>19/03/2016</td>
						<td><input type="button" id="salvarMapaBotao"
								onclick="javascript: abrirResumo(1);" value="Iniciar Navega��o do Mapa 1" /></td>
					</tr>
					<tr onclick="javascript: abrirResumo(2);">
						<th scope="row">Mapa 2
						</th>
						<td>Descri��o do mapa 2 � tal...</td>
						<td>Livre</td>
						<td>01/02/2016</td>
						<td><input type="button" id="salvarMapaBotao"
								onclick="javascript: abrirResumo(2);" value="Iniciar Navega��o do Mapa 2" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
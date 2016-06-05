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

<script type="text/javascript">
function abrirLogNavegacao(idHistoricoNavegacao){
	document.location = "/Historico/Consultar/"+idHistoricoNavegacao;
}
</script>

</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main" id="conteudo">
		<h1>Hist�rico de Navega��o</h1>

		<p>Esta tela apresenta os hist�ricos das navega��es realizadas
			pelo usu�rio em determinado mapa, exibindo informa��es sobre o tempo
			de navega��o, log de navega��o e data de navega��o.</p>
		<p>Voc� poder� acessar o log do hist�rico de navega��o e escut�-lo
			utilizando o leitor de telas ou baixar ele no formato TXT para sua
			m�quina.</p>
		<p>O log de navega��o consiste em mostrar os movimentos e a��es
			realizados durante a navega��o nos mapas. Como por exemplo: Voc�
			andou um passo ao Sul. Voc� se virou para o Oeste. Voc� se virou para
			o Norte. Etc.</p>

		<div id="blocoListaHistoricoNavegacao">
			<c:choose>
				<c:when test="${not empty historicoNavegacoes}">
					<table border="1" id="historicoNavegacoes" class="listas">
						<caption>Tabela de hist�rico das navega��es realizadas.</caption>
						<thead>
							<tr>
								<th scope="col">Nome do mapa</th>
								<th scope="col">Data de navega��o</th>
								<th scope="col">Tempo de navega��o</th>
								<th scope="col">Abrir log de navega��o</th>
								<th scope="col">Download log de navega��o</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${historicoNavegacoes}" var="historico">
								<tr>
									<th scope="row">${historico.mapa.nome}</th>
									<td>${historico.dataNavegacao}</td>
									<td>${historico.tempoNavegacao}</td>
									<td><input type="button" id="abrirLogNavegacaoBotao${historico.id}"
										aria-label="Bot�o para abrir o log de navega��o em uma nova janela."
										onclick="javascript: abrirLogNavegacao(${historico.id});"
										value="Abrir log de Navega��o" /></td>
									<td><input type="button" id="downloadLogNavegacaoBotao${historico.id}"
										aria-label="Bot�o realizar download log de navega��o para um arquivo no formato TXT."
										onclick="javascript: downloadLogNavegacao(${historico.id});"
										value="Dowload do log de Navega��o" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<div id="blocoListaMapasVazio" class="blocoListaVazio">
						<p>Nenhum hist�rico de navega��o encontrado.</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
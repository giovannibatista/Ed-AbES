<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Histórico de
	navegação</title>
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
		<h1>Histórico de Navegação</h1>

		<p>Esta tela apresenta os históricos das navegações realizadas
			pelo usuário em determinado mapa, exibindo informações sobre o tempo
			de navegação, log de navegação e data de navegação.</p>
		<p>Você poderá acessar o log do histórico de navegação e escutá-lo
			utilizando o leitor de telas ou baixar ele no formato TXT para sua
			máquina.</p>
		<p>O log de navegação consiste em mostrar os movimentos e ações
			realizados durante a navegação nos mapas. Como por exemplo: Você
			andou um passo ao Sul. Você se virou para o Oeste. Você se virou para
			o Norte. Etc.</p>

		<div id="blocoListaHistoricoNavegacao">
			<c:choose>
				<c:when test="${not empty historicoNavegacoes}">
					<table border="1" id="historicoNavegacoes" class="listas">
						<caption>Tabela de histórico das navegações realizadas.</caption>
						<thead>
							<tr>
								<th scope="col">Nome do mapa</th>
								<th scope="col">Data de navegação</th>
								<th scope="col">Tempo de navegação</th>
								<th scope="col">Abrir log de navegação</th>
								<th scope="col">Download log de navegação</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${historicoNavegacoes}" var="historico">
								<tr>
									<th scope="row">${historico.mapa.nome}</th>
									<td>${historico.dataNavegacao}</td>
									<td>${historico.tempoNavegacao}</td>
									<td><input type="button" id="abrirLogNavegacaoBotao${historico.id}"
										aria-label="Botão para abrir o log de navegação em uma nova janela."
										onclick="javascript: abrirLogNavegacao(${historico.id});"
										value="Abrir log de Navegação" /></td>
									<td><input type="button" id="downloadLogNavegacaoBotao${historico.id}"
										aria-label="Botão realizar download log de navegação para um arquivo no formato TXT."
										onclick="javascript: downloadLogNavegacao(${historico.id});"
										value="Dowload do log de Navegação" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<div id="blocoListaMapasVazio" class="blocoListaVazio">
						<p>Nenhum histórico de navegação encontrado.</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
<div id="controlesAcessibilidade">
	<ul id="acessibilidade">
		<li><a href="#conteudo" title="Ir direto ao conte�do da p�gina">Saltar
				para conte�do</a></li>
		<li><a id="altoContraste" href=""
			onclick="setActiveStyleSheet('preto_branco', true); ocultarElemento('coresOriginais','altoContraste'); return false; "
			title="Ativar alto contraste">Alto contraste</a></li>
		<li><a id="coresOriginais" class="oculto" title="Voltar para as cores originais"
			onclick="setActiveStyleSheet('padrao', true); ocultarElemento('altoContraste','coresOriginais'); return false; "
			href="#topo-pg">Cores originais</a></li>

	</ul>
</div>
<nav id="menu">
	<ul class="nav nav-pills">
		<li role="presentation"><a href="/Navegacao/Listar"
			title="Iniciar Navega��o - Atalho Alt 1">Iniciar Navega��o</a></li>

		<li role="presentation"><a href="/Mapa/Listar"
			title="Mapas P�blicos - Atalho Alt 2">Mapas P�blicos</a></li>

		<li role="presentation"><a href="/Navegacao/Treinamento"
			title="M�dulo de Treinamento - Atalho Alt 3">M�dulo de
				Treinamento</a></li>

		<li role="presentation"><a href="/Ajuda/Sobre"
			title="Sobre - Atalho Alt 4">Sobre</a></li>

		<li role="presentation"><a href="/Ajuda/TeclasAtalho"
			title="Teclas de Atalho - Atalho Alt 5">Teclas de Atalho</a></li>

		<li role="presentation"><a href="/Navegacao/Historico"
			title="Hist�rio de Navega��es - Atalho Alt 6">Hist�rio de
				Navega��es</a></li>
		<li role="presentation" class="menuItemRight"><a
			href="/Usuario/Editar" title="Usu�rio - Atalho Alt 7">Usu�rio</a></li>
	</ul>
</nav>
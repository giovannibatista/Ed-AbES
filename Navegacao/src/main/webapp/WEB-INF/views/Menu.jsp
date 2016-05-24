<div id="controlesAcessibilidade">
	<ul id="acessibilidade">
		<li><a href="#conteudo" title="Ir direto ao conteúdo da página">Saltar
				para conteúdo</a></li>
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
			title="Iniciar Navegação - Atalho Alt 1">Iniciar Navegação</a></li>

		<li role="presentation"><a href="/Mapa/Listar"
			title="Mapas Públicos - Atalho Alt 2">Mapas Públicos</a></li>

		<li role="presentation"><a href="/Navegacao/Treinamento"
			title="Módulo de Treinamento - Atalho Alt 3">Módulo de
				Treinamento</a></li>

		<li role="presentation"><a href="/Ajuda/Sobre"
			title="Sobre - Atalho Alt 4">Sobre</a></li>

		<li role="presentation"><a href="/Ajuda/TeclasAtalho"
			title="Teclas de Atalho - Atalho Alt 5">Teclas de Atalho</a></li>

		<li role="presentation"><a href="/Navegacao/Historico"
			title="Histório de Navegações - Atalho Alt 6">Histório de
				Navegações</a></li>
		<li role="presentation" class="menuItemRight"><a
			href="/Usuario/Editar" title="Usuário - Atalho Alt 7">Usuário</a></li>
	</ul>
</nav>
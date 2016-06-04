<div id="controlesAcessibilidade">
	<ul id="acessibilidade">
		<li><a href="#conteudo" aria-label="Ir direto ao conteúdo da página">Pular
				para conteúdo</a></li>
		<li><a href="javascript:void(0)"
			onclick="setActiveStyleSheet('preto_branco', true); ocultarElemento('coresOriginais','altoContraste'); return false;"
			id="altoContraste" aria-label="Ativar alto contraste">Alto contraste</a></li>
		<li><a href="javascript:void(0)"
			onclick="setActiveStyleSheet('padrao', true); ocultarElemento('altoContraste','coresOriginais'); return false;"
			id="coresOriginais" class="oculto"
			aria-label="Voltar para as cores originais">Cores originais</a></li>

	</ul>
</div>
<nav id="menu" role="navigation">
	<ul class="nav nav-pills">
		<li><a href="/Navegacao/Listar"
			aria-label="Iniciar Navegação - Atalho Alt 1">Iniciar Navegação</a></li>

		<li><a href="/Mapa/Listar"
			aria-label="Mapas Públicos - Atalho Alt 2">Mapas Públicos</a></li>

		<li><a href="/Navegacao/Treinamento"
			aria-label="Módulo de Treinamento - Atalho Alt 3">Módulo de
				Treinamento</a></li>

		<li><a href="/Ajuda/Sobre"
			aria-label="Sobre - Atalho Alt 4">Sobre</a></li>

		<li><a href="/Ajuda/TeclasAtalho"
			aria-label="Teclas de Atalho - Atalho Alt 5">Teclas de Atalho</a></li>

		<li><a href="/Historico/Listar"
			aria-label="Histórico de Navegação - Atalho Alt 6">Histórico de
				Navegação</a></li>

		<li class="menuItemRight"><a
			href="/Usuario/Editar" aria-label="Usuário - Atalho Alt 7">Usuário</a></li>
	</ul>
</nav>
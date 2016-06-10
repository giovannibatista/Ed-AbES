<div id="controlesAcessibilidade">
	<ul id="acessibilidade">
		<li><a href="#conteudo" aria-label="Pular para o conteúdo da página">Pular
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
<nav id="menu">
	<ul class="nav nav-pills">
		<li><a href="/Navegacao/Listar"
			aria-label="Item de menu  Iniciar Navegação - Atalho Alt 1">Iniciar Navegação</a></li>

		<li><a href="/Mapa/Listar"
			aria-label="Item de menu Mapas Públicos - Tecla de Atalho Alt 2">Mapas Públicos</a></li>

		<li><a href="/Navegacao/Treinamento"
			aria-label="Item de menu Módulo de Treinamento - Tecla de Atalho Alt 3">Módulo de
				Treinamento</a></li>

		<li><a href="/Ajuda/Sobre"
			aria-label="Item de menu Sobre - Tecla de Atalho Alt 4">Sobre</a></li>

		<li><a href="/Ajuda/TeclasAtalho"
			aria-label="Item de menu Teclas de Atalho - Tecla de Atalho Alt 5">Teclas de Atalho</a></li>

		<li><a href="/Historico/Listar"
			aria-label="Item de menu Histórico de Navegação - Tecla de Atalho Alt 6">Histórico de
				Navegação</a></li>

		<li class="menuItemRight"><a
			href="/Usuario/Login" aria-label="Item de menu Usuário - Tecla de Atalho Alt 7">Usuário</a></li>
	</ul>
</nav>
<div id="controlesAcessibilidade">
	<ul id="acessibilidade">
		<li><a href="#conteudo" aria-label="Ir direto ao conte�do da p�gina">Pular
				para conte�do</a></li>
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
			aria-label="Iniciar Navega��o - Atalho Alt 1">Iniciar Navega��o</a></li>

		<li><a href="/Mapa/Listar"
			aria-label="Mapas P�blicos - Atalho Alt 2">Mapas P�blicos</a></li>

		<li><a href="/Navegacao/Treinamento"
			aria-label="M�dulo de Treinamento - Atalho Alt 3">M�dulo de
				Treinamento</a></li>

		<li><a href="/Ajuda/Sobre"
			aria-label="Sobre - Atalho Alt 4">Sobre</a></li>

		<li><a href="/Ajuda/TeclasAtalho"
			aria-label="Teclas de Atalho - Atalho Alt 5">Teclas de Atalho</a></li>

		<li><a href="/Historico/Listar"
			aria-label="Hist�rico de Navega��o - Atalho Alt 6">Hist�rico de
				Navega��o</a></li>

		<li class="menuItemRight"><a
			href="/Usuario/Editar" aria-label="Usu�rio - Atalho Alt 7">Usu�rio</a></li>
	</ul>
</nav>
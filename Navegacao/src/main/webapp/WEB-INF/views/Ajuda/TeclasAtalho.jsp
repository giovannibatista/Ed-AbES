<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Teclas de Atalho</title>
<jsp:include page="../Imports.jsp" />

</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main">
		<article id="conteudo">
			<h1>Teclas de Atalho do Ed-AbES - M�dulo de Navega��o</h1>
			<p>As teclas de navega��o est�o organizadas em categorias:</p>
			<div id="menuConteudo">
				<ul>
					<li><a href="#teclasMenu"
						aria-label="Pular para Navega��o em menu">Navega��o em menu</a></li>
					<li><a href="#teclasMapa"
						aria-label="Pular para Navega��o no mapa">Navega��o no mapa</a></li>
					<li><a href="#teclasTabelas"
						aria-label="Pular para Navega��o tabela de mapas
							e no hist�rico de navega��o">Navega��o
							em tabela de mapas e no hist�rico de navega��o</a></li>
					<!-- <li><a href="#teclasAcesso"
						aria-label="Pular para Teclas de acesso r�pido">Teclas de
							acesso r�pido</a></li> -->
				</ul>
			</div>
		</article>

		<article id="teclasMenu">
			<h2>Navega��o em Menu</h2>
			<p>Pode-se utilizar a tecla TAB ou utilizar uma das teclas de
				atalho descritas a seguir</p>
			<ul>
				<li><p>"Alt 1" - Op��o do menu principal - Iniciar
						Navega��o. Para iniciar uma navega��o, o pr�-requisito � que
						usu�rio tenha salvo um mapa na op��o "Mapas P�blicos", para o
						mesmo estar acess�vel na lista de "Mapas Salvos", e com isso
						iniciar uma navega��o. N�o havendo mapas salvos, o usu�rio deve
						acessar a aba "Mapas P�blicos", para que possa trazer para sua
						�rea, um mapa que esteja dispon�vel para navega��o.</p></li>
				<li><p>"Alt 2" - Op��o do menu principal - Listar Mapas
						P�blicos. O pr�-requisito desta op��o � possuir mapas p�blicos
						constru�dos no m�dulo de constru��o do Ed-AbES. Nesta op��o ser�o
						mostrados os mapas p�blicos dispon�veis para navega��o, contendo o
						nome do mapa, descri��o, tipo, data de altera��o e a op��o para
						salvar o mapa, que s�o dispostas em forma de tabela. Para salvar o
						mapa para navega��o futura, o usu�rio deve selecionar a op��o
						"Salvar mapa".</p></li>
				<li><p>"Alt 3" - Op��o do menu principal - M�dulo de
						Treinamento. Esta op��o permite que o usu�rio a treine a navega��o
						em um mapa gen�rico, antes de navegar em um mapa real. Com isto,
						tem o objetivo de ser id�ntica a uma tela de navega��o do Ed-AbES.
						Portanto, a tela, op��es, teclas de atalho e instru��es
						apresentadas para esta funcionalidade s�o iguais as da op��o
						"Iniciar navega��o".</p></li>
				<li><p>"Alt 4" - Op��o do menu principal - Sobre o sistema.
						Nesta op��o o usu�rio poder� ter informa��es sobre o Ed-AbES,
						sobre o M�dulo de Navega��o e sobre os desenvolvedores da
						aplica��o.</p></li>
				<li><p>"Alt 5" - Op��o do menu principal - Teclas de
						atalho. Nesta tela, o usu�rio ser� informado sobre todas as teclas
						de atalho necess�rias para a utiliza��o e opera��o do Ed-AbES -
						M�dulo de Navega��o, como por exemplo: teclas de acesso r�pido,
						teclas para utilizar o menu, entre outras.</p></li>
				<li><p>"Alt 6" - Op��o do menu principal - Hist�rico de
						navega��o. Acessa o log de navega��o do usu�rio no mapa. Caso o
						usu�rio n�o tenha realizado nenhuma navega��o, o usu�rio �
						informado que n�o h� hist�rico de navega��o dispon�vel. Caso o
						usu�rio j� tenha realizado uma ou mais navega��es, esta op��o
						possibilitar� ao usu�rio ouvir seus hist�ricos de navega��o em um
						determinado mapa. Esta op��o ter� uma lista com as navega��es
						organizadas por nome do mapa, data da navega��o e tempo de
						navega��o.</p></li>
				<li><p>"Alt 7" - Op��o do menu principal - Informa��es
						sobre o usu�rio. Nesta op��o o usu�rio ter� acesso as suas
						informa��es de cadastro, como nome, e-mail, etc.</p></li>

			</ul>
		</article>

		<a href="#conteudo">Voltar para o topo</a>

		<article id="teclasMapa">
			<h2>Navega��o no mapa</h2>
			<ul>
				<li><p>Seta "para cima/Up" - Move o jogador um passo a
						frente.</p></li>
				<li><p>Seta "para baixo/Down" - Move o jogador um passo
						para tr�s.</p></li>
				<li><p>Seta "esquerda/Left" - Gira o jogador 90 graus �
						esquerda no sentido anti-hor�rio.</p></li>
				<li><p>Seta "direta/Right" - Gira o jogador 90 graus �
						direita sentido hor�rio.</p></li>
				<li><p>"Alt C" - Informa a descri��o do �ltimo objeto que o
						jogador colidiu.</p></li>
				<li><p>"Alt E" - Encerra a navega��o e questiona o usu�rio
						se deseja salvar o hist�rico da navega��o.</p></li>
				<li><p>"Alt L" - Reproduzir o log da navega��o corrente.</p></li>
				<li><p>"Alt M" - Informa��es sobre o mapa. Retorna o nome,
						pavimento, descri��o e objetivo do mapa.</p></li>
				<li><p>"Alt O" - Informa a localiza��o atual do jogador no
						mapa.</p></li>
				<li><p>"Alt P" - Controle de som: pausa ou retoma o �udio,
						de acordo com a situa��o do �udio no momento em que a tecla �
						acionada.</p></li>
				<li><p>"Alt R" - Informa quais objetos est�o ao redor do
						jogador at� um passo de dist�ncia, permitindo que o mesmo possa
						compreender o espa�o a sua volta e, assim, tomar decis�es sobre
						sua movimenta��o no cen�rio. Ao acionar o comando, caso hajam
						objetos ao redor, ser� lido o nome, pavimento e descri��o do
						mesmo. Caso n�o hajam objetos em at� um passo de dist�ncia do
						jogador, a aplica��o informa que n�o existem objetos ao redor.</p></li>
				<li><p>"Alt S" - Pausar e retomar a navega��o. Fazendo
						isto, o temporizador da aplica��o vai pausar e retomar quando o
						comando foi acionado.</p></li>
				<li><p>"Alt T" - Informa o tempo que o jogador est�
						navegando no mapa.</p></li>
				<li><p>"F9" - Informa as teclas de atalho durante a
						navega��o.</p></li>

			</ul>
		</article>

		<a href="#conteudo">Voltar para o topo</a>

		<article id="teclasTabelas">
			<h2>Navega��o em tabelas de mapas e no hist�rico de navega��o.</h2>
			<ul>
				<li><p>Setas "esquerda" - Utilize esta seta para voltar
						colunas e linhas.</p></li>
				<li><p>Seta "direita" - Utilize esta seta para avan�ar
						colunas e linhas.</p></li>
				<li><p>"TAB" - Esta tecla alterna entre as colunas e linhas
						da tabela.</p></li>
				<li><p>"Ctrl Alt Seta Esquerda" - Move o cursor do sistema
						para a coluna anterior, permanecendo na mesma linha.</p></li>
				<li><p>"Ctrl Alt Seta Direita" - Move o cursor do sistema
						para a pr�xima coluna, permanecendo na mesma linha.</p></li>
				<li><p>"Ctrl Alt Seta Acima" - Move o cursor do sistema
						para a linha anterior, permanecendo na mesma coluna.</p></li>
				<li><p>"Ctrl Alt Seta Abaixo" - Move o cursor do sistema
						para a linha seguinte, permanecendo na mesma coluna.</p></li>
			</ul>
		</article>

		<!-- <a href="#conteudo">Voltar para o topo</a>

		<article id="teclasAcesso">
			<h2>Teclas de acesso r�pido</h2>
			<ul>
				<li><p>"F2" - Informa as teclas de atalho dispon�veis para
						a tela em que o usu�rio se encontra.</p></li>
				<li><p>"F8" - Informa��es b�sicas sobre a tela em que o
						usu�rio se encontra.</p></li>
			</ul>
 -->
		</article>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
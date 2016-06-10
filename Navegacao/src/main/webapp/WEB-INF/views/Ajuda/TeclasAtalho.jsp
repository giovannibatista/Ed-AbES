<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Teclas de Atalho</title>
<jsp:include page="../Imports.jsp" />

</head>
<body>
	<header>
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main">
		<article id="conteudo">
			<h1>Teclas de Atalho do Ed-AbES - Módulo de Navegação</h1>
			<p>As teclas de navegação estão organizadas em categorias:</p>
			<div id="menuConteudo">
				<ul>
					<li><a href="#teclasMenu"
						aria-label="Pular para Navegação em menu">Navegação em menu</a></li>
					<li><a href="#teclasMapa"
						aria-label="Pular para Navegação no mapa">Navegação no mapa</a></li>
					<li><a href="#teclasTabelas"
						aria-label="Pular para Navegação tabela de mapas
							e no histórico de navegação">Navegação
							em tabela de mapas e no histórico de navegação</a></li>
					<!-- <li><a href="#teclasAcesso"
						aria-label="Pular para Teclas de acesso rápido">Teclas de
							acesso rápido</a></li> -->
				</ul>
			</div>
		</article>

		<article id="teclasMenu">
			<h2>Navegação em Menu</h2>
			<p>Pode-se utilizar a tecla TAB ou utilizar uma das teclas de
				atalho descritas a seguir</p>
			<ul>
				<li><p>"Alt 1" - Opção do menu principal - Iniciar
						Navegação. Para iniciar uma navegação, o pré-requisito é que
						usuário tenha salvo um mapa na opção "Mapas Públicos", para o
						mesmo estar acessível na lista de "Mapas Salvos", e com isso
						iniciar uma navegação. Não havendo mapas salvos, o usuário deve
						acessar a aba "Mapas Públicos", para que possa trazer para sua
						área, um mapa que esteja disponível para navegação.</p></li>
				<li><p>"Alt 2" - Opção do menu principal - Listar Mapas
						Públicos. O pré-requisito desta opção é possuir mapas públicos
						construídos no módulo de construção do Ed-AbES. Nesta opção serão
						mostrados os mapas públicos disponíveis para navegação, contendo o
						nome do mapa, descrição, tipo, data de alteração e a opção para
						salvar o mapa, que são dispostas em forma de tabela. Para salvar o
						mapa para navegação futura, o usuário deve selecionar a opção
						"Salvar mapa".</p></li>
				<li><p>"Alt 3" - Opção do menu principal - Módulo de
						Treinamento. Esta opção permite que o usuário a treine a navegação
						em um mapa genérico, antes de navegar em um mapa real. Com isto,
						tem o objetivo de ser idêntica a uma tela de navegação do Ed-AbES.
						Portanto, a tela, opções, teclas de atalho e instruções
						apresentadas para esta funcionalidade são iguais as da opção
						"Iniciar navegação".</p></li>
				<li><p>"Alt 4" - Opção do menu principal - Sobre o sistema.
						Nesta opção o usuário poderá ter informações sobre o Ed-AbES,
						sobre o Módulo de Navegação e sobre os desenvolvedores da
						aplicação.</p></li>
				<li><p>"Alt 5" - Opção do menu principal - Teclas de
						atalho. Nesta tela, o usuário será informado sobre todas as teclas
						de atalho necessárias para a utilização e operação do Ed-AbES -
						Módulo de Navegação, como por exemplo: teclas de acesso rápido,
						teclas para utilizar o menu, entre outras.</p></li>
				<li><p>"Alt 6" - Opção do menu principal - Histórico de
						navegação. Acessa o log de navegação do usuário no mapa. Caso o
						usuário não tenha realizado nenhuma navegação, o usuário é
						informado que não há histórico de navegação disponível. Caso o
						usuário já tenha realizado uma ou mais navegações, esta opção
						possibilitará ao usuário ouvir seus históricos de navegação em um
						determinado mapa. Esta opção terá uma lista com as navegações
						organizadas por nome do mapa, data da navegação e tempo de
						navegação.</p></li>
				<li><p>"Alt 7" - Opção do menu principal - Informações
						sobre o usuário. Nesta opção o usuário terá acesso as suas
						informações de cadastro, como nome, e-mail, etc.</p></li>

			</ul>
		</article>

		<a href="#conteudo">Voltar para o topo</a>

		<article id="teclasMapa">
			<h2>Navegação no mapa</h2>
			<ul>
				<li><p>Seta "para cima/Up" - Move o jogador um passo a
						frente.</p></li>
				<li><p>Seta "para baixo/Down" - Move o jogador um passo
						para trás.</p></li>
				<li><p>Seta "esquerda/Left" - Gira o jogador 90 graus à
						esquerda no sentido anti-horário.</p></li>
				<li><p>Seta "direta/Right" - Gira o jogador 90 graus à
						direita sentido horário.</p></li>
				<li><p>"Alt C" - Informa a descrição do último objeto que o
						jogador colidiu.</p></li>
				<li><p>"Alt E" - Encerra a navegação e questiona o usuário
						se deseja salvar o histórico da navegação.</p></li>
				<li><p>"Alt L" - Reproduzir o log da navegação corrente.</p></li>
				<li><p>"Alt M" - Informações sobre o mapa. Retorna o nome,
						pavimento, descrição e objetivo do mapa.</p></li>
				<li><p>"Alt O" - Informa a localização atual do jogador no
						mapa.</p></li>
				<li><p>"Alt P" - Controle de som: pausa ou retoma o áudio,
						de acordo com a situação do áudio no momento em que a tecla é
						acionada.</p></li>
				<li><p>"Alt R" - Informa quais objetos estão ao redor do
						jogador até um passo de distância, permitindo que o mesmo possa
						compreender o espaço a sua volta e, assim, tomar decisões sobre
						sua movimentação no cenário. Ao acionar o comando, caso hajam
						objetos ao redor, será lido o nome, pavimento e descrição do
						mesmo. Caso não hajam objetos em até um passo de distância do
						jogador, a aplicação informa que não existem objetos ao redor.</p></li>
				<li><p>"Alt S" - Pausar e retomar a navegação. Fazendo
						isto, o temporizador da aplicação vai pausar e retomar quando o
						comando foi acionado.</p></li>
				<li><p>"Alt T" - Informa o tempo que o jogador está
						navegando no mapa.</p></li>
				<li><p>"F9" - Informa as teclas de atalho durante a
						navegação.</p></li>

			</ul>
		</article>

		<a href="#conteudo">Voltar para o topo</a>

		<article id="teclasTabelas">
			<h2>Navegação em tabelas de mapas e no histórico de navegação.</h2>
			<ul>
				<li><p>Setas "esquerda" - Utilize esta seta para voltar
						colunas e linhas.</p></li>
				<li><p>Seta "direita" - Utilize esta seta para avançar
						colunas e linhas.</p></li>
				<li><p>"TAB" - Esta tecla alterna entre as colunas e linhas
						da tabela.</p></li>
				<li><p>"Ctrl Alt Seta Esquerda" - Move o cursor do sistema
						para a coluna anterior, permanecendo na mesma linha.</p></li>
				<li><p>"Ctrl Alt Seta Direita" - Move o cursor do sistema
						para a próxima coluna, permanecendo na mesma linha.</p></li>
				<li><p>"Ctrl Alt Seta Acima" - Move o cursor do sistema
						para a linha anterior, permanecendo na mesma coluna.</p></li>
				<li><p>"Ctrl Alt Seta Abaixo" - Move o cursor do sistema
						para a linha seguinte, permanecendo na mesma coluna.</p></li>
			</ul>
		</article>

		<!-- <a href="#conteudo">Voltar para o topo</a>

		<article id="teclasAcesso">
			<h2>Teclas de acesso rápido</h2>
			<ul>
				<li><p>"F2" - Informa as teclas de atalho disponíveis para
						a tela em que o usuário se encontra.</p></li>
				<li><p>"F8" - Informações básicas sobre a tela em que o
						usuário se encontra.</p></li>
			</ul>
 -->
		</article>

		<a href="#conteudo">Voltar para o topo</a>

	</div>
</body>
</html>
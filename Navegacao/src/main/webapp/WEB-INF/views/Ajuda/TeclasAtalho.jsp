<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Teclas de Atalho</title>
<jsp:include page="../Imports.jsp" />

</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main" id="conteudo">
		<article>
			<h1>Teclas de Atalho do Ed_AbES - Módulo de Navegação</h1>
			<p>Esta página apresenta as teclas de atalho que são utilizadas na
				aplicação.</p>
		</article>
		
		<article>
			<h2>Menu da aplicação</h2>
			<p>Para navegar entre as opções do menu principal o usuário pode
				utilizar os atalhos listados na tabela abaixo ou então utilizar a
				tecla TAB, que alterna entre cada opção. Utilizando a tecla "TAB",
				basta pressionar "Enter" para acessar opção de menu desejada. A
				utilização do mouse permanece habilitada.</p>
			<ul>
				<li>"Alt 1 - Iniciar Navegação. Para
					iniciar uma navegação, o pré-requisito é que usuário tenha salvo um
					mapa na opção "Mapas Públicos", para o mesmo estar acessível na
					lista de "Meus Mapas", e com isso iniciar uma navegação. Não
					havendo mapas salvos, o usuário deve acessar a aba "Mapas
					Públicos", para que possa trazer para sua área, um mapa que esteja
					disponível para navegação.</li>
				<li>"Alt 2" - Listar Mapas Públicos.
					O pré-requisito desta opção é possuir mapas públicos construídos no
					módulo de construção do Ed-AbES. Nesta opçãp serão mostrados os
					mapas públicos disponíveis para navegação, contendo o nome,
					descrição, objetivo, tipo, andar, autor, data de criação do mapa e
					a opção para salvar o mapa, que são dispostas em formas de tabela.
					Para salvar o mapa para navegação futura, o usuário deve selecionar
					a opção "Salvar mapa".</li>
				<li>"Alt 3" - Módulo de Treinamento. Esta opção permite o
					usuário a treinar a navegação em um mapa genérico, antes de navegar
					em um mapa real. Com isto, tem o objetivo de ser idêntica a uma
					tela de navegação do Ed-AbES. Portanto, a tela, opções, teclas de
					atalho e instruções apresentadas para esta funcionalidade são
					iguais as da opção "Iniciar navegação".</li>
				<li>"Alt 4" - Sobre o sistema. Nesta opção o usuário poderá ter
					informações sobre o Ed-AbES, sobre o Módulo de Navegação e sobre os
					desenvolvedores da aplicação.</li>
				<li>"Alt 5" - Teclas de Atalho. Nesta tela, o usuário será
					informado sobre todas as teclas de atalho necessárias para a
					utilização e operação do Ed-AbES, como por exemplo: teclas de
					acesso rápido, teclas para utilizar o menu, entre outras.</li>
				<li>"Alt 6" - Acessa o log de navegação do usuário no mapa.
					Caso o usuário não tenha realizado nenhuma navegação, o usuário é
					informado que não há histórico de navegação disponível. Caso o
					usuário já tenha realizado uma ou mais navegações, esta opção
					possibilitará ao usuário ouvir seus históricos de navegações em um
					determinado mapa. Esta opção terá uma lista com as navegações
					organizadas por nome do mapa, data da navegação e tempo de
					navegação.</li>
				<li>"Alt 7" - Informações sobre o usuário. Nesta opção o
					usuário terá acesso as suas informações de cadastro, como nome,
					e-mail, etc.</li>

			</ul>
		</article>
		
		<article>
			<h2>Teclas de acesso rápido</h2>
			<p>Teclas de acesso rápido são teclas de atalho que acessam rapidamente algumas funções do Ed EbES - Módulo de Navegação. Estas teclas são:</p>
			<ul>
				<li>"F2" - Informa as teclas de atalho disponíveis para a tela em que o usuário se encontra.</li>
				<li>"F8" - Informações básicas sobre a tela em que o usuário se encontra.</li>
			</ul>
			
		</article>
		
		<article>
			<h2>Navegação no mapa</h2>
			<p>Durante a navegação no mapa existem teclas de atalho que o
				usuário precisa conhecer para poder se locomover e saber o que há ao
				seu redor. Segue tabela de atalhos para a navegação no mapa:</p>
			<ul>
				<li>Setas "cima", "baixo" e "esquerda", "direita"  - Permite que o jogador altere a direção para Norte, Sul, Oeste e Leste, respectivamente.</li>
				<li>"Espaço" - Jogador avança um passo à sua frente.</li>
				<li>"Alt E" - Encerra a navegação.</li>
				<li>"Alt I" - Informa o local do jogador no cenário e para que direção está virado.</li>
				<li>"Alt L" - Reproduzir o log da navegação corrente.</li>
				<li>"Alt O" - Informa o objetivo do mapa atual, se houver.</li>
				<li>"Alt P" - Controle de som: pausa ou retoma o áudio, de acordo com a situação do áudio no momento em que a tecla é acionada.</li>
				<li>"Alt R" - Informa quais objetos estão ao redor do jogador, permitindo que o mesmo possa compreender o espaço a sua volta e, assim, tomar decisões sobre sua movimentação no cenário.</li>
				<li>"Alt S" - Pausar e retomar a navegação.</li>
				<li>"Alt T" - Abre as portas fechadas na navegação.</li>
				<li>"F3" - Informa as teclas de atalho durante a navegação.</li>
				
			</ul>
		</article>
		
		<article>
			<h2>Navegação nas tabelas</h2>
			<p>Para navegar em tabelas, existem teclas especiais que facilitam a navegação. Seguem as teclas de atalho</p>
			<ul>
				<li>Setas "esquerda" - Utilize esta seta para voltar colunas e
					linhas.</li>
				<li>Seta "direita" - Utilize esta seta para avançar colunas e
					linhas.</li>
				<li>"TAB" - Esta tecla alterna entre as colunas e linhas da
					tabela.</li>
				<li>"Ctrl Alt Seta Esquerda" - Move o cursor do sistema para a
					coluna anterior (permanecendo na mesma linha).</li>
				<li>"Ctrl Alt Seta Direita" - Move o cursor do sistema para a
					próxima coluna (permanecendo na mesma linha).</li>
				<li>"Ctrl Alt Seta Acima" - Move o cursor do sistema para a
					linha anterior (permanecendo na mesma coluna).</li>
				<li>"Ctrl Alt Seta Abaixo" - Move o cursor do sistema para a
					linha seguinte (permanecendo na mesma coluna).</li>
			</ul>
		</article>
		
			
	</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Módulo de Navegação do Ed-AbES - Tela Sobre</title>
<jsp:include page="../Imports.jsp" />

</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main">
		<article id="conteudo">
			<h1>Sobre Ed-AbES - Módulo de Navegação</h1>
			<p>Este é o módulo de ajuda do Ed-AbES, onde é apresentado o que
				é a aplicação, seu objetivo, detalhes e informações que possam
				auxiliar o usuário.</p>
			<p>As informações estão organizadas em categorias:</p>
			<div id="menuConteudo">
				<ul>
					<li><a href="#sobre">Sobre Ed-Abes</a></li>
					<li><a href="#construcao">Sobre Módulo de Construção</a></li>
					<li><a href="#navegacao">Sobre Módulo de Navegação</a></li>
					<li><a href="#contato">Contato</a></li>
				</ul>
			</div>
		</article>


		<article id="sobre">
			<h2>Sobre Ed-AbES</h2>
			<p>Ed-AbES significa Editor of Audio-based Environment Simulator.
				Um dos objetivos da aplicação é compor o Trabalho de Conclusão de
				Curso, requisito parcial para obtenção do grau de Bacharel em
				Sistemas de Informação pela PUCRS.</p>
			<p>Outro objetivo é disponibilizar uma aplicação acessível, onde
				é possível criar mapas virtuais de ambientes. Estes ambientes podem
				ser, por exemplo, seu quarto, a cozinha da sua casa, sua sala de
				aula, sua sala no trabalho, entre outros.</p>
			<p>Com o ambiente modelado virtualmente, pessoas com deficiência
				visual podem navegar nestes mapas, conhecendo assim os ambientes
				modelados e, com isto, espera-se que o usuário com deficiência possa
				vir a tornar-se mais independente e seguro na sua locomoção diária
				em diversos ambientes.</p>
			<p>Para que isto seja possível, foram desenvolvidos dois módulos,
				o Módulo de Construção, por Pinto e Pereira (2015) e o Módulo de
				Navegação por Bruna Fialho e Giovanni Carlos.</p>
		</article>

		<a href="#conteudo" title="Link para subir ao topo da página">Topo</a>

		<article id="construcao">
			<h2>Sobre Módulo de Construção</h2>
			<p>O Módulo de Construção permite a criação de mapas virtuais por
				pessoas videntes. Os mapas podem representar ambientes reais ou não,
				como por exemplo, quartos, cozinha, sala de aula, escritórios,
				jardins, entre outros. Caso a modelagem seja de um ambiente real, o
				objetivo é que seja criado e mobiliado exatamente como é local real,
				para que a pessoa com deficiência possa saber e conhecer o ambiente
				como ele realmente é e também, onde e como os objetos estão
				dispostos.</p>
			<p>Este módulo possui o recurso de criar um desafio. Este deve
				ser determinado no momento da criação do mapa. Um exemplo de desafio
				é o jogador ir do ponto X ao ponto Y do mapa. Os pontos X e Y devem
				ser determinados pelo criador do mapa. Caso seja utilizado este
				recurso, o usuário navegador será informado disto que assim que
				iniciar a navegação no mapa.</p>
			<p>A navegação da pessoa com deficiência visual se dará no Módulo
				de Navegação.</p>
		</article>

		<a href="#conteudo" title="Link para subir ao topo da página">Topo</a>

		<article id="navegacao">
			<h2>Sobre Módulo de Navegação</h2>
			<p>O Módulo de Navegação foi desenvolvido com o intuito de
				permitir o usuário com deficiência virtual simular a navegação no
				ambiente previamente construído no Módulo de Construção. Desta
				forma, o usuário poderá percorrer todo o ambiente previamente
				modulado, conhecendo o local onde ficam os objetos, portas, etc.
				Espera-se que esta vivência virtual pode vir a facilitar sua
				locomoção no espaço real.</p>
			<p>A navegação ocorre através do teclado, utilizando as teclas
				previamente definidas no sistema e que podem ser conhecidas através
				da opção de menu "Teclas de Atalho" ou através do atalho "Alt 5".</p>
			<p>A aplicação salva um log de navegação, que fica salva no
				Histórico de Navegações, que tem como objetivo guardar os movimentos
				que usuário fez na navegação, tempo e data de navegação no mapa,
				podendo assim, avaliar seu desempenho em cada mapa que navegou.</p>
			<p>Neste projeto foi utilizado o conceito de Deficiência Visual
				apresentado no Decreto nº 5.296, de 2 de dezembro de 2004.</p>
		</article>

		<a href="#conteudo" title="Link para subir ao topo da página">Topo</a>

		<article id="contato">
			<h2>Contato</h2>
			<p>Os desenvolvedores do Módulo de Navegação são Bruna Fialho e
				Giovanni Batista Carlos, sob orientação da Profa. Dr. Márcia de
				Borba Campos.</p>
			<p>Para contatá-los, envie um e-mail para:</p>
			<ul>
				<li><label for="emailBruna">Bruna Fialho:</label> <a
					id="emailBruna" href="mailto:bruna.fialho@acad.pucrs.br"
					target="_top" title="Link para
					o email da Bruna Fialho">bruna.fialho@acad.pucrs.br</a></li>

				<li><label for="emailGiovanni">Giovanni Batista Carlos:</label>
					<a id="emailGiovanni" href="mailto:giovanni.carlos@acad.pucrs.br"
					target="_top" title="Link
					para o email do Giovanni Carlos">giovanni.carlos@acad.pucrs.br</a></li>

				<li><label for="emailMarcia">Márcia de Borba Campos</label> <a
					id="emailMarcia" href="mailto:marcia.campos@pucrs.br" target="_top"
					title="Link para o
					email da Márcia Campos">marcia.campos@pucrs.br</a></li>
			</ul>

		</article>

		<a href="#conteudo" title="Link para subir ao topo da página">Topo</a>

		<a href="#menu" title="Link para subir ao menu">Voltar ao menu</a>
	</div>
</body>
</html>
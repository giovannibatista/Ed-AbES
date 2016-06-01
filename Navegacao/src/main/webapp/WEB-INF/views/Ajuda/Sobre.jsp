<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>M�dulo de Navega��o do Ed-AbES - Tela Sobre</title>
<jsp:include page="../Imports.jsp" />

</head>
<body>
	<header role="banner">
		<jsp:include page="../Menu.jsp" />
	</header>
	<div role="main">
		<article id="conteudo">
			<h1>Sobre Ed-AbES - M�dulo de Navega��o</h1>
			<p>Este � o m�dulo de ajuda do Ed-AbES, onde � apresentado o que
				� a aplica��o, seu objetivo, detalhes e informa��es que possam
				auxiliar o usu�rio.</p>
			<p>As informa��es est�o organizadas em categorias:</p>
			<div id="menuConteudo">
				<ul>
					<li><a href="#sobre">Sobre Ed-Abes</a></li>
					<li><a href="#construcao">Sobre M�dulo de Constru��o</a></li>
					<li><a href="#navegacao">Sobre M�dulo de Navega��o</a></li>
					<li><a href="#contato">Contato</a></li>
				</ul>
			</div>
		</article>


		<article id="sobre">
			<h2>Sobre Ed-AbES</h2>
			<p>Ed-AbES significa Editor of Audio-based Environment Simulator.
				Um dos objetivos da aplica��o � compor o Trabalho de Conclus�o de
				Curso, requisito parcial para obten��o do grau de Bacharel em
				Sistemas de Informa��o pela PUCRS.</p>
			<p>Outro objetivo � disponibilizar uma aplica��o acess�vel, onde
				� poss�vel criar mapas virtuais de ambientes. Estes ambientes podem
				ser, por exemplo, seu quarto, a cozinha da sua casa, sua sala de
				aula, sua sala no trabalho, entre outros.</p>
			<p>Com o ambiente modelado virtualmente, pessoas com defici�ncia
				visual podem navegar nestes mapas, conhecendo assim os ambientes
				modelados e, com isto, espera-se que o usu�rio com defici�ncia possa
				vir a tornar-se mais independente e seguro na sua locomo��o di�ria
				em diversos ambientes.</p>
			<p>Para que isto seja poss�vel, foram desenvolvidos dois m�dulos,
				o M�dulo de Constru��o, por Pinto e Pereira (2015) e o M�dulo de
				Navega��o por Bruna Fialho e Giovanni Carlos.</p>
		</article>

		<a href="#conteudo" title="Link para subir ao topo da p�gina">Topo</a>

		<article id="construcao">
			<h2>Sobre M�dulo de Constru��o</h2>
			<p>O M�dulo de Constru��o permite a cria��o de mapas virtuais por
				pessoas videntes. Os mapas podem representar ambientes reais ou n�o,
				como por exemplo, quartos, cozinha, sala de aula, escrit�rios,
				jardins, entre outros. Caso a modelagem seja de um ambiente real, o
				objetivo � que seja criado e mobiliado exatamente como � local real,
				para que a pessoa com defici�ncia possa saber e conhecer o ambiente
				como ele realmente � e tamb�m, onde e como os objetos est�o
				dispostos.</p>
			<p>Este m�dulo possui o recurso de criar um desafio. Este deve
				ser determinado no momento da cria��o do mapa. Um exemplo de desafio
				� o jogador ir do ponto X ao ponto Y do mapa. Os pontos X e Y devem
				ser determinados pelo criador do mapa. Caso seja utilizado este
				recurso, o usu�rio navegador ser� informado disto que assim que
				iniciar a navega��o no mapa.</p>
			<p>A navega��o da pessoa com defici�ncia visual se dar� no M�dulo
				de Navega��o.</p>
		</article>

		<a href="#conteudo" title="Link para subir ao topo da p�gina">Topo</a>

		<article id="navegacao">
			<h2>Sobre M�dulo de Navega��o</h2>
			<p>O M�dulo de Navega��o foi desenvolvido com o intuito de
				permitir o usu�rio com defici�ncia virtual simular a navega��o no
				ambiente previamente constru�do no M�dulo de Constru��o. Desta
				forma, o usu�rio poder� percorrer todo o ambiente previamente
				modulado, conhecendo o local onde ficam os objetos, portas, etc.
				Espera-se que esta viv�ncia virtual pode vir a facilitar sua
				locomo��o no espa�o real.</p>
			<p>A navega��o ocorre atrav�s do teclado, utilizando as teclas
				previamente definidas no sistema e que podem ser conhecidas atrav�s
				da op��o de menu "Teclas de Atalho" ou atrav�s do atalho "Alt 5".</p>
			<p>A aplica��o salva um log de navega��o, que fica salva no
				Hist�rico de Navega��es, que tem como objetivo guardar os movimentos
				que usu�rio fez na navega��o, tempo e data de navega��o no mapa,
				podendo assim, avaliar seu desempenho em cada mapa que navegou.</p>
			<p>Neste projeto foi utilizado o conceito de Defici�ncia Visual
				apresentado no Decreto n� 5.296, de 2 de dezembro de 2004.</p>
		</article>

		<a href="#conteudo" title="Link para subir ao topo da p�gina">Topo</a>

		<article id="contato">
			<h2>Contato</h2>
			<p>Os desenvolvedores do M�dulo de Navega��o s�o Bruna Fialho e
				Giovanni Batista Carlos, sob orienta��o da Profa. Dr. M�rcia de
				Borba Campos.</p>
			<p>Para contat�-los, envie um e-mail para:</p>
			<ul>
				<li><label for="emailBruna">Bruna Fialho:</label> <a
					id="emailBruna" href="mailto:bruna.fialho@acad.pucrs.br"
					target="_top" title="Link para
					o email da Bruna Fialho">bruna.fialho@acad.pucrs.br</a></li>

				<li><label for="emailGiovanni">Giovanni Batista Carlos:</label>
					<a id="emailGiovanni" href="mailto:giovanni.carlos@acad.pucrs.br"
					target="_top" title="Link
					para o email do Giovanni Carlos">giovanni.carlos@acad.pucrs.br</a></li>

				<li><label for="emailMarcia">M�rcia de Borba Campos</label> <a
					id="emailMarcia" href="mailto:marcia.campos@pucrs.br" target="_top"
					title="Link para o
					email da M�rcia Campos">marcia.campos@pucrs.br</a></li>
			</ul>

		</article>

		<a href="#conteudo" title="Link para subir ao topo da p�gina">Topo</a>

		<a href="#menu" title="Link para subir ao menu">Voltar ao menu</a>
	</div>
</body>
</html>
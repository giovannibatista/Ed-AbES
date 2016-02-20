<%@ page import="edabes.entidades.*"%>
<%
	Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
%>

<script type="text/javascript">
	function logout() {
		if (confirm("Deseja realmente sair?")) {
			document.location = "/User/Logout";
		}
		else {
			return (false);
		}
	}

</script>

<nav>
	<ul class="nav nav-pills">
		<li role="presentation"><a href="/Mapa/Criar" title="Novo Mapa">Novo Mapa</a></li>
		<li role="presentation"><a href="/Mapa/Listar" title="Listar Mapas">Listar Mapas</a></li>
		<li role="presentation"><a href="/Mapa/Importar" title="Importar Mapas">Importar Mapas</a></li>
		<li role="presentation"><a href="/Audio/Importar" title="Importar Áudios">Importar Áudios</a></li>
		
		<li role="presentation" class="pull-right dropdown clearfix">
			<a href="javascript: void(0);" data-toggle="dropdown" class="dropdown-toggle"><%=usuario.getNome()%></a>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenuDivider">
                <li role="presentation">
                	<a role="menuitem" title="Editar Perfil2" href="/Editar/Perfil">Editar perfil</a>
               	</li>
                <li role="presentation" class="divider"></li>
                <li role="presentation">
                	<a role="menuitem" href="javascript:logout();" title="Sair">Sair</a>
               	</li>
            </ul>
		</li>
	</ul>
</nav>
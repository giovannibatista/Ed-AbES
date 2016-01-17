<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ed-AbES - Cadastro</title>

<script type="text/javascript" src="resources/js/funcoes.js"></script>	

<script language="javascript">
	
	function validaForm () {
		//var nome = document.forms["form"]["nome"].value;
		//alert("Nome: " + nome);
		return true;
	}
	
	function validaSenha (input){ 
	    if (input.value != document.getElementById('senha').value) {
	    input.setCustomValidity('Repita a senha corretamente');
	  } else {
	    input.setCustomValidity('');
	  }
	} 

</script>

</head>
<body>
<form id="form" name="form" method="POST" action="Cadastrar" onsubmit="return validaForm()">
	<center>
		<table>
			<tr>
				<td>
				<label>Nome:</label>
				</td>
				<td>
				<input type="text" id="nome" name="nome" maxlength="10" required/>
				</td>
			</tr>
			<tr>
				<td>
				<label>Sobrenome:</label>	
				</td>
				<td>
					<input type="text" id="sobrenome" name="sobrenome" maxlength="15" required/>
				</td>
			</tr>
			<tr>
				<td>
				<label>Email:</label>	
				</td>
				<td>
					<input type="email" id="email" name="email" maxlength="20" required/>
				</td>
			</tr>
			<tr>
				<td>
				<label>Tipo de perfil:</label>	
				</td>
				<td>
					<input type="radio" name="tipo_perfil" value="1" checked="checked" >Construtor</input>
					<br>
					<input type="radio" name="tipo_perfil" value="2">Navegador</input>
					<br>
					<input type="radio" name="tipo_perfil" value="3">Construtor e Navegador</input>
				</td>
			</tr>
			<tr>
				<td>
				<label>Idade:</label>	
				</td>
				<td>
					<input type="text" id="idade" name="idade" maxlength="2" required pattern="[0-9]+$" title="Digite apenas números"/>
				</td>
			</tr>
			<tr>
				<td>
				<label>Genero:</label>	
				</td>
				<td>
					<input type="radio" name="genero" value="masculino" checked="checked" >Masculino</input>
					<br>
					<input type="radio" name="genero" value="feminino">Feminino</input>
					<br>
					<input type="radio" name="genero" value="outro">Outro</input>
				</td>
			</tr>
			<tr>
				<td>
				<label>Senha:</label>	
				</td>
				<td>
					<input type="password" id="senha" name="senha" pattern=".{8,16}" title="A senha precisa conter no minimo 8 caracteres e no maximo 16" required/>
				</td>
			</tr>
			<tr>
				<td>
				<label>Confirmar senha:</label>	
				</td>
				<td>
					<input type="password" id="conf_senha" name="conf_senha" pattern=".{8,16}" title="É preciso repetir a senha digitada acima" required oninput="validaSenha(this)" />
				</td>
			</tr>
			<tr>
				<td>
					<div>
						<input type="Submit" value="Cadastrar" >
					</div>
				</td>
				<td>
					<div>
						<input type="button" value="Voltar" onclick="javascript:go('home')">
					</div>
				</td>
			</tr>
		</table>
		<div>
			<c:if test="${verificacao == true}">
				<h1>Usuario cadastrado com sucesso</h1>
			</c:if>
			<c:otherwise>
				<h1>Usuario não cadastrado. Contate o administrador do sistema</h1>
			</c:otherwise>
		</div>
	</center>
</form>
</body>
</html>
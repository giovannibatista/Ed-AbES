<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ed-AbES</title>
</head>
<body>
<form id="form" method="POST" action="SelecaoDePerfil">	
	<center>
		<h2>Ed-AbES</h2>
		<hr>
		<h3>Seja bem-vindo, <c:out value="${nome}" /></h3>
		
		
		<div style="padding-top: 5px;">
			<input type="submit" value="Continuar" >
		</div>
	</center>
</form>
</body>
</html>
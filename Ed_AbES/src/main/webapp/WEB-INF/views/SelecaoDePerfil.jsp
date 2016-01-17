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
	
	
	<center>
		<h2>Ed-AbES</h2>
		<hr>
		<h3>Selecione o seu perfil</h3>
		<div style="padding-top: 5px;">
			<c:choose> 
  				<c:when test="${perfil == 1}">
    				<input type="button"  onclick="location.href='PaginaConstrutor'" value="Construtor" >
  				</c:when>
  				<c:when test="${perfil == 2}">
    				<input type="button"  onclick="location.href='PaginaNavegador'" value="Navegador" >
  				</c:when>
  				<c:otherwise>
    			<input type="button"  onclick="location.href='PaginaConstrutor'" value="Construtor" >
    			<input type="button"  onclick="location.href='PaginaNavegador'" value="Navegador" >
  				</c:otherwise>
			</c:choose>
		</div>
	</center>

</body>
</html>
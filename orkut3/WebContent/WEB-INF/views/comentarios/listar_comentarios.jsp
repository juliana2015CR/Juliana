<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Comentarios</title>
</head>
<body>

	<div id="header">
		<h1>Listar Comentários</h1>
	</div>

	<table border="1">

		<tr>
			<td><h4>Comentário</h4></td>
			<td><h4>Autor</h4></td>
		</tr>

		<c:forEach var="com" items="${comentarios}">
			<tr>
				<td>${com.texto}</td>
				<td><a href="verPerfil?id=${com.usuId}">${com.login}</a></td>

			</tr>

		</c:forEach>
	</table>
 				<td><a href="Menu"> Voltar ao Menu</a><br /><br /> </td> 

	<div id="footer">
		Trabalho de Desenvolvimento Web - UFC <br />Aluna: Juliana de Castro
		Rabelo.
	</div>
</body>
</html>
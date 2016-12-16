<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Amizades</title>
</head>
<body>
	<div id="header">
		<h1>${usuario.nome}Insira Amigos</h1>
	</div>

	<form action="inserirAmizade" method="post">
		<table border="1">
			<c:forEach var="u" items="${potenciais_amigos}">
				<tr>
					<td>${u.usuId}</td>
					<td>${u.nome}</td>
					<td><img width="100" heigth="100"
						src="<c:url value="/resourses/images/${u.login}.png" />" /></td>
					<td><form:checkbox path="amizade.amigos" value="${u.usuId}" />
					</td>

				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="OK">
	</form>
	<div id="footer">
		Trabalho de Desenvolvimento Web - UFC <br />Aluna: Juliana de Castro
		Rabelo.
	</div>
</body>
</html>
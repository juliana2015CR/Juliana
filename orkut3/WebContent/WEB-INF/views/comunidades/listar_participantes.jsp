<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Comunidades</title>
</head>
<body>

	<div id="header">
		<h1>Listar Participantes</h1>
	</div>
	<form action="listarParticipantes" method="post">
		<table border="1">

			<tr>
				<td><h4>Usuario</h4></td>
				<td><h4>Foto</h4></td>
			</tr>

			<c:forEach var="usu" items="${usu}">
				<tr>
					<td>${usu.usuId}</td>
					<td>${usu.nome}</td>
					<td><img width="100" height="70"
						src="<c:url value="/resources/images/${usu.login}.png" />" /></td>


				</tr>
			</c:forEach>

		</table>
	</form>
	<td><a href="Menu"> Voltar ao Menu</a><br />
	<br /></td>

	<div id="footer">
		Trabalho de Desenvolvimento Web - UFC <br />Aluna: Juliana de Castro
		Rabelo.
	</div>

</body>
</html>
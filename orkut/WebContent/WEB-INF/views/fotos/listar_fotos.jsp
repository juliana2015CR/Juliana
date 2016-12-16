<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Fotos</title>
</head>
<body>

	<div id="header">
		<h1>Listar Fotos</h1>
	</div>

	<table border="1">
		<tr>
			<td><h4>Foto ID</h4></td>
			<td><h4>Fotos</h4></td>
			<td><h4>Comentários</h4></td>
			<td><h4>Enviar Comentários</h4></td>
		</tr>
		<c:forEach var="foto" items="${fotos}">
			<tr>

				<td>${foto.fotid}</td>
				<td><img width="100" height="70" src="<c:url value="/resources/fot/${foto.legenda}.png" />" /></td>
				<td><a href="listarComentarios?id=${foto.fotid}">Listar
						Comentários </a></td>
				<td><a href="inserirComentarioFormulario?id=${foto.fotid}">Envie
						um comentário</a></td>

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
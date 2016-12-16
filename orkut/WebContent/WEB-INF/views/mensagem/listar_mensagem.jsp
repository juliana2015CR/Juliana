<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Mensagens</title>
</head>
<body>

	<div id="header">
		<h1>Listar Mensagens</h1>
	</div>

	<table border="1">

		<tr>
			<td><h4>Mensagem</h4></td>
			<td><h4>Apagar Mensagem</h4></td>
			<td><h4>Autor</h4></td>

		</tr>

		<c:forEach var="mensagem" items="${mensagem}">
			<tr>
				<td>${mensagem.texto}</td>

				<td><a href="apagarMensagem?menId=${mensagem.menId}">Apagar
						Mensagem</a></td>
				<td><a href="verPerfil?id=${mensagem.usuId}">${mensagem.login}</a></td>

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
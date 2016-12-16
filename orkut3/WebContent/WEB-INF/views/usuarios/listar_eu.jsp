<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Perfil</title>
</head>
<body>

	<div id="header">
		<h1>Perfil</h1>
	</div>

	<table border="1">
	<tr>
			<td><h4>Usuário ID</h4></td>
			<td><h4>Nome</h4></td>
			<td><h4>Foto de Perfil</h4></td>
			<td><h4>Alterar Perfil</h4></td>
			
		</tr>
		<c:forEach var="usuarios" items="${usuarios}">
			<tr>
				<td>${usuarios.usuId}</td>
				<td>${usuarios.nome}</td>
				<td><img width="100" height="70"
					src="<c:url value="/resources/images/${usuarios.login}.png" />" />
				</td>
				<%-- 				<td><a href="apagarUsuario?usuId=${usuarios.usuId}">APAGAR</a></td>
 --%>
				<td><a href="alterarUsuarioFormulario?usuId=${usuarios.usuId}">ALTERAR</a></td>

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
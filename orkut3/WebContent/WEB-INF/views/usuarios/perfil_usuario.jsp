<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<h1>Listar Comentarios</h1>
	</div>
		<h2>${perfil.nome}</h2>
		
	<table border="1">		
		 <tr>		 		
			<td><h4>Foto de Perfil</h4></td>
			<td><h4>Nome</h4></td>
			<td><h4>E-mail</h4></td>
			<td><h4>Albuns</h4></td>
			
		</tr>
				<td><img width="100" height="100" src='<c:url  value="/resources/images/${perfil.login}.png" />' /></td>
				<td> ${perfil.nome }</td>
		 		<td> ${perfil.email }</td>
				<td><a href="listarAlbunsPerfil?id=${perfil.usuId}"> Albuns</a><br /><br /> </td> 
		 		
				
	</table>
				<td><a href="Menu"> Voltar ao Menu</a><br /><br /> </td> 
	
<div id="footer">	
        Trabalho de Desenvolvimento Web - UFC <br />Aluna: Juliana de Castro Rabelo.
</div>
    
</body>
</html>
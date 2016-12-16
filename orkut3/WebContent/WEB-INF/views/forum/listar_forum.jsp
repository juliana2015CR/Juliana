<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Fórum</title>
</head>
<body>

<div id="header">
	<h1>Listar Fórum</h1>
	</div>
	
	<table border="1">
	<tr>
			<td><h4>Fórum ID</h4></td>
			<td><h4>Título do Fórum</h4></td>
			<td><h4>Descrição</h4></td>
			<td><h4>Autor</h4></td>
			<td><h4>Apagar Fórum</h4></td>
			<td><h4>Mensagens</h4></td>
			<td><h4>Inserir Mensagens</h4></td>
			
		</tr>
		<c:forEach var="forum" items="${forum}">
			<tr>		
				<td>${forum.forId}</td>
				<td>${forum.titulo}</td>
				<td>${forum.descricao}</td>
				<td><a href="verPerfil?id=${forum.usuId}">${forum.login}</a></td>
				<td><a href="apagarForum?forId=${forum.forId}">Apagar Fórum</a></td>
 				<td><a href="listarMensagem?id=${forum.forId}">Listar Mensagens </a></td>				
 				<td><a href="inserirMensagemFormulario?id=${forum.forId}">Envie uma mensagem ao fórum >> </a></td>				
 												
			</tr>
		
		
		</c:forEach>
	
	</table>
				<td><a href="Menu"> Voltar ao Menu</a><br /><br /> </td> 
	
<div id="footer">	
        Trabalho de Desenvolvimento Web - UFC <br />Aluna: Juliana de Castro Rabelo.
</div>
    
</body>
</html>
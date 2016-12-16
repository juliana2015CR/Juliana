<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Comentarios</title>
</head>
<body>

	<div id="header">
		<h1>Enviar comentarios </h1>
	</div>

	<form action="inserirComentario" method="post" enctype="multipart/form-data">
		<fieldset id="inserirComentario"><legend>Comentário</legend>

Texto: <textarea name="texto" ></textarea> <br /> 
			
		 
			<input type="submit" value="OK">

			
	</form>


	<div id="footer">
		Trabalho de Desenvolvimento Web - UFC <br />Aluna: Juliana de Castro Rabelo.
	</div>

</body>
</html>
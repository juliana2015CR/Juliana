<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário de Cadastro de Fotos</title>

</head>
<body>
	<div id="header">
		<h1>Insira Fotos ${usuario_logado.nome}</h1>
	</div>

	<form action="inserirFotos" method="post" enctype="multipart/form-data">

		Legenda: <input type="text" name="legenda" /><br /><br /> 
		
		Insira uma Foto: <input type="file" name="fot" /><br /><br /> 
		
		<select name="alid">

			<c:forEach var="al" items="${album}">

				<option value="${al.alid}" > ${al.nome}</option>

			</c:forEach>

		</select> <input type="submit" value="OK">
	</form>

</body>
</html>
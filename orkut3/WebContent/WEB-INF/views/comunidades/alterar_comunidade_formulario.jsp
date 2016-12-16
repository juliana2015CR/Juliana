<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Comunidade</title>
</head>
<body>

	<h2>Alterar Comunidade</h2>
	
	<form action="alterarComunidade" method="post" enctype="multipart/form-data"> 
		<input type="hidden" name="comid" value="${comunidade.comid}">
		<input type="hidden" name="orkId" value="${comunidade.orkId}">
		<input type="hidden" name="catId" value="${comunidade.catId}">
		
		Nome da Comunidade: <input type="text" name="nome" value="${comunidade.nome}"><br />
		Insira uma Imagem: <input type="file" name="image"/><br />   
		
		
		<input type="submit" value="OK">	
	
	</form>
	
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário de Cadastro de Albuns</title>

</head>
<body>
<div id="header">
	<h1>Insira Albuns ${usuario_logado.nome}</h1>
</div>

<form action="inserirAlbuns" method="post" enctype="multipart/form-data">

Título:      <input type="text" name="nome" /><br /><br />

Insira uma Foto para a Capa: <input type="file" name="fot" /><br /><br /> 

<input type="submit" value="OK">
</form>

</body>
</html>
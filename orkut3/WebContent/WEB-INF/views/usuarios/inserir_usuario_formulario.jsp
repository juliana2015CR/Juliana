<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="./resources/css/style2.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>

<body>
	<div class="login">
		<h2>Bem-Vindo(a)</h2>

		<form action="inserirUsuario" method="post"
			enctype="multipart/form-data">
			Nome: <input type="text" name="nome"><br /> 
			Sobrenome: <input type="text" name="sobrenome"><br /> 
			Idade: <input type="text" name="idade"><br /> 
			E-mail: <input type="text" name="email"><br /> 
			Login: <input type="text" name="login"><br />
			Senha: <input type="password" name="senha"><br /> 
			Confirmar Senha: <input type="password" name="confsenha"><br />
			Insira uma Imagem de Perfil: <input type="file" name="image"><br />
			<input class="btn btn-success" type="submit" value="OK"><br />
		</form>


	</div>


</body>
</html>

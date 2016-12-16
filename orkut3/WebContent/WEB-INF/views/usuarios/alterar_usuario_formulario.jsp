<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Usuário</title>
</head>
<body>

	<h2>Alterar Usuário</h2>
	
	<form action="alterarUsuario" method="post" enctype="multipart/form-data">
		<input type="hidden" name="usuId" value="${usuario.usuId}">
		<input type="hidden" name="orkId" value="${usuario.orkId}">
		Nome: <input type="text" name="nome" value="${usuario.nome}"><br />
		Sobrenome: <input type="text" name="sobrenome" value="${usuario.sobrenome}"><br />
		Idade: <input type="text" name="idade" value="${usuario.idade}"><br />
		E-mail: <input type="text" name="email" value="${usuario.email}"><br />
		Login: <input type="text" name="login" value="${usuario.login}"><br />
		Senha: <input type="password" name="senha" ><br />
		Confirmar Senha: <input type="password" name="confsenha" ><br />
		Insira uma Nova Imagem: <input type="file" name="image"/><br />   
		
		
		<input type="submit" value="OK">	
	
	</form>
	
</body>
</html>
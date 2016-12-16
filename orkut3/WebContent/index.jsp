<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>


</head>
<body>
	<div id="header">
		<h1>OrkutQuixadá</h1>
	
	</div>
	<div id="menu">

		<h2>Realize seu Login</h2>
		<ul>
			<li><a href="loginFormulario">Login</a><br /> </a></li>
		</ul>
		<h2>Cadastre-se</h2>
		<ul>
			<li><a href="inserirUsuarioFormulario">Cadastro de Usuário</a><br />
				</a></li>
		</ul>
		<!-- 	<h2>Recupere sua Conta</h2>
		<ul>
			<li><a href="loginFormulario">Login</a><br />
			</a></li>
		</ul> -->
	</div>

	<div id="menu2">
		<nav>
			<ul type="circle">
				<img width="680" heigth="380"
					src="<c:url value="/resources/imagens/ork.jpeg" />" />
				</td>

			</ul>
		</nav>
	</div>



	<div id="footer">
		Trabalho de Desenvolvimento Web - UFC <br />Aluna: Juliana de Castro
		Rabelo.
	</div>
</body>
</html>







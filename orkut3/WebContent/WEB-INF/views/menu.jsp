<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>

</head>
<body>
	<div id="header">
		<h1>
			Bem-Vindo(a) ${usuario_logado.nome}
			<td><img width="100" height="70"
				src="<c:url value="/resources/images/${usuario.login}.png" />" /></td>
		</h1>

	</div>
	<div id="menu3">
		<nav>
			<ul type="circle">

				<li><a href="listarEu">Perfil </a><br /> <br /></li>

				<li><a href="listarUsuario">Usuarios </a><br /> <br /></li>

				<li><a href="listarAmigos">Meus Amigos </a><br /> <br /></li>

				<li><a href="listarMinhasComunidades">Minhas Comunidades</a><br />
					<br /></li>


				<li><a href="listarComunidade">Listar Comunidades</a><br /> <br /></li>


				<li><a href="listarAlbuns"> Meus Albuns</a><br /> <br /></li>

			<!-- 	<li><a href="listarAlbunsPessoas"> Albuns de Outros</a><br />
					<br /></li> -->



				<li><a href="logout">Sair</a><br /></li>
		
			</ul>
		</nav>
		
	</div>


	<div id="menu2">
		<nav>
			<ul type="circle">
				<img width="650" heigth="380"
					src="<c:url value="/resources/imagens/ork.jpeg" />" />
				</td>

			</ul>
		</nav>
	</div>

	<div id="menu4">
		<nav>
			<ul type="circle">
				<li><a href="inserirAmizadeFormulario">Adicionar Amigos</a><br />
					<br /></li>

				<li><a href="inserirComunidadeFormulario">Criar Comunidade</a><br />
					<br /></li>

				<li><a href="adicionarComunidadeFormulario">Adicionar
						Comunidade Existente</a><br /> <br /></li>

				<li><a href="inserirForumFormulario?comid=${comunidade.comid}">Criar
						Fórum</a><br /> <br /></li>


				<li><a href="inserirAlbunsFormulario">Inserir Albuns</a><br />
					<br /></li>

				<li><a href="inserirFotosFormulario">Inserir Fotos</a><br /> <br /></li>


			</ul>
		</nav>
	</div>


	<div id="footer">
		Trabalho de Desenvolvimento Web - UFC <br />Aluna: Juliana de Castro
		Rabelo.
	</div>

</body>
</html>
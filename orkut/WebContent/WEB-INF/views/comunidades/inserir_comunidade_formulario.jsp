<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Formulário de Criação de Comunidade</title>
</head>
<body>

<div id="header">
	<h1>Criação de Comunidade</h1>
</div>
	
<form action="inserirComunidade" method="post" enctype="multipart/form-data" > 

Nome da Comunidade: <input type="text" name="nome" /> <br />
Insira uma Imagem: <input type="file" name="image" /><br /> 

<select name="catId"> 
<c:forEach var="c" items="${categoria}">
			

<option  value="${c.catid}" > ${c.nome} </option>
 <!-- name ... id -->
 </c:forEach>
 
 </select>


<input type="submit" value="OK">

</div>
</form>


<div id="footer">	
        Trabalho de Desenvolvimento Web - UFC <br />Aluna: Juliana de Castro Rabelo.
</div>
    
</body>
</html>
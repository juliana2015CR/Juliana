<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Adicionar Comunidade</title>
</head>
<body>

<div id="header">
	<h1>Adicionar Comunidade</h1>
</div>
	
<form action="adicionarComunidade" method="post" enctype="multipart/form-data" > 
 		
<select name="comid"> 
<c:forEach var="c" items="${comunidade}">	

<option  value="${c.comid}" > ${c.nome} </option>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
      <link rel="stylesheet" href="./resources/css/style2.css">

   

  <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>

<body>
  <div class="login">
	<h1>Login</h1>
   <form action="login" method="post">
		Login: <input type="text" name="login" ><br /><br />
		Senha: <input type="password" name="senha" ><br /><br />
		
		<input class="btn btn-success" type="submit" value="OK">

	</form>
    
   
</div>
  

</body>
</html>
 
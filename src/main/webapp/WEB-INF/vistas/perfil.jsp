<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value="/login"/>">VET Center <span class="glyphicon glyphicon-heart"style="color:orange"></span> </a>
    </div>
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Perfil</a></li>
      <li><a href="<c:url value="/turno"/>">Turnos</a></li>
      <li><a href="#">Peluquerias</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>
    </ul>
		</div>
	</nav>
	<div class="container">
	<h1>Perfil del usuario</h1>
<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	
		<h4>Datos del usuario</h4>

		<div class="form-group">
		Mi mascota 1 <a class="btn btn-warning" href="#">Ver perfil <i class="fa fa-edit"></i></a>
					<a class="btn btn-info" href="#">Editar <i class="fa fa-edit"></i></a>
		             <a class="btn btn-danger" href="#">Eliminar <i class="fa fa-minus"></i></a>
	<br>
		Mi mascota 2 <a class="btn btn-warning" href="#">Ver perfil <i class="fa fa-edit"></i></a>
						<a class="btn btn-info" href="#">Editar <i class="fa fa-edit"></i></a>
		             <a class="btn btn-danger" href="#">Eliminar <i class="fa fa-minus"></i></a>
		             <br>  <br>
 <a href="<c:url value="/formMascota"/>" class="btn btn-lg btn-primary btn-block btn-warning" role="button">Agregar una mascota</a>	
		</div>

		
</div>		
	</div>
	<!-- Placed at the end of the do"src/main/webapp/WEB-INF/vistas/login.jsp"cument so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
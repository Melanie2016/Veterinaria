<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/cssPrueba.css" rel="stylesheet">
		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- Bootstrap theme -->
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body class="body">
		<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">VET Center <span
							class="glyphicon glyphicon-heart" style="color: orange"></span>
						</a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Perfil</a></li>
						<li><a href="#">Turnos</a></li>
						<li><a href="#">Peluquerias</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-user"
								style="color: orange"></span> Registrarse</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-log-in"
								style="color: orange"></span> Login</a></li>
					</ul>
				</div>
		</nav>
		<div class = "container">
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

				<form:form >
					<h3>Ingrese sus datos </h3>
					
					<label for="nombre">Nombre:</label>
					<input type="text" class="form-control" />
					<br>
					<label for="tipo">Tipo de Mascota:</label>
					<select class="form-control" id="sel1">
						<option>Seleccione</option>
				        <option>Perro</option>
				        <option>Gato</option>
				        <option>Tortuga</option>
				        <option>Pajaro</option>
				        <option>Hamsters</option>
			      	</select>
			      	<br>
			      	<label for="duenio">Duenio:</label>
			      	<br>
			      	<input type="text" class="form-control" />
			      	
				</form:form>
			</div>
		</div>
	
		<!-- Placed at the end of the document so the pages load faster -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
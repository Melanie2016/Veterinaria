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
						 <a class="navbar-brand" href="<c:url value="/login"/>">VET Center <span class="glyphicon glyphicon-heart"style="color:orange"></span> </a>
					</div>
					<ul class="nav navbar-nav">
				<li><a href="<c:url value="/perfil"/>">Perfil</a></li>
				<li><a href="<c:url value="/turno"/>">Tusdasdrnos</a></li>
				<li><a href="<c:url value="/peluqueria"/>">Pelusadaquerias</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						
 <li><a href="<c:url value="/cerrarSession"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> LogOut</a></li>

					</ul>
				</div>
		</nav>
		<div class = "container">
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

				<form:form action="validarVet" method="POST" modelAttribute="vet">
	<h3>Ingrese los datos del veterinario</h3>
						
	<form:input path="nombre" id="nombre"  class="form-control" placeholder="Nombre" /><br>
	<form:input path="apellido" id="apellido" class="form-control" placeholder="Apellido" /><br>
	
	<button class="btn btn-lg btn-block btn-warning" Type="Submit" /> Ingresar</button>
	 	  	
				</form:form>
				<a href="<c:url value="/veterinarios"/>" class="btn btn-lg btn-block btn-warning" role="button">Volver</a>	
			</div>
		</div>
	
		<!-- Placed at the end of the document so the pages load faster -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
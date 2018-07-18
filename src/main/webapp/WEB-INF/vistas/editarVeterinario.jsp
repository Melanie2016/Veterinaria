<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <!-- Esto me soluciono la falta de bootstrap -->
		<link rel="stylesheet"
			href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
	</head>
	<body>
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="<c:url value="/home"/>">VET Center <span class="glyphicon glyphicon-heart"style="color:orange"></span> </a>
		    </div>
		    
		    <ul class="nav navbar-nav">
		      <li><a href="<c:url value="/perfil"/>">Perfil</a></li>
		      <li><a href="#">Proximos Turnos</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      
		      <li><a href="<c:url value="/cerrarSession"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> LogOut</a></li>
		    </ul>
				</div>
			</nav>
		<div class="container">
		<h3>Editar Veterinario</h3>
		
   
 <form:form action="validarEdicionVet" method="POST" modelAttribute="veterinario">
    <label>Nombre:</label>
    <form:input path="nombre" id="nombre" type="text" value=" ${veterinario.nombre}" class="form-control" placeholder="Nombre" /><br>
	<label>Apellido:</label>
	<form:input path="apellido" id="apellido"  type="text" value=" ${veterinario.apellido}" class="form-control" placeholder="Apellido" /><br>
	

	<button class="btn btn-lg btn-block btn-warning" Type="Submit" > Guardar</button>
</form:form>

		
	</div>
		<!-- Placed at the end of the do"src/main/webapp/WEB-INF/vistas/login.jsp"cument so the pages load faster -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
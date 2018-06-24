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
		      <a class="navbar-brand" href="<c:url value="/home"/>">VET Center <span class="glyphicon glyphicon-heart"style="color:orange"></span> </a>
		    </div>
		    
		    <ul class="nav navbar-nav">
		      <li><a href="<c:url value="/perfil"/>">Perfil</a></li>
		      <li class="active"><a href="#">Turnos</a></li>
		      <li><a href="#">Peluquerias</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
		      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>
		    </ul>
				</div>
			</nav>
		<div class="container">
			<form:form action="consultarVet" method="POST" modelAttribute="especialidades">
					
					<h1>Reserve su turno</h1>
					<!-- VER ..  https://www.youtube.com/watch?v=rFCaI1daCLs  https://www.youtube.com/watch?v=KnZ5zYYIxu8-->
					<div class="form-group">
						<label for="sel1">Seleccione especialidad:</label> 
						<select	name="descripcion"class="form-control" id="sel1">
							<option>Seleccione especialidad</option>
							<c:forEach items="${especialidades}" var="especialidades">
								<option>${especialidades.descripcion} </option>
							</c:forEach>
						</select>
						
						
					</div>
					<!-- 
					<div class="form-group">
					
						<label for="sel1">Seleccione nombre del veterinario:</label> 
						<select	class="form-control" id="sel1">
							<option>Seleccione un veterinario</option>
							<c:forEach items="${veterinarios}" var="veterinarios">
								<option>${veterinarios.apellido} ${veterinarios.nombre} |</option>
							</c:forEach>
						</select>
						
					</div>
					-->
					<button class="btn btn-lg btn-primary btn-block btn-warning"
						Type="Submit" >
					Buscar Turnos
					</button>
				
					
				
				
				</form:form>
			
			
		</div>
		<!-- Placed at the end of the do"src/main/webapp/WEB-INF/vistas/login.jsp"cument so the pages load faster -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
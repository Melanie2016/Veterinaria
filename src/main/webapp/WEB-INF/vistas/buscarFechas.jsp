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

		<!-- Optional theme -->
		<link rel="stylesheet"
			href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">
    </head>
			<style>
				
			</style>
    <body>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="<c:url value="/home"/>">VET Center <span class="glyphicon glyphicon-heart"style="color:orange"></span> </a>
		    </div>
		    
		    <ul class="nav navbar-nav">
		      <li><a href="<c:url value="/perfil"/>">Perfil</a></li>
		      <li class="active"><a href="<c:url value="/turno"/>">Turnos</a></li>
		      <li><a href="#">Peluquerias</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
		      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>
		    </ul>
				</div>
		</nav>
		<div class="container">
		
			<form:form action="registrarTurno" method="POST" modelAttribute="especialidades">
				<h1>Disponibilidad</h1>			
				<div class="form-group"> 
				<br>
				<label for="fecha">Seleccione fecha:</label>
				
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col" class="glyphicon glyphicon-pencil"></th>
							<th colspan="2">Especialista</th>
							<th scope="col">Dias de atencion</th>
							<th scope="col">Hora</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${consulta}" var="consulta">
							<tr>
								<th scope="row"></th>
 									<td>${consulta.veterinario.apellido}</td> 
									<td>${consulta.veterinario.nombre }</td>
									<td>${consulta.dia}</td>
									<td>${consulta.horaAtencionInicio }</td>
							</tr>
						</c:forEach>				
					</tbody>
				</table>
									
				
					<button class="btn btn-lg btn-warning"
						Type="Submit" >
					Buscar Turnos
				</button>
				</div>
				
				
			 	<a href="<c:url value="/turno"/>" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-hand-left"></span></a>	 
				
			</form:form>
		</div>	
    </body>
</html>
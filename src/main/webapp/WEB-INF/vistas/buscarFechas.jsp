<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		
	    
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
		      <li class="active"><a href="<c:url value="/turno"/>">Turnos</a></li>
		      <li><a href="<c:url value="/peluqueria"/>">Peluquerias</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
		      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>
		    </ul>
				</div>
		</nav>
		<div class="container">
		
			
				<h1>Disponibilidad</h1>			
				<div class="form-group"> 
				<br>
				<label for="fecha">Seleccione fecha:</label>
				<p>${duracion}</p>
				
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col" class="glyphicon glyphicon-pencil"></th>
							<th scope="col">Fecha</th>
							
							<th scope="col">Hora</th>
							<th scope="col">Mascota</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${turnos}" var="turnos">
							<tr>
							
								<th scope="row"></th>
<%-- 										<td>${disp.horaTurno}</td> --%>
<%-- 										<td>${disp.veterinario.nombre}</td> --%>
<%--  									<td>${turnos.id}</td>  --%>
										
										<td>${turnos.fechaTurno}</td> 
										<td>${turnos.horaTurno}</td> 
										<td>${turnos.mascota.nombre}</td> 
										<td><a href="<c:url value="/turno"/>" class="btn btn-warning" 
									role="button">Seleccionar</a></td>
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
				
			
		</div>	
    </body>
</html>
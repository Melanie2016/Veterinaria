<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
		
			<h1>Horarios disponibles</h1>
		
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
			
				
				
				<div class="form-group"> 
				<br>
				<label for="fecha">Seleccione HORA:</label>
				
				
				
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col" class="glyphicon glyphicon-pencil"></th>
							<th scope="col">Hora </th>
						
							
							<th scope="col"> </th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach items="${horarios}" var="horarios">
							<tr>
								<th scope="row"></th> 
								
								<td><fmt:formatDate type = "time" pattern="hh:mm"  value = "${horarios}" /></td> 
 								<th scope="col"> </th>
 								<td><a href="../reservarTurno/" class="btn btn-warning" role="button" >Reservar Turno</a></td> 
								<td>${fecha}</td>
						</c:forEach>
									
					</tbody>
				</table>
						
						
				
				</div>
				
				
			 	<a href="<c:url value="/turno"/>" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-hand-left"></span></a>	 
				
			</div>
		</div>	
    </body>
</html>
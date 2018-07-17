<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
	
	    
	     <!-- Esto me soluciono la falta de bootstrap -->
		<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">

		<!-- Optional theme -->
		<link rel="stylesheet"
			href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">
	</head>
	<body>
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="<c:url value="/home"/>">VET Center <span class="glyphicon glyphicon-heart"style="color:orange"></span> </a>
		    </div>
		    
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="<c:url value="/perfil"/>">Perfil</a></li>
		      <li><a href="<c:url value="/turno"/>">Turnos</a></li>
		      <li><a href="#">Peluquerias</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
		      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>
		    </ul>
				</div>
			</nav>
			
		<div class = "container">
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		
			  						 	
		 		<h3>Vacuna: ${vacunaNombre} </h3> 
		  		<h4>Fecha de Revacunacion: <span  style="color:orange" ><fmt:formatDate type = "date"  value = "${rev}" /></span> 
		  		<span class="glyphicon glyphicon-heart" style="color:orange">
		  		</span></h4>
		  		<p></p>
		  		
				<a href="../perfil" class="btn btn-warning" role="button"><span class="glyphicon glyphicon-hand-left"></span></a>			
					
			</div>
		</div>		
				<!-- Placed at the end of the document so the pages load faster -->
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
				<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
				<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
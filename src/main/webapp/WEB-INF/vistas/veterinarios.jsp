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
              <li class="active"><a href="<c:url value="/perfilAdmin"/>">Perfil</a></li>
		      <li><a href="<c:url value="/stockVacunas"/>">StockVacunas</a></li>
		        <li><a href="#">Veterinarios</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="<c:url value="/cerrarSession"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> LogOut</a></li>
		    </ul>
				</div>
			</nav>
		<div class="container">
			<h1>Listado de Veterinarios</h1>
				
		 <table class="table table-striped">
		            <thead>
			            <tr>
				            <th>Id</th>
				            <th>Nombre</th>	
				            <th>Apellido</th>			       
				           
				            <th></th>
			            </tr>
		            </thead>
		
		             <c:forEach var="vet" items="${vet}">
		            <tr>
			            <td>${vet.veterinarioId}</td>
			            <td>${vet.nombre}</td>
			            <td>${vet.apellido}</td>
			          
 					   <td> <a class="btn btn-warning" href="editarVeterinario/${vet.veterinarioId}">Editar <i class="fa fa-minus"></i></a> </td>
                       <td> <a class="btn btn-danger" href="eliminarVet/${vet.veterinarioId}">X<i class="fa fa-minus"></i> </a></td>
		    	
			        </tr>
			        </c:forEach>
		        </table>
				 <a href="<c:url value="/formVet"/>" class="btn btn-lg btn-primary btn-block btn-warning" role="button">Agregar Veterinario</a>	
		
			
		</div>
		<!-- Placed at the end of the do"src/main/webapp/WEB-INF/vistas/login.jsp"cument so the pages load faster -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
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
				<h1><span style="font-size:20px">Vacunas de:</span> ${mascota.nombre} <span class="glyphicon glyphicon-heart" style="color:orange"></span></h1>							 	
 			
 			
 				<table class="table table-striped">
                	<thead>
                    	<tr>
                        	<th>Id</th>
                         	<th>Vacuna</th>
                        	<th>Estado</th>
                        	<th> </th>
                    	</tr>
                    </thead>

                    <c:forEach var="id" items="${id}">
                        <tr>
                            <td>${id.id}</td>
  							<td>${id.vacuna.nombreVacuna}</td>						
                            <td>${id.estado}</td>      
                            <td>
     			            <c:if test="${id.estado=='no'}">
				                <a class="btn btn-warning" href="<c:url value="/turno"/>">SacarTurno <i class="fa fa-edit"></i></a>
				            </c:if>
            
				            <c:if test="${id.estado=='ok'}">
				            	<h11>Vence cada ${id.vacuna.vencimiento} meses</h11>
				            </c:if>
            				<!-- <a class="btn btn-warning" >Editar <i class="fa fa-edit"></i></a> --> 
                            </td>                         
                        </tr>
                    </c:forEach>               
                </table>
 								
				
				<a href="<c:url value="/perfil"/>" class="btn btn-lg btn-primary btn-block btn-warning" role="button">Volver</a>	 
				
			</div>	
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
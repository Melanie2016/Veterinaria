<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
			
				<h1><span style="font-size:20px">Vacunas de:</span> ${mascota.nombre} <span class="glyphicon glyphicon-heart" style="color:orange"></span></h1>							 	
 			
 			
 				<table class="table table-striped">
                	<thead>
                    	<tr>
                        	<th>Id</th>
                         	<th>Vacuna</th>
                         	<th>Aplicacion</th>
                        	<th>Estado</th>
                        	<th>Info</th>
                        	<th> </th>
                    	</tr>
                    </thead>

                    <c:forEach var="id" items="${id}">
                        <tr>
                            <td>${id.id}</td>
  							<td>${id.vacuna.nombreVacuna}</td>
<td><fmt:formatDate type = "date" pattern="yyyy/MM/dd" value = "${id.fecha_aplicacion}" />  </td>						
                      <td>     
                           <c:if test="${id.estado=='no'}">
				            <span class="glyphicon glyphicon-remove" style="color:red"></span> 
				            </c:if>
				            <c:if test="${id.estado=='Dada'}">
				             <span class="glyphicon glyphicon-ok" style="color:green"></span>
				            </c:if>                    
                                 </td> 
                            
                            
                            
                            
                  <c:if test="${id.vacuna.nombreVacuna=='Quintuple'}">
                  <td>Se da una vez</td>
                  </c:if> 
                  <c:if test="${id.vacuna.nombreVacuna!='Quintuple'}">
                  <td>Vence cada ${id.vacuna.vencimiento} meses</td> 
                  </c:if>         
                                
      <td>
                           
     			            <c:if test="${id.estado=='no'}">
				 <a class="btn btn-warning" href="<c:url value="/turno"/>">SacarTurno<i class="fa fa-edit"></i></a>
				            </c:if>
            
				            <c:if test="${id.estado=='Dada'}">
				<a class="btn btn-default" href="<c:url value="/revacunar/${id.id}/${id.fecha_aplicacion}"/>">VerRevacunacion <i class="fa fa-edit"></i></a>			
			            </c:if>
                            </td>                         
                        </tr>
                    </c:forEach>               
                </table>
 								
				
				<a href="<c:url value="/perfil"/>" class="btn btn-lg btn-primary btn-block btn-warning" role="button">Volver</a>	 
			
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
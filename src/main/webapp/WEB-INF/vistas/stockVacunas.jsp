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
		      <li><a href="<c:url value="/perfilAdmin"/>">Perfil</a></li>
		      <li  class="active"><a href="#">StockVacunas</a></li>
		       <li><a href="<c:url value="/veterinarios"/>">Veterinarios</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      
		      <li><a href="<c:url value="/cerrarSession"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> LogOut</a></li>
		    </ul>
				</div>
			</nav>
		<div class="container">
		<div id="loginbox" style="margin-top:20px; width:600px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<h1><span style="font-size:20px">
		Stock de</span> Vacunas <span class="glyphicon glyphicon-heart" style="color:orange">
		</span></h1>
				
             <table class="table table-striped">
		            <thead>
			            <tr>
				            <th>Id</th>
				            <th>Nombre</th>	
				            <th>Animal</th>			       
				            <th>Cantidad</th>
				            <th></th>
			            </tr>
		            </thead>
		
		             <c:forEach var="vacuna" items="${vacuna}">
		            <tr>
			            <td>${vacuna.id}</td>
			            <td>${vacuna.nombreVacuna}</td>
			            <td>${vacuna.animal}</td>
			            <td>${vacuna.cantStock}</td>
 <td> <c:if test="${vacuna.cantStock<20}"> 
      <div> <span class="glyphicon glyphicon-alert" style="color:red"> </span>  &nbsp; Comprar</div>
      </c:if></td>
 <td> <a class="btn btn-warning" href="#">Editar <i class="fa fa-minus"></i>  </td>
		            	
					    	
			        </tr>
			        </c:forEach>
		        </table>

		
	</div>		
		</div>
		<!-- Placed at the end of the do"src/main/webapp/WEB-INF/vistas/login.jsp"cument so the pages load faster -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
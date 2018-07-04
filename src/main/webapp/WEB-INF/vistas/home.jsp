<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<link href="css/cssHome.css" rel="stylesheet">
		
		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- Bootstrap theme -->
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
	<nav class="navbar navbar-default" >
			<div class="container-fluid" >
				<div class="navbar-header">
					<a class="navbar-brand" href="<c:url value="/home"/>">VET Center <span
						class="glyphicon glyphicon-heart" style="color: orange"></span>
					</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="<c:url value="/perfil"/>">Perfil</a></li>
					<li><a href="<c:url value="/turno"/>">Turnos</a></li>
					<li><a href="<c:url value="/peluqueria"/>">Peluquerias</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"
							style="color: orange"></span> Registrarse</a></li>
					<li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"
							style="color: orange"></span> Login</a></li>
				</ul>
			</div>
		</nav>
		<!-- 
		<div>
				<img src="img/fondo.png" class="img-fluid" alt="Responsive image"  width="auto" height="100">
			</div>
		 -->
		<div class="fondo" style="background: url(img/fondo.png) no-repeat center;background-size:cover" >
			
			 <a href="<c:url value="/login"/>" class="btn btn-lg btn-primary  btn-warning"  role="button"
			 style="margin-top:30%; margin-bottom:15px;"><i style="font-size:24px" class="fa">&#xf0f9;</i> Comenzar </a>	

		
		</div>
	
	
		<!-- Placed at the end of the document so the pages load faster -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
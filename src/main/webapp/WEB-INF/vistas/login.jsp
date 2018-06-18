<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
      <li><a href="<c:url value="/turno"/>">Turnos</a></li>
      <li><a href="#">Peluquerias</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
     <%-- <li><a href="#"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>--%>
    </ul>
  </div>
</nav>
		<div class = "container">
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form:form action="validar-login" method="POST" modelAttribute="usuario">
			    
					 <h6 class="form-signin-heading">Ingrese sus datos para loguearse</h6>

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<label for="email">Email:</label>
					<form:input path="email" id="email" type="email" class="form-control" />
					<br>
					<label for="email">Password:</label>
					<form:input path="password" type="password" id="password" class="form-control"/>     		  
					<br>
					<button class="btn btn-lg btn-primary btn-block btn-warning" Type="Submit"> Ingresar</button>

				</form:form>
				
				<div class="alert alert-warning">
                 Si aun no te has registrado hazlo <strong>AQUI</strong></div>
				
				
				
				

				<%--Bloque que es visible si el elemento error no estÃ¡ vacÃ­o	--%>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>


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
		      <li><a href="<c:url value="/perfil"/>">Perfil</a></li>
		      <li class="active"><a href="#">Turnos</a></li>
		      <li><a href="<c:url value="/peluqueria"/>">Peluquerias</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
		      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>
		    </ul>
				</div>
			</nav>
		<div class="container">
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					
						<h1 >Reserve su turno</h1>
						<!-- VER ..  https://www.youtube.com/watch?v=rFCaI1daCLs  https://www.youtube.com/watch?v=KnZ5zYYIxu8-->
						<div class="form-group">
							<label for="sel1">Seleccione especialidad:</label> 
							<!-- onchange="ShowSelected();"  -->
							<select	 id="especialidadId" name="especialidadId" class="form-control">
								<option value="0">Seleccione especialidad</option>
								<c:forEach items="${especialidades}" var="especialidades">
									<option value="${especialidades.especialidadId}">${especialidades.descripcion}</option>
								
								</c:forEach>
								
							</select>
						 	
						</div>
						
						
						<!-- pasamos el id por una funcion  -->
						<button class="btn btn-lg btn-primary btn-block btn-warning" onclick="ShowSelected()"
						>Buscar veterinario </button>
			
			</div>
		</div>
		<!-- Placed at the end of the do"src/main/webapp/WEB-INF/vistas/login.jsp"cument so the pages load faster -->
		<script type="text/javascript">
							function ShowSelected()
							{
							/* Para obtener el valor */
							var cod = document.getElementById("especialidadId").value;
								if(cod == null || cod == 0){
									alert('Para continuar es necesario que seleccione una especialidad  ¡GRACIAS!');
								}
								else{
									location.href="consultarVet/"+cod;
								}
								
							
							
							/* Para obtener el texto 
							var combo = document.getElementById("producto");
							var selected = combo.options[combo.selectedIndex].text;
							alert(selected); */
							
							}
		</script>
		
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
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
     <!-- <li><a href="<c:url value="/perfil"/>">Perfil</a></li>
      <li><a href="<c:url value="/turno"/>">Turnos</a></li>
      <li><a href="<c:url value="/peluqueria"/>">Peluquerias</a></li>-->
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
     <%-- <li><a href="#"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>--%>
    </ul>
  </div>
</nav>
<div class = "container">
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

		<%--Bloque que es visible si el elemento error no estÃ¡ vacÃ­o	--%>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
		        
		        	<ol class="breadcrumb text-center">
	          			<li class="breadcrumb-item active">Administración de Veterinarios - Desde aquí los podrá visualizar, crear y modificar.</li>
	     			</ol>
	     			
                            <div class="panel panel-primary">
							<div class="panel-heading">Listado de Veterinarios</div>
							<div class="container-fluid">
									
										
									<tr>
									<th class="text-center">ID</th>
									<th class="text-center">Nombre</th>
									<th class="text-center">Apellido</th>
									<th class="text-center">especialidad</th>
									</tr>
									
									<c:forEach items="${veterinarios}" var="vet">
									<tbody class="text-center">
									<td>${vet.id}</td>
									<td>${vet.nombre}</td>
									<td>${vet.apellido}</td>
									<td>${vet.especialidad}</td>
									</tbody>
									</c:forEach>
									</div>
								</div>
							    </div>
						        </div>
			<div class="panel panel-success">
						<div class="panel-heading"><h3 class="panel-title">Creación de un nuevo veterinario:</h3></div>
							<ol class="breadcrumb text-center">
	          					<li class="breadcrumb-item active">Desde aquí podrá crear un nuevo veterinario, ingrese a continuación un nombre para el mismo.</li>
	     					</ol>
						<div class="container-fluid">
						<form:form class="form-horizontal" role="form" action="crear-veterinario" modelAttribute="veterinario" method="post" name="crearVeterinario">
							<div class="form-group"></div>

							<div class="form-group">
								<div class="col-md-10 col-md-offset-1">
									<div class="input-group">
										<span class="input-group-addon">Apellido</span> 												
										<form:input type="text" class="form-control" path="apellido" name="nombreVeterinario" placeholder="Ingrese veterinario." required="required"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<a type="submit" data-toggle="modal" data-target="#add" class="btn btn-success">Crear nuevo veterinario</a>
							</div>
						</div>
					</form:form>
					</div>					
					</div>
					
			<div class="panel panel-warning">
						<div class="panel-heading acomodar"><h3 class="panel-title">Modificación de veterinarios:</h3>
							<div class="centrar_derecha" aria-label="top Align" data-placement="rigth" data-toggle="tooltip" data-html="true" title="Por el momento, solo se pueden modificar equipos que no participen de ningún partido">
								<div class="glyphicon glyphicon-question-sign" aria-hidden="true"></div>
							</div>
						</div>
							<ol class="breadcrumb text-center">
	          					<li class="breadcrumb-item active">Desde aquí podrá modificar el nombre del equipo seleccionado.</li>
	     					</ol>	
						<div class="container-fluid">

						<form:form class="form-horizontal" role="form" action="actualizar-veterinario" modelAttribute="veterinario method="post" name="modificarVeterinario">
							<div class="form-group"></div>

							<div class="form-group">
								<div class="col-md-10 col-md-offset-1">
									<div class="input-group center">
										<span class="input-group-addon">Veterinario a modificar:</span>																
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-10 col-md-offset-1">
									<div class="input-group center">
										<span class="input-group-addon">Nombre</span> 											
										<form:input path="nombre" type="text" class="form-control" name="nombreEquipo" placeholder="Ingrese un nuevo nombre." required="required"/>
									</div>											
								</div>
							</div>							

							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<a type="submit" data-toggle="modal" data-target="#update" class="btn btn-warning">Modicar veterinario existente</a>
								</div>
							</div>													
						</form:form>
						</div>
					</div>			
 
</body>
</html>
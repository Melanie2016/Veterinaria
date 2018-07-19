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
		
			
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<h1>TURNO</h1>
				<form:form action="${pageContext.request.contextPath}/validarTurno" method="POST" modelAttribute="turno" >
				
			 
				
					<div class="form-group">
						<label>Doctor :</label> ${diaAtencion.veterinario.apellido},${diaAtencion.veterinario.nombre}
						<br>
						<label>Fecha de Turno :</label> ${diaAtencion.dia}
						
				   	 	<fmt:formatDate type ="date"  value = "${fechaTurno}" />
						<form:input path="diaAtencion" id="diaAtencion" type="hidden" class="form-control" value="${diaAtencion}"  />
						
					 	
				    	<form:input path="fechaTurno" id="fechaTurno" type="hidden" class="form-control" value="${fechaTurno}"  /><br>
						
						
						<label >En el horario de :</label>
						<form:select path="horaTurno" id="horaTurno" class="form-control">
							<form:option value="0">Seleccione especialidad</form:option>
							
									<c:forEach items="${horarios}" var="horarios">
										<form:option value="${horarios}"><fmt:formatDate type = "time" pattern="hh:mm"  value = "${horarios}" /></form:option>
									
									</c:forEach>
						
						</form:select>
						<br>
						<button class="btn btn-lg btn-primary btn-block btn-warning" Type="Submit"> Ingresar</button>
		
	<!-- 					SE DEBE SELECCIONAR LA MASCOTA, HACER EN EL ORIGINAL PARA USAR LO DEL LOGIN -->
					
					
					</div>
					
				
				</form:form>
			
				<a href="<c:url value="/turno"/>" class="btn btn-warning" role="button" ><span class="glyphicon glyphicon-hand-left"></span></a>	 
				
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
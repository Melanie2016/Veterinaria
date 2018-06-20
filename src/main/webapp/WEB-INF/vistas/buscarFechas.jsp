<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
        <meta charset="utf-8">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
		<script>
		$(function () {
		$("#fecha").datepicker();
		});
		</script>
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
		      <li><a href="#">Peluquerias</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
		      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>
		    </ul>
				</div>
		</nav>
		<div class="container">
		
			<form:form action="registrarTurno" method="POST" modelAttribute="especialidades">
				<h1>Disponibilidad</h1>			
				<div class="form-group">
					
				
					
					<label for="fecha">Seleccione fecha:</label>
						<input class="form-control" type="text" id="fecha" value="" placeholder="Seleccione fecha" />
					
					<br>
					<label for="sel1">Ingrese horario:</label> 
    				<input class="form-control" type="text" id="fecha" value="" placeholder="Seleccione fecha" />
					
				</div>
				<br>
				<button class="btn btn-lg btn-primary btn-block btn-warning"
						Type="Submit" >
					Buscar Turnos
				</button>
			 
			</form:form>
		</div>	
    </body>
    <script>
				
					 $.datepicker.regional['es'] = {
					 closeText: 'Cerrar',
					 prevText: '< Ant',
					 nextText: 'Sig >',
					 currentText: 'Hoy',
					 monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
					 monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
					 dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
					 dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
					 dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
					 weekHeader: 'Sm',
					 dateFormat: 'dd/mm/yy',
					 firstDay: 1,
					 isRTL: false,
					 showMonthAfterYear: false,
					 yearSuffix: ''
					 };
					 $.datepicker.setDefaults($.datepicker.regional['es']);
					$(function () {
					$("#fecha").datepicker();
					});
					
	</script>
</html>
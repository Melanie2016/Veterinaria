<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="<c:url value="/home"/>">VET Center <span class="glyphicon glyphicon-heart"style="color:orange"></span> </a>
		    </div>
		    
		    <ul class="nav navbar-nav">
		      <li><a href="<c:url value="/perfil"/>">Perfil</a></li>
		      <li ><a href="#">Turnos</a></li>
		      <li class="active"><a href="<c:url value="/peluqueria"/>">Peluquerias</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user" style="color:orange"></span> Registrarse</a></li>
		      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in" style="color:orange"></span> Login</a></li>
		    </ul>
				</div>
			</nav>
		<div class="container">
			<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
  
</head> 
<body>
	<title>Mapa con Peluquerias Caninas</title>
<style type="text/css">
</style>
<script type="text/javascript"
   src="http://maps.googleapis.com/maps/api/js?Key=AIzaSyDjTgbFYlZSR1YC4qxZdO3NMsdo3rMTzpk&callback=initMap" async defer></script>
<script >

function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -34.397, lng: 150.644},
          zoom: 14
        });
        var infoWindow = new google.maps.InfoWindow({map: map});

        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };


            infoWindow.setPosition(pos);
            infoWindow.setContent('Esta es tu ubicacion');
            map.setCenter(pos);


            var icon = {
            	    url: "vista/multimedia/imagenes/pointer.png", // url
            	    scaledSize: new google.maps.Size(30, 30), // escala siza
            	    origin: new google.maps.Point(0,0), // origen
            	    anchor: new google.maps.Point(0, 0) // ancho
            	};

            	var marker = new google.maps.Marker({
            	                position: pos,
            	                map: map,
            	                title: 'marker with infoWindow',
            	                icon: icon
            	           });
            	           marker.addListener('click', function() {
            	               infowindow.open(map, marker);
            	          });


            	          }, function() {
            	            handleLocationError(true, infoWindow, map.getCenter());
            	          });
            	        } else {
            	          // Navegador no soporta Geolocation
            	          handleLocationError(false, infoWindow, map.getCenter());
            	        }
            	      }

            	      function handleLocationError(browserHasGeolocation, infoWindow, pos) {
            	        infoWindow.setPosition(pos);
            	        infoWindow.setContent(browserHasGeolocation ?
            	                              'Error: El servicio geolocalizador fallo.' :
            	                              'Error: Tu Navegador no soporta el geolocalizador.');
            	      }
</script>      
              <h2>Elige tu peluqueria mas cercana</h2>
              <center><div id="map" style="height:500px;width:800px;margin-top:5%;"></div></center>

	</body>
		
		
</html>
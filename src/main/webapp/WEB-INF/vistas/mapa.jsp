<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCiIDP3P5IqtJ4LQGy2--zrhbtCsXJGpjI
"></script>
<script>



function initialize() {
	

    var marcadores = [
        ['El Campito:Jugadores 10/22', -34.668918 , -58.549709],
        ['SportCenter:Jugadores 18/22', -34.674413, -58.566627],
        ['Don Ramon:Jugadores 5/10', -34.670709, -58.558488]
      ];
      var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 11,
        center: new google.maps.LatLng(41.503, -5.744),
        mapTypeId: google.maps.MapTypeId.ROADMAP
      });
      var infowindow = new google.maps.InfoWindow();
      var marker, i;
      for (i = 0; i < marcadores.length; i++) {  
        marker = new google.maps.Marker({
          position: new google.maps.LatLng(marcadores[i][1], marcadores[i][2]),
          map: map
        });
        google.maps.event.addListener(marker, 'mouseover', (function(marker, i) {
          return function() {
            infowindow.setContent(marcadores[i][0]);
            infowindow.open(map, marker);
          }
        })(marker, i));
      }
	
  
    
  var infoWindow = new google.maps.InfoWindow({map: map});
 

  // Try HTML5 geolocation.
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
      var pos = {
        lat: position.coords.latitude,
        lng: position.coords.longitude
      };
      
      var radio = new google.maps.Circle({
  	    center: pos,
  	    radius: 15000,
  	    strokeColor: "#0000FF",
  	    strokeOpacity: 0.8,
  	    strokeWeight: 2,
  	    fillColor: "#0000FF",
  	    fillOpacity: 0.4
  	  });
      
      radio.setMap(map);
      
      infoWindow.setPosition(pos);
      infoWindow.setContent('Mi Ubicacion');
      map.setCenter(pos);
    }, function() {
      handleLocationError(true, infoWindow, map.getCenter());
    });
  } 
  
  else {
    // Browser doesn't support Geolocation
    handleLocationError(false, infoWindow, map.getCenter());
  }
}




function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
                          'Error: The Geolocation service failed.' :
                          'Error: Your browser doesn\'t support geolocation.');
  }

google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>

 <div id="map" style="height:600px; width:800px"></div>




</body>
</html>
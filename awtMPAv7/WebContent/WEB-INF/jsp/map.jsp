<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Simple markers</title>
<style>
html, body, #map-canvas {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBEHHQjgBqP-KV1XRr8TKa5uUSFw4c5Ago"></script>
<script>
	function initialize() {
		
		//definizione latitudine e longitudine
		var myLatlng = new google.maps.LatLng("${latitude}","${longitude}");
		
		//Opzioni della mappa
		var mapOptions = {
			zoom : 7,
			center : myLatlng
		}
		
		//Inizializzazione mappa
		var map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		//creazione del marker
		var marker = new google.maps.Marker({
			position : myLatlng,
			map : map,
			title : 'Hello World!'
		});
	}

	
	//caricamento mappa
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
	<div id="map-canvas"></div>
</body>
</html>
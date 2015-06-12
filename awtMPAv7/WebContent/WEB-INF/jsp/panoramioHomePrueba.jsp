
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>Restricting photos by tag (Panoramio layer)</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
    </style>
    <style>
      #filter {
        padding: 5px 10px;
        background: #fff;
        border: 1px solid #ccc;
        border-top: 0;
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=panoramio"></script>
    <script>
function initialize() {
  var mapOptions = {
    zoom: 15,
    center: new google.maps.LatLng(20.693134, 54.031028)
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'),
    mapOptions);

 // var panoramioLayer = new google.maps.panoramio.PanoramioLayer();
  //panoramioLayer.setMap(map);

//  var tag = document.getElementById('tag');
  //var button = document.getElementById('filter-button');

 // google.maps.event.addDomListener(button, 'click', function() {
   // panoramioLayer.setTag(tag.value);
 // });

  //map.controls[google.maps.ControlPosition.TOP_CENTER].push(
    //  document.getElementById('filter'));
}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>
  </head>
  <body>
    <div id="filter">
      <input id="tag" value="como lake">
      <button id="filter-button">Filter on Tag</button>
    </div>
    <div id="map-canvas"></div>
  </body>
</html>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Simple markers</title>
<!-- Core CSS file -->
<link rel="stylesheet" href="jsp/photoswipe/css/photoswipe.css"> 

<!-- Skin CSS file (styling of UI - buttons, caption, etc.)
     In the folder of skin CSS file there are also:
     - .png and .svg icons sprite, 
     - preloader.gif (for browsers that do not support CSS animations) -->
<link rel="stylesheet" href="jsp/default/default-skin.css"> 

<!-- Core JS file -->
<script src="jsp/js/photoswipe.min.js"></script> 

<!-- UI JS file -->
<script src="jsp/js/photoswipe-ui-default.min.js"></script> 
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
			icon : 'jsp/images/icon.png',
			title : "${title}"
		});
		
		google.maps.event.addListener(marker, 'click', function(){
			var pswpElement = document.querySelectorAll('.pswp')[0];

			// build items array
			var items = [
			    {
			        src: 'http://www.calcioweb.eu/wp-content/uploads/2013/09/milito.jpg',
			        w: 600,
			        h: 400
			    },
			    {
			        src: 'https://placekitten.com/1200/900',
			        w: 1200,
			        h: 900
			    }
			];

			// define options (if needed)
			var options = {
			    // optionName: 'option value'
			    // for example:
			    index: 0 // start at first slide
			};

			// Initializes and opens PhotoSwipe
			var gallery = new PhotoSwipe( pswpElement, PhotoSwipeUI_Default, items, options);
			gallery.init();
		});
		
	}

	
	//caricamento mappa
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
	<div id="map-canvas"></div>
	<!-- Root element of PhotoSwipe. Must have class pswp. -->
<div class="pswp" tabindex="-1" role="dialog" aria-hidden="true">

    <!-- Background of PhotoSwipe. 
         It's a separate element as animating opacity is faster than rgba(). -->
    <div class="pswp__bg"></div>

    <!-- Slides wrapper with overflow:hidden. -->
    <div class="pswp__scroll-wrap">

        <!-- Container that holds slides. 
            PhotoSwipe keeps only 3 of them in the DOM to save memory.
            Don't modify these 3 pswp__item elements, data is added later on. -->
        <div class="pswp__container">
            <div class="pswp__item"></div>
            <div class="pswp__item"></div>
            <div class="pswp__item"></div>
        </div>

        <!-- Default (PhotoSwipeUI_Default) interface on top of sliding area. Can be changed. -->
        <div class="pswp__ui pswp__ui--hidden">

            <div class="pswp__top-bar">

                <!--  Controls are self-explanatory. Order can be changed. -->

                <div class="pswp__counter"></div>

                <button class="pswp__button pswp__button--close" title="Close (Esc)"></button>

                <button class="pswp__button pswp__button--share" title="Share"></button>

                <button class="pswp__button pswp__button--fs" title="Toggle fullscreen"></button>

                <button class="pswp__button pswp__button--zoom" title="Zoom in/out"></button>

                <!-- Preloader demo http://codepen.io/dimsemenov/pen/yyBWoR -->
                <!-- element will get class pswp__preloader--active when preloader is running -->
                <div class="pswp__preloader">
                    <div class="pswp__preloader__icn">
                      <div class="pswp__preloader__cut">
                        <div class="pswp__preloader__donut"></div>
                      </div>
                    </div>
                </div>
            </div>

            <div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
                <div class="pswp__share-tooltip"></div> 
            </div>

            <button class="pswp__button pswp__button--arrow--left" title="Previous (arrow left)">
            </button>

            <button class="pswp__button pswp__button--arrow--right" title="Next (arrow right)">
            </button>

            <div class="pswp__caption">
                <div class="pswp__caption__center"></div>
            </div>

        </div>

    </div>

</div>
</body>
</html>
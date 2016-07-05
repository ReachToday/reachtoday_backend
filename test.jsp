<!DOCTYPE html>
<html>
<head>
<title>Reach Today</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<style>
html, body, #map-canvas {
	height: 100%;
	margin: 0px;
	padding: 0px
}

#panel {
	position: absolute;
	top: 10px;
	left: 6%;
	z-index: 5;
	background-color: #fff;
	padding: 5px;
	border: 1px solid #999;
}
</style>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=false&libraries=geometry"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<script>
var map;
var usermarker;
var targetmarker=[];
var geocoder;
var targetgeocoder;
 var pos;
var targetpos=[];
var markers = [];
var mapfitflag=0;
 var infowindow = new google.maps.InfoWindow();
 var userinfowindow = new google.maps.InfoWindow();
//code to fit the markers in the bounds
 var bounds = new google.maps.LatLngBounds();
function initialize() {

var mapOptions = {
    zoom: 13
  };


 var useragent = navigator.userAgent;
  var mapdiv = document.getElementById("map-canvas");


//This is the width and height variables
  if (useragent.indexOf('iPhone') != -1 || useragent.indexOf('Android') != -1 ) {
    mapdiv.style.width = '100%';
    mapdiv.style.height = '100%';
  } else {
    mapdiv.style.width = '100%';
    mapdiv.style.height = '100%';
  }


//This is map object which gets the map from google
  map = new google.maps.Map(mapdiv,
      mapOptions);

// getting present location
  if(navigator.geolocation) { 
//poly line for user navigation
 var line=new google.maps.Polyline(
              {
                map:map,
                icons: [{
                          icon: {
                                  path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW,
                                  strokeColor:'#0000ff',
                                  fillColor:'#0000ff',
                                  fillOpacity:1
                                },
                          repeat:'100px',
                          path:[]
                       }]
                 });
//Usernavigation based on the change of his co-ordinates
navigator.geolocation.watchPosition(function(position) {
	
	
var path=line.getPath().getArray(),userchangepos = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
pos=userchangepos;
path.push(userchangepos);
line.setPath(path);

 //new google.maps.Marker({map:map,position:latLng});
 
	 usermarker = new google.maps.Marker({
      position: userchangepos,
      map: map
  });
	 	userinfowindow.setContent("<h2>You are here</h2>");
	 	//enable this one for user popup
// 	 	usermarkerclick("<h2>You are here</h2>");
	    userinfowindow.open(map, usermarker);
	    map.setCenter(userchangepos);
	    if(targetpos.length>0 && mapfitflag==0){
	 bounds.extend(userchangepos);
	 for(var i=0;i<targetpos.length;i++)
	 bounds.extend(targetpos[i]);
	   map.fitBounds(bounds);
	    map.panToBounds(bounds);  
	    mapfitflag=1;
	    }
	    
    }, function() {
    	//When user does not reveal the locational details
    	var path=line.getPath().getArray(),userchangepos = new google.maps.LatLng(13.0967282,80.2042327);
    	pos=userchangepos;
    	path.push(userchangepos);
    	line.setPath(path);

    	 //new google.maps.Marker({map:map,position:latLng});
    	 
    		 usermarker = new google.maps.Marker({
    	      position: userchangepos,
    	      map: map
    	  });
    		 	userinfowindow.setContent("<h2>You are here</h2><p>Allow location access.I've put you in Chennai for now.</p>");
    		 	//enable this one for user popup
//     		 	usermarkerclick("<h2>You are here</h2><p>Allow location access.I've put you in Chennai for now.</p>");
    		    userinfowindow.open(map, usermarker);
    		    map.setCenter(userchangepos);
    		    if(targetpos.length>0 && mapfitflag==0){
    		   	 bounds.extend(userchangepos);
    		   	 for(var i=0;i<targetpos.length;i++)
    		   	 bounds.extend(targetpos[i]);
    		   	   map.fitBounds(bounds);
    		   	    map.panToBounds(bounds);  
    		   	    mapfitflag=1;
    		   	    }
    });
    
    
    
  } else {
    // Browser doesn't support Geolocation
    handleNoGeolocation(false);
  }
}

//Method to show up the user marker

function usermarkerclick(content)
{
	google.maps.event.addListener(usermarker, 'click', function() {
		//This contains the reversergeo coding shows the popup(info window) with the location address of user
		//it takes the co-ordinates as input and gives the address
		userinfowindow.setContent(content);
	    userinfowindow.open(map, usermarker);
	    map.setCenter(userchangepos);
	    if(targetpos.length>0 && mapfitflag==0){
	   	 bounds.extend(userchangepos);
	   	 for(var i=0;i<targetpos.length;i++)
	   	 bounds.extend(targetpos[i]);
	   	   map.fitBounds(bounds);
	   	    map.panToBounds(bounds);  
	   	    mapfitflag=1;
	   	    }
		    });
	}


//This method will be executed on error of getting the geo location co-ordinates
function handleNoGeolocation(errorFlag) {
  if (errorFlag) {
    var content = 'Error: Please Switch on Location in your Mobile. To get distance b/w you and target';
  } else {
    var content = 'Error: Your browser doesn\'t support geolocation.';
  }

  var options = {
    map: map,
    position: new google.maps.LatLng(60, 105),
    content: content
  };

  var infowindow = new google.maps.InfoWindow(options);
  map.setCenter(options.position);
}



//For making the usermarker bounce when user clicks on it

function toggleBounce() {

  if (usermarker.getAnimation() != null) {
    usermarker.setAnimation(null);
  } else {
    usermarker.setAnimation(google.maps.Animation.BOUNCE);
  }
}
google.maps.event.addDomListener(window, 'load', initialize);





//on click of the search of the target
function onSearchClick(buslocation,z)
{
	datafromdbforwaiting[z]=buslocation;
var latlngStr = buslocation.split(',', 2);
  var lat = parseFloat(latlngStr[0]);
  var lng = parseFloat(latlngStr[1]);

  var path=targetline[z].getPath().getArray();
  targetpos[z] = new google.maps.LatLng(lat,lng);
  path.push(targetpos[z]);
  targetline[z].setPath(path);

targetmarker[z] = new google.maps.Marker({
      position: targetpos[z],
      map: map,
  });

//This is related to the reverse geo-coding
 targetgeocoder = new google.maps.Geocoder();
 targetgeocoder.geocode({'latLng': targetpos[z]}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      if (results[1]) {
    	  targetinfowindow[z].setContent(results[1].formatted_address+"\n Distance B/W target and you is : "+calcDistance(pos, targetpos[z])+"Km");
    	  targetinfowindow[z].open(map, targetmarker[z]);
      } else {
        alert('No results found');
      }
    } else {
      alert('Geocoder failed due to: ' + status);
    }
  });
google.maps.event.addListener(targetmarker[z], 'click', function() {
//This contains the reversergeo coding shows the popup(info window) with the location address of user
//it takes the co-ordinates as input and gives the address
targetgeocoder.geocode({'latLng': targetpos[z]}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      if (results[1]) {
    	  targetinfowindow[z].setContent(results[1].formatted_address+"\n Distance B/W target and you is : "+calcDistance(pos, targetpos[z])+"Km");
    	  targetinfowindow[z].open(map, targetmarker[z]);
      } else {
        alert('No results found');
      }
    } else {
      alert('Geocoder failed due to: ' + status);
    }
  });
    });
fitBounds();
}
//function to show the line path for the target 
//need to change the target line it is fixed to 2o hardcoded not dynamic
var targetline=[];
var targetinfowindow=[];
function Targetnavigation()
{
	//poly line for user navigation
	
	for(var f=0;f<20;f++){
		targetinfowindow[f]=new google.maps.InfoWindow();
		if(f/2==0){
	targetline[f] =new google.maps.Polyline(
	              {
	                map:map,
	                icons: [{
	                          icon: {
	                                  path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW,
	                                  strokeColor:'#FF4000',
	                                  fillColor:'#FF4000',
	                                  fillOpacity:1
	                                },
	                          repeat:'100px',
	                          path:[]
	                       }]
	                 });
		}else
			{
			targetline[f] =new google.maps.Polyline(
		              {
		                map:map,
		                icons: [{
		                          icon: {
		                                  path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW,
		                                  strokeColor:'#09E941',
		                                  fillColor:'#09E941',
		                                  fillOpacity:1
		                                },
		                          repeat:'100px',
		                          path:[]
		                       }]
		                 });
			}
	}
	}


function showAllMarkers()
{
for (var i = 1; i < markers.length; i++) {
    markers[i].setMap(map);
  }
}
//deleteing the old marker from the map
function ShowonlyCurrenttargetlocation()
{
for (var i = 1; i < markers.length; i++) {
    markers[i].setMap(null);
  }
}

//Code to calculate the distance b/w two points
function calcDistance(p1, p2){
  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
}


//code to fit the markers in the bounds
function fitBounds()
{
	 if( mapfitflag==0){
		 bounds.extend(pos);
		 for(var i=0;i<targetpos.length;i++)
		 bounds.extend(targetpos[i]);
		   map.fitBounds(bounds);
		    map.panToBounds(bounds); 
		    mapfitflag=1;
		    }
 
}


function createXMLHttpRequest(){
	  // See http://en.wikipedia.org/wiki/XMLHttpRequest
	  // Provide the XMLHttpRequest class for IE 5.x-6.x:
	  if( typeof XMLHttpRequest == "undefined" ) XMLHttpRequest = function() {
	    try { return new ActiveXObject("Msxml2.XMLHTTP.6.0") } catch(e) {}
	    try { return new ActiveXObject("Msxml2.XMLHTTP.3.0") } catch(e) {}
	    try { return new ActiveXObject("Msxml2.XMLHTTP") } catch(e) {}
	    try { return new ActiveXObject("Microsoft.XMLHTTP") } catch(e) {}
	    throw new Error( "This browser does not support XMLHttpRequest." )
	  };
	  return new XMLHttpRequest();
	}

	var AJAX = createXMLHttpRequest();
	
	function testslepp(miliseconds) {
        var currentTime = new Date().getTime();

        while (currentTime + miliseconds >= new Date().getTime()) {
        }
    }
	
	
var datafromdbforwaiting=[];
	var waitinginterval=0;
	function handler() {
	  if(AJAX.readyState == 4 && AJAX.status == 200) {
	      var json =  JSON.parse(AJAX.responseText);
	      if(json.length==0)
	    	  {
	    	  clearInterval(setinter);
	    	  alert("No Registered Targets in this route");
	    	  }
	      for(var z=0;z<json.length;z++)
	    	  {
	    	  console.log("retrieved json length");
	    	  if(json[z].lat!=null && json[z].lng!=null && json[z].lat!="" && json[z].lng!=""){
	    	  	var latandlng = json[z].lat+","+json[z].lng;
	    	  	if(datafromdbforwaiting[z]==latandlng){
	    		      //add functionality of no change if more than 10 min
	    		      waitinginterval=waitinginterval+30;
	    		      if(waitinginterval>=600)
	    		    	  tempAlert("The Target has been in samePlace from Past "+(waitinginterval/60)+" Mins",5000);
	    		      }else 
	    		    	  {
	    		    	  waitinginterval=0;
	    		    	  //need to write a condition for  checking the null values
	    		    	  onSearchClick(latandlng,z);  
	    		    	  } 
	    	  }else
	    		  {
	    		  //send some sign to server such that data is null or empty for that request
	    		  clearInterval(setinter);
	    		  alert("Some thing wrong with data please contact kishore ");  
	    		  }
	    	  }
	      
	     /*  if(datafromdbforwaiting==json){
	      //add functionality of no change if more than 10 min
	      waitinginterval=waitinginterval+30;
	      if(waitinginterval>=600)
	    	  tempAlert("The Target has been in samePlace from Past "+(waitinginterval/60)+" Mins",20000);
	      }else 
	    	  {
	    	  waitinginterval=0;
	    	  //need to write a condition for  checking the null values
	    	  onSearchClick(json);  
	    	  } */
	      
	  }else if (AJAX.readyState == 4 && AJAX.status != 200) {
	    alert('Server is down....');
	  }
	  
	}

	//This time interval to call the ajax request continuosly once user starts checking the target
	var interval = 1000 * 60 * 1/2;
	var setinter;
	function getBusLocation()
	{
		Targetnavigation();
		show();
		setinter=setInterval(show,interval);
	}
	
	function show(){
	  AJAX.onreadystatechange = handler;
	  AJAX.open("GET", "Mysqlconnector?tablename="+document.getElementById('busnumber').value);
	  AJAX.send("");
	};

	function tempAlert(msg,duration)
	{
	 var el = document.createElement("div");
	 el.setAttribute("style","position:absolute;top:40%;left:20%;background-color:white;");
	 el.innerHTML = msg;
	 setTimeout(function(){
	  el.parentNode.removeChild(el);
	 },duration);
	 document.body.appendChild(el);
	}

    </script>
</head>
<body onload="getBusLocation()">
	<div id="panel" >
 	<% System.out.println(">>in jsp>>>"+request.getAttribute("busNumber").toString());
 	String a = request.getAttribute("busNumber").toString(); %> 
		<input id="busnumber" type="hidden" value=<%=a %> >
	</div>
	
	<div id="map-canvas" ></div>
</body>
</html>
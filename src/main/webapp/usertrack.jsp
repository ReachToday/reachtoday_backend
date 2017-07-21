<!DOCTYPE html>
<%@page import="org.json.JSONArray"%>
<html>
<head>
<script src="http://maps.googleapis.com/maps/api/js">
</script>

<script>

<%
String userTrackLocations=request.getAttribute("userTrackLocations").toString();
System.out.println("userTrackLocations::::::::"+userTrackLocations);
%>


var userTrackLocations = <%=userTrackLocations%>;
                 
var userTrackCoordinates=[];
                           
for(var j=0;j<userTrackLocations.length;j++){
var obj={lat: userTrackLocations[j].user_lat, lng: userTrackLocations[j].user_lng};
userTrackCoordinates.push(obj);
}



                 
var trackIcon = {
	    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
	    size: new google.maps.Size(20, 32),
	    origin: new google.maps.Point(0, 0),
	    anchor: new google.maps.Point(0, 32)
	  };
              
var myCenter=new google.maps.LatLng(13.075628,80.196080);

function initMap()
{
var mapProp = {
  center:myCenter,
  zoom:11,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };

var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

var geocoder=new google.maps.Geocoder();


var marker=new google.maps.Marker({
  position:myCenter,
  });
  
 /* if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function (position) {
        currentPos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
        var currentPosMarker=new google.maps.Marker({position:currentPos, map: map});   
         google.maps.event.addListener(currentPosMarker, "click", function(event) {
    	showInfo(currentPos,"");
      });     
        showInfo(currentPos,"");
        map.setCenter(currentPos);
    });
} */

addPolyline(userTrackLocations);

function addPolyline(userTrackLocations){
for(var i=0;i<userTrackLocations.length;i++){
        	
        	addMarker(new google.maps.LatLng(userTrackLocations[i].user_lat, userTrackLocations[i].user_lng), userTrackLocations[i].user_timestamp);
        }
        // for path of the user track
  /*       var userTrackPath = new google.maps.Polyline({
            path: userTrackCoordinates,
            geodesic: true,
            strokeColor: '#FF0000',
            strokeOpacity: 1.0,
            strokeWeight: 2
          });

userTrackPath.setMap(map); */
}

function addMarker(location, locationTimestamp) {
    marker = new google.maps.Marker({
        position: location,
        map: map,
        icon:trackIcon
    });
    
    google.maps.event.addListener(marker, "click", function(event) {
    	showInfo(location, locationTimestamp);
      });
}

function showInfo(pos, posTimestamp){
	
	var infoWindow = new google.maps.InfoWindow({map: map});
	infoWindow.setPosition(pos);
     geocoder.geocode({
         'latLng': pos
     }, function(results, status) {
         //alert("Else loop1");
         if (status == google.maps.GeocoderStatus.OK) {
             if (results[0]) {
                 var add = results[0].formatted_address;
                 if(posTimestamp==null||posTimestamp.length<=0||posTimestamp=='')
                 infoWindow.setContent(add);
                 else
                 infoWindow.setContent("<P>"+add+"<br> Timestamp: "+posTimestamp+"</p>");
             } else {
                 alert("address not found");
             }
         } else {
         	alert("Errorrrrrr.....");
         }
     });
}

marker.setMap(map);

}

google.maps.event.addDomListener(window, 'load', initMap);
</script>
</head>

<body width="100%" height="100%">
<div id="googleMap" style="height:1080px;"></div>
</body>
</html>

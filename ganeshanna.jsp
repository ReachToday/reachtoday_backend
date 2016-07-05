<!DOCTYPE html>
<html>
<head>
<title>Ganesh anna</title>
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

<script>

function initialize() {



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
	
	var output=[];
    var parent;
    var next=[];
    var data={};
	function handler() {
		
	  if(AJAX.readyState == 4 && AJAX.status == 200) {
	      var json =  JSON.parse(AJAX.responseText);
	      if(json.length==0)
	    	  {
	    	  return "";
	    	  }
	      
	      for(var z=0;z<json.length;z++)
	    	  {
	    	  //check for parent is empty
	    	  var temp=json[z].parent.split("|");
	    	  parent=temp[i];
	    	  if(temp.length>1)
	    	  for(i=1;i<temp.length;i++)
	    	  next.push({})
	    	  }
	  }else if (AJAX.readyState == 4 && AJAX.status != 200) {
	    alert('Server is down....');
	  }
	  
	}

	
	
	function show(){
	  AJAX.onreadystatechange = handler;
	  AJAX.open("GET", "getdata");
	  AJAX.send("");
	};

	

    </script>
</head>
<body >
	<div id="panel" >
 	<button onclick="show()">submit</button>
		
	</div>
	
	<div id="map-canvas" ></div>
</body>
</html>
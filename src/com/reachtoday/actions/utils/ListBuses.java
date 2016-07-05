package com.reachtoday.actions.utils;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/** 
 * Servlet implementation class ListBuses
 */

public class ListBuses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBuses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static float distFrom(float lat1, float lng1, float lat2, float lng2) {
	    double earthRadius = 6371000; //meters
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    float dist = (float) (earthRadius * c);

	    return dist;
	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			String yourposlat="";
			
			String yourposlng="";
			/*try{
			if(request.getParameter("mylat")!=null && request.getParameter("mylat").trim()!="")
			{
			 yourposlat=request.getParameter("mylat").trim();
			}
			if(request.getParameter("mylng")!=null && request.getParameter("mylng").trim()!="")
			{ 
				yourposlng=request.getParameter("mylng");
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}*/
			JSONArray listofbuses=new JSONArray();
			JSONArray arr=new JSONArray();
			//This if block makes us to find whethere we are getting the busnumber or not if 
			if(request.getParameter("tablename").trim().toLowerCase()!=null && request.getParameter("tablename").trim().toLowerCase()!=""){
			
			LatLang latlan=new LatLang();
			
			try{
			arr=latlan.getlatlang("select lat,lng,startlat,startlng,destlat,destlng,IMEI  from "+request.getParameter("tablename").trim().toLowerCase()+" where id= (select max(id) from "+request.getParameter("tablename").trim().toLowerCase()+" group by IMEI )");
			}catch(Exception e)
			{
				arr= new JSONArray();
				e.printStackTrace();
				
			}
			
			
			for(int i=0;i<arr.length();i++)
			{
				JSONObject bus=new JSONObject();
				
				JSONObject bus1loc1= new JSONObject(arr.get(i).toString());
				String IMEI=bus1loc1.getString("IMEI");
				String lat1=bus1loc1.getString("lat");
				String lng1=bus1loc1.getString("lng");
				String startlat=bus1loc1.getString("startlat");
				String startlng=bus1loc1.getString("startlng");
				String destlat=bus1loc1.getString("destlat");
				String destlng=bus1loc1.getString("destlng");
				bus.put("lat", lat1);
				bus.put("lng", lng1);
				bus.put("IMEI", IMEI);
				
				
				
				String at=getAddressByGpsCoordinates(lat1,lng1);
				
				String towards="dontknow";
				System.out.println("before the posdata check");
				if(yourposlat!=null && yourposlat.trim()!="" && yourposlng!=null && yourposlng.trim()!="")
				{
				try{
					System.out.println("in side the block");
					JSONArray arr2=latlan.getlatlang("select lat,lng,IMEI from "+request.getParameter("tablename").trim().toLowerCase()+" where id= (select max(id-1) from "+request.getParameter("tablename").trim().toLowerCase()+" group by IMEI ) and IMEI='"+IMEI+"'");
					System.out.println("arr2"+arr2);
					JSONObject bus1loc0= new JSONObject(arr2.get(0).toString());
					System.out.println(">>>>>"+bus1loc0);
					String lat0=bus1loc0.getString("lat");
					String lng0=bus1loc0.getString("lng");
					
					float dist1=distFrom(Float.valueOf(lat0.trim()),Float.valueOf(lng0.trim()),Float.valueOf(startlat.trim()),Float.valueOf(startlng.trim()));
					float dist2=distFrom(Float.valueOf(lat1.trim()),Float.valueOf(lng1.trim()),Float.valueOf(startlat.trim()),Float.valueOf(startlng.trim()));
				
					System.out.println(">>distance1>>>"+dist1);
					
					
					System.out.println(">>distance2>>>"+dist2);
					float change=dist1-dist2;
					
					System.out.println("change>>>"+change);
					if(change<0)
					{
						towards=getAddressByGpsCoordinates(destlat,destlng);
					}
					else
					{

						towards=getAddressByGpsCoordinates(startlat,startlng);;
					
					}
					if(change==0)
					{
						towards="dontknow";
						
					}
					
				}catch(Exception e)
				{
					e.printStackTrace();
					
				}
				}
				bus.put("towards", towards);
				bus.put("at", at);
				
				listofbuses.put(bus);
				
			}
			
			}
			out.print(listofbuses);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	
	/**
	 *
	 * @param lng
	 * @param lat
	 * @return
	 */
	String requestType = "GET";
	String data = "";
	    private String getAddressByGpsCoordinates(String lat, String lng)throws MalformedURLException, IOException {
	         
	    	
	    	 try {
	        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lng+"&sensor=true");
	        
	        System.out.println("url>>>"+url);
	       
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			data="";
	        String formattedAddress = "";
	       
	        	connection.setRequestMethod(requestType);
				connection.setUseCaches(false);
				connection.setDoInput(true);
				connection.setDoOutput(true);
				connection.connect();
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String response;
				while ((response = in.readLine()) != null) {
					data = data + response;
				}
				in.close();
	            JSONObject rsp = new JSONObject(data);
	 
	            
	            if (rsp.has("results")) {
	                JSONArray matches = new JSONArray(rsp.get("results").toString());
	                if(matches.length()>1){
	                JSONObject data = new JSONObject(matches.get(1).toString()); //TODO: check if idx=0 exists
	                formattedAddress = data.get("formatted_address").toString();
	                }else
	                {
	                	JSONObject data = new JSONObject(matches.get(0).toString()); //TODO: check if idx=0 exists
	                formattedAddress = data.get("formatted_address").toString();
	                }
	            }
	 System.out.println(">>>>formated address>>>"+formattedAddress);
	            return formattedAddress;
	        } catch(Exception e)
	        {
	        	e.printStackTrace();
	        	return "";
	        }finally {
	            
	           
	        }
	    }

}

package com.reachtoday.actions.userTracking;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.reachtoday.actions.utils.DBUtils;


/*User Tracking Service Operations*/
public class UserTrack extends HttpServlet{

	private static final long serialVersionUID = 1L;

	DBUtils dbUtils;
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void destroy() {
		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			performAction(request,response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			performAction(request,response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

	private void performAction(HttpServletRequest request, HttpServletResponse response) throws JSONException, SQLException, ServletException, IOException {
		
		String userId=request.getParameter("userId");
		
		String userTrackPointsQuery="select * from user_track where user_mailid='"+userId.trim()+"' order by id asc";
		try{
			dbUtils=new DBUtils();
		ResultSet resultSet=dbUtils.executeQuery(userTrackPointsQuery);
		
		JSONArray trackPointsList=new JSONArray();
		
		while(resultSet.next())
		{
			JSONObject trackPos=new JSONObject();
			trackPos.put("user_mailid", resultSet.getString("user_mailid"));
			trackPos.put("user_lat", resultSet.getDouble("user_lat"));
			trackPos.put("user_lng", resultSet.getDouble("user_lng"));
			trackPos.put("user_timestamp", resultSet.getString("user_timestamp"));
			trackPointsList.put(trackPos);
		}
		
		request.setAttribute("userTrackLocations", trackPointsList.toString());
		ServletContext context=request.getServletContext();
		RequestDispatcher dispatcher=context.getRequestDispatcher("/usertrack.jsp");
		dispatcher.forward(request, response);
		}catch(Exception e)
		{
			
		}finally
		{
			if(dbUtils!=null){
			
				dbUtils.close();
				dbUtils=null;
			}
		}
	}
		
}

package com.reachtoday.actions.users.tracking;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import com.reachtoday.utils.DBUtils;


/*User location access and insert into db for tracking */
public class UserLocationAccess extends HttpServlet{

	private static final long serialVersionUID = 1L;

	DBUtils dbUtils;
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
		} catch ( Exception e) {
			
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
		
		String userTrackPointsQuery="INSERT INTO user_track(user_lat,user_lng,user_mailid)  values('"+request.getParameter("userlat").trim()+"','"+request.getParameter("userlng").trim()+"','"+request.getParameter("usermailid").trim()+"')";
		try{
			dbUtils=new DBUtils();
		Boolean flag=dbUtils.executeinsert(userTrackPointsQuery);
		
		JSONArray trackPointsList=new JSONArray();
		trackPointsList.put(flag);
		
		
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

package com.reachtoday.actions.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class LatLang {

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	
	public JSONArray getlatlang(String Query)
	{
		try {
			
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/reachtoday?"
					+ "user=root&password=soft123");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			
			resultSet = statement.executeQuery(Query);
//			resultSet = statement.executeQuery("select lat,lng  from "+request.getParameter("tablename").trim().toLowerCase()+" where id in(1,2)");
			JSONArray arr=new JSONArray();

			while(resultSet.next())
			{
				JSONObject test= new JSONObject();
				if(resultSet.getBigDecimal("lat")!=null){
					test.put("lat", resultSet.getBigDecimal("lat"));
				}else
				{
					test.put("lat","");
				}
				
				if(resultSet.getBigDecimal("lng")!=null){
					test.put("lng", resultSet.getBigDecimal("lng"));
				}else
				{
					test.put("lng","");
				}
				if(resultSet.getString("IMEI")!=null){
					test.put("IMEI", resultSet.getString("IMEI"));
				}else
				{
					test.put("IMEI","");
				}
				if(resultSet.getBigDecimal("startlat")!=null){
					test.put("startlat", resultSet.getBigDecimal("startlat"));
				}else
				{
					test.put("startlat","");
				}
				
				if(resultSet.getBigDecimal("startlng")!=null){
					test.put("startlng", resultSet.getBigDecimal("startlng"));
				}else
				{
					test.put("startlng","");
				}
				if(resultSet.getBigDecimal("destlat")!=null){
					test.put("destlat", resultSet.getBigDecimal("destlat"));
				}else
				{
					test.put("destlat","");
				}
				
				if(resultSet.getBigDecimal("destlng")!=null){
					test.put("destlng", resultSet.getBigDecimal("destlng"));
				}else
				{
					test.put("destlng","");
				}
				arr.put(test);
			}
			
			return arr;			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new JSONArray();
		} finally {
			close();
		}
	}
	// You need to close the resultSet
		private void close() {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (connect != null) {
					connect.close();
				}
			} catch (Exception e) {

			}
		}
}

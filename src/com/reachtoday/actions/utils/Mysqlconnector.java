package com.reachtoday.actions.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/** 
 * Servlet implementation class Mysqlconnector
 */

public class Mysqlconnector extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Mysqlconnector() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/reachtoday?"
					+ "user=root&password=soft123");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			
			resultSet = statement.executeQuery("select lat,lng,IMEI from "+request.getParameter("tablename").trim().toLowerCase()+" where id= (select max(id) from "+request.getParameter("tablename").trim().toLowerCase()+" group by IMEI ) and IMEI='"+request.getParameter("IMEI").trim().toLowerCase()+"'");
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
				arr.put(test);
			}
			
			out.print(arr);
			out.flush();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public JSONArray executeQueryToJSONArray(ResultSet rst1) throws Exception{

		JSONArray result = new JSONArray();
		JSONArray row;
		int colIndex;
		int rowCount = 0;
		int colCount;

		ResultSet rst =rst1;

		colCount = rst.getMetaData().getColumnCount();
		while (rst.next()){
			row = new JSONArray();
			for ( colIndex=1; colIndex <= colCount; colIndex++){
				if(rst.getString(colIndex) != null && rst.getString(colIndex) != "")
					row.put(colIndex-1,rst.getString(colIndex));
				else
					row.put(colIndex-1," ");
			}
			result.put(rowCount++,row);
		}
		rst.close();
		rst = null;
		return result;
	}



	private void writeMetaData(ResultSet resultSet) throws SQLException {
		//   Now get some metadata from the database
		// Result set get the result of the SQL query

		System.out.println("The columns in the table are: ");

		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
			System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

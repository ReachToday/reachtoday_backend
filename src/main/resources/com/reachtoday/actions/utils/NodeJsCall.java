package com.reachtoday.actions.utils;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/** 
 * Servlet implementation class NodeJscall test
 */

public class NodeJsCall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NodeJsCall() {
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
			
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/reachtoday?"
					+ "user=root&password=soft123");

			// Statements allow to issue SQL queries to the database
			
			// Result set get the result of the SQL query
			
//			resultSet = statement.executeQuery(Query);
			if(!(request.getParameter("lat").trim().equalsIgnoreCase("")||request.getParameter("lng").trim().equalsIgnoreCase("")||request.getParameter("IMEI").trim().equalsIgnoreCase("")))
			{		
				if(request.getParameter("IMEI").trim().contains("28641389")){
				statement = connect.createStatement();	
				statement.execute("INSERT INTO bus1(lat,lng,IMEI) values('"+request.getParameter("lat").trim()+"','"+request.getParameter("lng").trim()+"','9003115833')");
				}
			if(request.getParameter("IMEI").trim().contains("71553766")){
				statement = connect.createStatement();	
				statement.execute("INSERT INTO bus2(lat,lng,IMEI) values('"+request.getParameter("lat").trim()+"','"+request.getParameter("lng").trim()+"','9003115833')");
				}
			if(request.getParameter("IMEI").trim().contains("71553949")){
				statement = connect.createStatement();	
				statement.execute("INSERT INTO bus3(lat,lng,IMEI) values('"+request.getParameter("lat").trim()+"','"+request.getParameter("lng").trim()+"','9003115833')");
				}
			
			}
				PrintWriter out = response.getWriter();
			out.println("lat:"+request.getParameter("lat").trim().toLowerCase()+"\n lan:"+request.getParameter("lng").trim().toLowerCase()+"\n IMEI "+request.getParameter("IMEI").trim().toLowerCase());
					
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		} finally {
			close();
		}
	}
	
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
try {
			
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/reachtoday?"
					+ "user=root&password=soft123");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			
//			resultSet = statement.executeQuery(Query);
			if(!(request.getParameter("lat").trim().equalsIgnoreCase("")||request.getParameter("lng").trim().equalsIgnoreCase("")||request.getParameter("IMEI").trim().equalsIgnoreCase("")))
			statement.execute("INSERT INTO test114(lat,lng,IMEI) values('"+request.getParameter("lat").trim()+"','"+request.getParameter("lng").trim()+"','"+request.getParameter("IMEI").trim()+"')");
			PrintWriter out = response.getWriter();
			out.println("lat:"+request.getParameter("lat").trim().toLowerCase()+"\n lan:"+request.getParameter("lng").trim().toLowerCase()+"\n IMEI "+request.getParameter("IMEI").trim().toLowerCase());
					
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		} finally {
			close();
		}
	}
	
	
	
	

}

package com.reachtoday.actions.vechicle;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Servlet implementation class SendNumber
 */

public class SendNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			System.out.println("in sendNumber>>>>"+request.getParameter("busNumber"));
			request.setAttribute("busNumber", request.getParameter("busNumber")+"&IMEI="+request.getParameter("IMEI"));
			getServletConfig().getServletContext().getRequestDispatcher("/test.jsp").forward(request,response);
			//are you clear till this point 
			
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

}

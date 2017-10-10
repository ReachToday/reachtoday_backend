package com.reachtoday.actions.users.friend;

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

import com.reachtoday.utils.DBUtils;

/**
 * Servlet implementation class Listusers
 */

public class Searchfriend extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Searchfriend() {
    super();
    // TODO Auto-generated constructor stub
  }

  DBUtils dbUtils;
  public ResultSet resultSet = null;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {

      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      // This will load the MySQL driver, each DB has its own driver
      dbUtils = new DBUtils();
      // Result set get the result of the SQL query
      JSONArray arr = new JSONArray();

      resultSet = dbUtils.executeQuery("select user_friends_isactive from user_friends where user_friends_email ='"
          + request.getParameter("email").trim().toLowerCase() + "' and user_friends_login_users_mail_id = '"
          + request.getParameter("currentloggedmail").trim().toLowerCase() + "'");

      while (resultSet.next()) {
        JSONObject test = new JSONObject();
        if (resultSet.getString("user_friends_isactive") != null) {
          test.put("user_friends_isactive", resultSet.getString("user_friends_isactive"));
          arr.put(test);

        }
      }
      out.print(arr);
      out.flush();

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

      if (dbUtils != null) {
        dbUtils.close();
        dbUtils = null;
      }

    } catch (Exception e) {

    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
  }

}

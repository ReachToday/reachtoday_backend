package com.reachtoday.actions.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

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

public class Searchuser extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Searchuser() {
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
      dbUtils = new DBUtils();
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      // Result set get the result of the SQL query
      JSONArray arr = new JSONArray();

      resultSet = dbUtils.executeQuery(
          "select login_users_username,login_users_mail_id,login_users_isactive from login_users where login_users_username LIKE '%"
              + request.getParameter("username").trim().toLowerCase() + "%' and login_users_mail_id <> '"
              + request.getParameter("currentloggedmail").trim().toLowerCase() + "'");

      while (resultSet.next()) {
        JSONObject test = new JSONObject();
        if (resultSet.getString("login_users_username") != null) {
          test.put("login_users_username", resultSet.getString("login_users_username"));
          test.put("login_users_mail_id", resultSet.getString("login_users_mail_id"));
          test.put("login_users_isactive", resultSet.getString("login_users_isactive"));
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

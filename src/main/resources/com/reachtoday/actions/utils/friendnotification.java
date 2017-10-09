package com.reachtoday.actions.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class Listusers
 */

public class friendnotification extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public friendnotification() {
    super();
    // TODO Auto-generated constructor stub
  }

  DBUtils dbUtils;
  public ResultSet resultSet = null;
  public ResultSet subresultSet = null;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {

      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      dbUtils = new DBUtils();

      // Result set get the result of the SQL query
      JSONArray arr = new JSONArray();

      resultSet = dbUtils.executeQuery(
          "select user_friends_login_users_mail_id,user_friends_isactive from user_friends where user_friends_email ='"
              + request.getParameter("currentloggedmail").trim().toLowerCase() + "'");

      while (resultSet.next()) {
        JSONObject test = new JSONObject();
        if (resultSet.getString("user_friends_isactive") != null) {
          if (resultSet.getString("user_friends_isactive").trim().equalsIgnoreCase("false")) {
            test.put("user_friends_isactive", resultSet.getString("user_friends_isactive"));
            test.put("user_friends_login_users_mail_id", resultSet.getString("user_friends_login_users_mail_id"));

            System.out.println("select login_users_username from login_users where  login_users_mail_id ="
                + resultSet.getString("user_friends_login_users_mail_id").trim().toLowerCase());
            subresultSet = dbUtils.executeQuery("select login_users_username from login_users where  login_users_mail_id = '"
                + resultSet.getString("user_friends_login_users_mail_id").trim().toLowerCase() + "'");

            if (subresultSet.next()) {
              test.put("user_friends_login_users_username", subresultSet.getString("login_users_username"));
            }
            arr.put(test);
          }
        }
      }
      System.out.println("arrya>>>>" + arr);
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
      if (subresultSet != null) {
        subresultSet.close();
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

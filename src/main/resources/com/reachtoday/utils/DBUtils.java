package com.reachtoday.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

  public Connection connect = null;
  public Statement statement = null;
  public ResultSet resultSet = null;

  public Boolean status = false;

  public DBUtils() throws ClassNotFoundException, SQLException {
    super();
    // This will load the MySQL driver, each DB has its own driver
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/reachtoday";
    String userName = "root";
    String password = "Welcome@123";
    // Setup the connection with the DB
    connect = DriverManager.getConnection(url, userName, password);
  }

  public ResultSet executeQuery(String query) {
    try {
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      resultSet = statement.executeQuery(query);
    } catch (SQLException E) {
      return null;
    } catch (Exception E) {
      return null;
    }
    return resultSet;
  }

  public Boolean executeinsert(String query) {
    try {
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      status = statement.execute(query);
    } catch (SQLException E) {
      return null;
    } catch (Exception E) {
      return null;
    }
    return status;
  }

  // You need to close the resultSet
  public void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
        resultSet = null;
      }

      if (statement != null) {
        statement.close();
        statement = null;
      }

      if (connect != null) {
        connect.close();
        connect = null;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

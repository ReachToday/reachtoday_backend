package com.reachtoday.actions.vechicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.reachtoday.utils.DBUtils;

public class LatLang {

  DBUtils dbUtils;
  private ResultSet resultSet = null;

  public JSONArray getlatlang(String Query) {
    try {

      dbUtils = new DBUtils();

      resultSet = dbUtils.executeQuery(Query);
      // resultSet = statement.executeQuery("select lat,lng from
      // "+request.getParameter("tablename").trim().toLowerCase()+" where id
      // in(1,2)");
      JSONArray arr = new JSONArray();

      while (resultSet.next()) {
        JSONObject test = new JSONObject();
        if (resultSet.getBigDecimal("lat") != null) {
          test.put("lat", resultSet.getBigDecimal("lat"));
        } else {
          test.put("lat", "");
        }

        if (resultSet.getBigDecimal("lng") != null) {
          test.put("lng", resultSet.getBigDecimal("lng"));
        } else {
          test.put("lng", "");
        }
        if (resultSet.getString("IMEI") != null) {
          test.put("IMEI", resultSet.getString("IMEI"));
        } else {
          test.put("IMEI", "");
        }
        if (resultSet.getBigDecimal("startlat") != null) {
          test.put("startlat", resultSet.getBigDecimal("startlat"));
        } else {
          test.put("startlat", "");
        }

        if (resultSet.getBigDecimal("startlng") != null) {
          test.put("startlng", resultSet.getBigDecimal("startlng"));
        } else {
          test.put("startlng", "");
        }
        if (resultSet.getBigDecimal("destlat") != null) {
          test.put("destlat", resultSet.getBigDecimal("destlat"));
        } else {
          test.put("destlat", "");
        }

        if (resultSet.getBigDecimal("destlng") != null) {
          test.put("destlng", resultSet.getBigDecimal("destlng"));
        } else {
          test.put("destlng", "");
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

      if (dbUtils != null) {
        dbUtils.close();
        dbUtils = null;
      }

    } catch (Exception e) {

    }
  }
}

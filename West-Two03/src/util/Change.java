package util;

/**
 * 完成增、删、改
 */

import JavaBean.City;
import JavaBean.Weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Change {

    /**
     * 添加城市基本数据
     */
    public void addCity(String id, double lat, double lon, String name) {
        String sql = "insert into city(id,lat,lon,name) value(?,?,?,?)";
        //该语句为每个 IN 参数保留一个问号（“？”）作为占位符
        Connection conn = null;                //和数据库取得连接
        PreparedStatement pstmt = null;        //创建statement
        try {
            conn = JDBCConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, lat);
            pstmt.setDouble(4, lon);
            pstmt.executeUpdate();            //执行
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.close(pstmt);
            JDBCConnection.close(conn);        //必须关闭
        }
    }

    /**
     * 添加天气基本数据
     */
    public void addWeather(String id, String fxDate, int tempMax, int tempMin, String textDay) {
        String sql = "insert into weather(id,fxDate,tempMax,tempMin,textDay) value(?,?,?,?,?)";
        //该语句为每个 IN 参数保留一个问号（“？”）作为占位符
        Connection conn = null;                //和数据库取得连接
        PreparedStatement pstmt = null;        //创建statement
        try {
            conn = JDBCConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, fxDate);
            pstmt.setInt(3, tempMax);
            pstmt.setInt(4, tempMin);
            pstmt.setString(5, textDay);
            pstmt.executeUpdate();            //执行
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.close(pstmt);
            JDBCConnection.close(conn);        //必须关闭
        }
    }

    /**
     * 根据id删city表
     *
     * @param id
     */
    public void deleteCity(String id) {
        String sql = "delete from city where id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCConnection.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.close(pstmt);
            JDBCConnection.close(conn);        //必须关闭
        }
    }

    /**
     * 根据id删weather表
     *
     * @param id
     */
    public void deleteWeather(String id) {
        String sql = "delete from weather where id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCConnection.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.close(pstmt);
            JDBCConnection.close(conn);        //必须关闭
        }
    }

    /**
     * 改weather
     *
     */
    public void updateWeather(int tempMax, int tempMin, String textDay, int id, String fxDate) {
        String sql = "update weather set tempMax=?,tempMin=?,textDay=? where (id=? and fxDate=?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCConnection.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, tempMax);
            pstmt.setInt(2, tempMin);
            pstmt.setString(3, textDay);
            pstmt.setInt(4, id);
            pstmt.setString(5, fxDate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.close(pstmt);
            JDBCConnection.close(conn);        //必须关闭
        }
    }
}

package util;

import JavaBean.City;
import JavaBean.Weather;

import java.sql.*;
import java.util.List;

public class JDBCConnection {

    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;

    /**
     * 取得数据库的连接
     *
     * @return 一个数据库的连接
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 我使用的数据库是MySQL，驱动是8.0.18，这是由于数据库和系统时区差异所造成的 这里可能需要调一个时差
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/west2?serverTimezone=GMT", "root", "155927");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    Change change = new Change();

    /**
     * 封装 增 删 改
     *
     * @param id
     * @param lat
     * @param lon
     * @param name
     */
    public void addCity(String id, double lat, double lon, String name) {
        change.addCity(id, lat, lon, name);
    }

    public void addWeather(String id, String fxDate, int tempMax, int tempMin, String textDay) {
        change.addWeather(id, fxDate, tempMax, tempMin, textDay);
    }

    public void deleteCity(String id) {
        change.deleteCity(id);
    }

    public void deleteWeather(String id) {
        change.deleteWeather(id);
    }

    public void updateWeather(int tempMax, int tempMin, String textDay, int id, String fxDate) {
        change.updateWeather(tempMax, tempMin, textDay, id, fxDate);
    }

    /**
     * 封装 查
     */
    Query query = new Query();

    public List<City> findCity(String name) {
        return query.findCity(name);
    }

    public List<Weather> findWeather(String id) {
        return query.findWeather(id);
    }

    /**
     * 封装三个关闭方法
     *
     * @param pstmt
     */
    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {                        //避免出现空指针异常
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

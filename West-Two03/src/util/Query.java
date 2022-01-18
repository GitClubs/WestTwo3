package util;

import JavaBean.City;
import JavaBean.Weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Query {

    //通过城市名称找城市
    public List<City> findCity(String name){
        String sql = "select * from city order by id";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //创建一个集合对象用来存放查询到的数据
        List<City> cityList = new ArrayList<>();
        try {
            conn = JDBCConnection.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()){
                String id = rs.getString("id");
                double lat = rs.getDouble("lat");
                double lon = rs.getDouble("lon");
                //每个记录对应一个对象
                City city = new City();
                city.setId(id);
                city.setName(name);
                city.setLat(lat);
                city.setLon(lon);
                //将对象放到集合中
                cityList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCConnection.close(pstmt);
            JDBCConnection.close(conn);		//必须关闭
        }
        return cityList;
    }

    //通过城市名称找城市
    public List<Weather> findWeather(String id){
        String sql = "select * from weather order by id";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //创建一个集合对象用来存放查询到的数据
        List<Weather> weatherList = new ArrayList<>();
        try {
            conn = JDBCConnection.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()){
//                String id = rs.getString("id");
                String fxDate = rs.getString("fxDate");
                int tempMax = rs.getInt("tempMax");
                int tempMin = rs.getInt("tempMin");
                String textDay = rs.getString("textDay");
                //每个记录对应一个对象
                Weather weather = new Weather();
                weather.setId(id);
                weather.setFxDate(fxDate);
                weather.setTempMax(tempMax);
                weather.setTempMin(tempMin);
                weather.setTextDay(textDay);
                //将对象放到集合中
                weatherList.add(weather);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCConnection.close(pstmt);
            JDBCConnection.close(conn);		//必须关闭
        }
        return weatherList;
    }
}

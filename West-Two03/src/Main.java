import util.JDBCConnection;
import util.UrlConnection;

public class Main {
    public static void main(String[] args) throws Exception {
        //这里手动输入网址 得到对应的城市和天气信息
        UrlConnection.insertCityInfo("https://geoapi.qweather.com/v2/city/lookup?key=33202ad1716841b9a6541d544b9d7e7c&location=%E7%A6%8F%E5%B7%9E");
        UrlConnection.insertWeatherInfo("https://devapi.qweather.com/v7/weather/3d?key=33202ad1716841b9a6541d544b9d7e7c&location=101230101","101230101");

        // 进行SQL操作
        JDBCConnection jdbcConnection = new JDBCConnection();
        jdbcConnection.addCity("101230101",119,26,"福州");
        System.out.println(jdbcConnection.findCity("福州"));
//        jdbcConnection.deleteCity("101230101");

        jdbcConnection.addWeather("101230101","2021-12-12",20,9,"晴");
        System.out.println(jdbcConnection.findWeather("101230101"));
//        jdbcConnection.deleteWeather("101230101");
    }
}
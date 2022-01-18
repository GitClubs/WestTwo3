package util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class UrlConnection {
    public static void main(String[] args) {

    }

    public static void insertCityInfo(String cityLink) throws Exception {
        java.net.URLConnection conn = null;
        JSONObject jsonObject;
        JSONObject jObject;
        JSONArray arr = null;
        try {
            // 通过网址利用IO流的方法将和风的数据传到IDE
            URL url = new URL(cityLink);
            conn = url.openConnection();
            InputStream in = conn.getInputStream();

            GZIPInputStream gzipInputStream = new GZIPInputStream(in);
            StringBuilder res = new StringBuilder();
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
            String str = res.toString();

            //将整个json字符串当做一个json对象
            jsonObject = JSONObject.parseObject(str);
            arr = jsonObject.getJSONArray("location");
            // 插入的SQL语句
            String insert = "insert into city(id,lat,lon,name) values ";
            res = new StringBuilder();
            res.append(insert);
            // 将jsonArray里的每一个对象单独分割，生成对应的插入语句
            for (int i = 0; i < arr.size(); i++) {
                jObject = arr.getJSONObject(i);
                String id = jObject.getString("id");
                Double lat = jObject.getDouble("lat");
                Double lon = jObject.getDouble("lon");
                String name = jObject.getString("name");
                res.append("(");
                res.append(id);
                res.append(",");
                res.append(lat);
                res.append(",");
                res.append(lon);
                res.append(",");
                res.append(name);
                // 当插入到最后一个元素的时候开始判断“(”情况
                if (i == arr.size() - 1) {
                    res.append(")");
                } else {
                    res.append("),");
                }
            }
            // 将StringBuilder转成String
            insert = res.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertWeatherInfo(String cityLink,String id) throws Exception {
        java.net.URLConnection conn = null;
        JSONObject jsonObject;
        JSONObject jObject;
        JSONArray arr = null;
        try {
            URL url = new URL(cityLink);
            conn = url.openConnection();
            InputStream in = conn.getInputStream();

            GZIPInputStream gzipInputStream = new GZIPInputStream(in);
            StringBuilder res = new StringBuilder();
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
            String str = res.toString();

            //将整个json字符串当做一个json对象
            jsonObject = JSONObject.parseObject(str);
            arr = jsonObject.getJSONArray("daily");
            String insert = "insert into weather(id,fxDate,tempMax,tempMin,textDay) values ";
            res = new StringBuilder();
            res.append(insert);
            for (int i = 0; i < arr.size(); i++) {
                jObject = arr.getJSONObject(i);
                String fxDate = jObject.getString("fxDate");
                double tempMax = jObject.getDouble("tempMax");
                double tempMin = jObject.getDouble("tempMin");
                String textDay = jObject.getString("textDay");
                res.append("(");
                res.append(id);
                res.append(",");
                res.append(fxDate);
                res.append(",");
                res.append(tempMax);
                res.append(",");
                res.append(tempMin);
                res.append(",");
                res.append(textDay);
                if (i == arr.size() - 1) {
                    res.append(")");
                } else {
                    res.append("),");
                }
            }
            insert = res.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package JavaBean;

/**
 * 创建City实体
 */
public class City {
    public String name;
    public String id;
    public double lat;
    public double lon;

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String toString() {
        return "City(name=" + this.getName() + ", id=" + this.getId() + ", latitude=" + this.getLat() + ", longitude=" + this.getLon() + ")";
    }

    public City() {
    }

    public City(String name, String id, double lat, double lon) {
        this.name = name;
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }
}


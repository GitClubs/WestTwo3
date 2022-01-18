package JavaBean;

/**
 * 创建Weather实体
 */
public class Weather {
    private String fxDate;
    private String id;
    private Integer tempMax;
    private Integer tempMin;
    private String textDay;

    public String getFxDate() {
        return this.fxDate;
    }

    public String getId() {
        return this.id;
    }

    public Integer getTempMax() {
        return this.tempMax;
    }

    public Integer getTempMin() {
        return this.tempMin;
    }

    public String getTextDay() {
        return this.textDay;
    }

    public void setFxDate(String fxDate) {
        this.fxDate = fxDate;
    }

    public void setId(String CityID) {
        this.id = CityID;
    }

    public void setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
    }

    public void setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    public String toString() {
        return "Weather(fxDate=" + this.getFxDate() + ", id=" + this.getId() + ", tempMax=" + this.getTempMax() + ", tempMin=" + this.getTempMin() + ", textDay=" + this.getTextDay() + ")";
    }

    public Weather() {
    }

    public Weather(String fxDate, String id, Integer tempMax, Integer tempMin, String textDay) {
        this.fxDate = fxDate;
        this.id = id;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.textDay = textDay;
    }
}


package soul.listener.com.humiture.model;

/**
 * @author kuan
 *         Created on 2017/11/14.
 * @description
 */

public class Temperature {
    String id;
    String residentId;
    String temperature;
    String humidity;
    String currentDate;
    String currentTime;
    String temperatureOut;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getTemperatureOut() {
        return temperatureOut;
    }

    public void setTemperatureOut(String temperatureOut) {
        this.temperatureOut = temperatureOut;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id='" + id + '\'' +
                ", residentId='" + residentId + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", currentDate='" + currentDate + '\'' +
                ", currentTime='" + currentTime + '\'' +
                ", temperatureOut='" + temperatureOut + '\'' +
                '}';
    }
}

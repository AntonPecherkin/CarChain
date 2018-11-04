package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CarModified {

    public CarModified(Car car, boolean isChained, String url){
        this.isChained = isChained;
        this.location = car.getLocation();
        this.manual = car.getManual();
        this.priceAllDays = car.getPriceAllDays();
        this.websiteId = car.getWebsiteId();
        this.vehicle = car.getVehicle();
        this.url = url;
    }

    public CarModified(){}

    private Double priceAllDays;

    public void setIsChained(boolean chained) {
        isChained = chained;
    }

    public boolean getIsChained() {

        return isChained;
    }

    private boolean isChained;

    public Double getPriceAllDays() {
        return priceAllDays;
    }

    public Boolean getManual() {
        return manual;
    }

    public String getWebsiteId() {
        return websiteId;
    }

    public String getVehicle() {
        return vehicle;
    }

    public Location getLocation() {
        return location;
    }

    private Boolean manual;

    private String websiteId;

    private String vehicle;

    private Location location;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public void setPriceAllDays(Double priceAllDays) {
        this.priceAllDays = priceAllDays;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

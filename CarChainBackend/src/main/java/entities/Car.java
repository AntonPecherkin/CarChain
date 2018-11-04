package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Car {

    @SerializedName("sipp")
    @Expose
    private String sipp;
    @SerializedName("image_id")
    @Expose
    private Integer imageId;
    @SerializedName("price_all_days")
    @Expose
    private Double priceAllDays;
    @SerializedName("seats")
    @Expose
    private Integer seats;
    @SerializedName("doors")
    @Expose
    private Integer doors;
    @SerializedName("bags")
    @Expose
    private Integer bags;
    @SerializedName("manual")
    @Expose
    private Boolean manual;
    @SerializedName("air_conditioning")
    @Expose
    private Boolean airConditioning;
    @SerializedName("mandatory_chauffeur")
    @Expose
    private Boolean mandatoryChauffeur;
    @SerializedName("website_id")
    @Expose
    private String websiteId;
    @SerializedName("vehicle")
    @Expose
    private String vehicle;
    @SerializedName("deeplink_url")
    @Expose
    private String deeplinkUrl;
    @SerializedName("car_class_id")
    @Expose
    private Integer carClassId;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("value_add")
    @Expose
    private ValueAdd valueAdd;

    public String getSipp() {
        return sipp;
    }

    public void setSipp(String sipp) {
        this.sipp = sipp;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Double getPriceAllDays() {
        return priceAllDays;
    }

    public void setPriceAllDays(Double priceAllDays) {
        this.priceAllDays = priceAllDays;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getBags() {
        return bags;
    }

    public void setBags(Integer bags) {
        this.bags = bags;
    }

    public Boolean getManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    public Boolean getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(Boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Boolean getMandatoryChauffeur() {
        return mandatoryChauffeur;
    }

    public void setMandatoryChauffeur(Boolean mandatoryChauffeur) {
        this.mandatoryChauffeur = mandatoryChauffeur;
    }

    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDeeplinkUrl() {
        return deeplinkUrl;
    }

    public void setDeeplinkUrl(String deeplinkUrl) {
        this.deeplinkUrl = deeplinkUrl;
    }

    public Integer getCarClassId() {
        return carClassId;
    }

    public void setCarClassId(Integer carClassId) {
        this.carClassId = carClassId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ValueAdd getValueAdd() {
        return valueAdd;
    }

    public void setValueAdd(ValueAdd valueAdd) {
        this.valueAdd = valueAdd;
    }
}

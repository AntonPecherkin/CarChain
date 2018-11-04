package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubmittedQuery {

    @SerializedName("market")
    @Expose
    private String market;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("pickup_place")
    @Expose
    private String pickupPlace;
    @SerializedName("dropoff_place")
    @Expose
    private String dropoffPlace;
    @SerializedName("pickup_date_time")
    @Expose
    private String pickupDateTime;
    @SerializedName("drop_off_date_time")
    @Expose
    private String dropOffDateTime;
    @SerializedName("driver_age")
    @Expose
    private String driverAge;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPickupPlace() {
        return pickupPlace;
    }

    public void setPickupPlace(String pickupPlace) {
        this.pickupPlace = pickupPlace;
    }

    public String getDropoffPlace() {
        return dropoffPlace;
    }

    public void setDropoffPlace(String dropoffPlace) {
        this.dropoffPlace = dropoffPlace;
    }

    public String getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(String pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public String getDropOffDateTime() {
        return dropOffDateTime;
    }

    public void setDropOffDateTime(String dropOffDateTime) {
        this.dropOffDateTime = dropOffDateTime;
    }

    public String getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(String driverAge) {
        this.driverAge = driverAge;
    }

}
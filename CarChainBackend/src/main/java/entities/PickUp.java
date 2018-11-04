package entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PickUp {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("distance_to_search_location_in_km")
    @Expose
    private Double distanceToSearchLocationInKm;
    @SerializedName("geo_info")
    @Expose
    private List<Double> geoInfo = null;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getDistanceToSearchLocationInKm() {
        return distanceToSearchLocationInKm;
    }

    public void setDistanceToSearchLocationInKm(Double distanceToSearchLocationInKm) {
        this.distanceToSearchLocationInKm = distanceToSearchLocationInKm;
    }

    public List<Double> getGeoInfo() {
        return geoInfo;
    }

    public void setGeoInfo(List<Double> geoInfo) {
        this.geoInfo = geoInfo;
    }

}
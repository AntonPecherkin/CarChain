package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IncludedMileage {

    @SerializedName("unlimited")
    @Expose
    private Boolean unlimited;

    public Boolean getUnlimited() {
        return unlimited;
    }

    public void setUnlimited(Boolean unlimited) {
        this.unlimited = unlimited;
    }

}
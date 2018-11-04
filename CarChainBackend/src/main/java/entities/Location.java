package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("pick_up")
    @Expose
    private PickUp pickUp;

    public PickUp getPickUp() {
        return pickUp;
    }

    public void setPickUp(PickUp pickUp) {
        this.pickUp = pickUp;
    }

}
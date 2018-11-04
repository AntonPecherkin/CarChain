package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Insurance {

    @SerializedName("theft_protection")
    @Expose
    private Boolean theftProtection;
    @SerializedName("third_party_cover")
    @Expose
    private Boolean thirdPartyCover;
    @SerializedName("free_collision_waiver")
    @Expose
    private Boolean freeCollisionWaiver;

    public Boolean getTheftProtection() {
        return theftProtection;
    }

    public void setTheftProtection(Boolean theftProtection) {
        this.theftProtection = theftProtection;
    }

    public Boolean getThirdPartyCover() {
        return thirdPartyCover;
    }

    public void setThirdPartyCover(Boolean thirdPartyCover) {
        this.thirdPartyCover = thirdPartyCover;
    }

    public Boolean getFreeCollisionWaiver() {
        return freeCollisionWaiver;
    }

    public void setFreeCollisionWaiver(Boolean freeCollisionWaiver) {
        this.freeCollisionWaiver = freeCollisionWaiver;
    }

}
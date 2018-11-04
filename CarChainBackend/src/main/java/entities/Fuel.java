package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fuel {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("policy")
    @Expose
    private String policy;
    @SerializedName("fair")
    @Expose
    private Boolean fair;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Boolean getFair() {
        return fair;
    }

    public void setFair(Boolean fair) {
        this.fair = fair;
    }

}
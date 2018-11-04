package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Website {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("in_progress")
    @Expose
    private Boolean inProgress;
    @SerializedName("optimised_for_mobile")
    @Expose
    private Boolean optimisedForMobile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Boolean getOptimisedForMobile() {
        return optimisedForMobile;
    }

    public void setOptimisedForMobile(Boolean optimisedForMobile) {
        this.optimisedForMobile = optimisedForMobile;
    }

}
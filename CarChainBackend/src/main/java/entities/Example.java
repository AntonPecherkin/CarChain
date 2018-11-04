package entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("submitted_query")
    @Expose
    private SubmittedQuery submittedQuery;
    @SerializedName("cars")
    @Expose
    private List<Car> cars = null;
    @SerializedName("websites")
    @Expose
    private List<Website> websites = null;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("car_classes")
    @Expose
    private List<CarClass> carClasses = null;

    public SubmittedQuery getSubmittedQuery() {
        return submittedQuery;
    }

    public void setSubmittedQuery(SubmittedQuery submittedQuery) {
        this.submittedQuery = submittedQuery;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Website> getWebsites() {
        return websites;
    }

    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<CarClass> getCarClasses() {
        return carClasses;
    }

    public void setCarClasses(List<CarClass> carClasses) {
        this.carClasses = carClasses;
    }

}
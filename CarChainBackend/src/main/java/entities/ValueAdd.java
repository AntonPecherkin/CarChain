package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValueAdd {

    @SerializedName("fuel")
    @Expose
    private Fuel fuel;
    @SerializedName("insurance")
    @Expose
    private Insurance insurance;
    @SerializedName("free_cancellation")
    @Expose
    private Boolean freeCancellation;
    @SerializedName("free_breakdown_assistance")
    @Expose
    private Boolean freeBreakdownAssistance;
    @SerializedName("additional_drivers")
    @Expose
    private AdditionalDrivers additionalDrivers;
    @SerializedName("included_mileage")
    @Expose
    private IncludedMileage includedMileage;

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Boolean getFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(Boolean freeCancellation) {
        this.freeCancellation = freeCancellation;
    }

    public Boolean getFreeBreakdownAssistance() {
        return freeBreakdownAssistance;
    }

    public void setFreeBreakdownAssistance(Boolean freeBreakdownAssistance) {
        this.freeBreakdownAssistance = freeBreakdownAssistance;
    }

    public AdditionalDrivers getAdditionalDrivers() {
        return additionalDrivers;
    }

    public void setAdditionalDrivers(AdditionalDrivers additionalDrivers) {
        this.additionalDrivers = additionalDrivers;
    }

    public IncludedMileage getIncludedMileage() {
        return includedMileage;
    }

    public void setIncludedMileage(IncludedMileage includedMileage) {
        this.includedMileage = includedMileage;
    }

}
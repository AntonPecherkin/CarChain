package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdditionalDrivers {

    @SerializedName("paid")
    @Expose
    private Paid paid;

    public Paid getPaid() {
        return paid;
    }

    public void setPaid(Paid paid) {
        this.paid = paid;
    }

}
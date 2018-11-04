package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paid {

    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("price")
    @Expose
    private Double price;

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}

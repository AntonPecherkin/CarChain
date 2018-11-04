package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarClass {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sort_order")
    @Expose
    private Integer sortOrder;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
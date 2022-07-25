package eeit45.group3.bakeyourlife.utils;

import eeit45.group3.bakeyourlife.order.utils.ProductSaleAmount;
import eeit45.group3.bakeyourlife.rental.utils.AvailableQuantity;

import java.util.ArrayList;
import java.util.List;

public class RentalChart {
    private List<String> labels = new ArrayList<>();

    private List<Long> data = new ArrayList<>();

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Long> getData() {
        return data;
    }

    public void setData(List<Long> data) {
        this.data = data;
    }


    public void addData(AvailableQuantity data) {
        if(data.getId() != null) {
            this.labels.add(data.getLabel() + "(" + data.getId() + ")");
        } else {
            this.labels.add(data.getLabel());
        }
        this.data.add(data.getValue());
    }


}

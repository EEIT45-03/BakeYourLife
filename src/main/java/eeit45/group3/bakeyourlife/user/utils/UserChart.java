package eeit45.group3.bakeyourlife.user.utils;


import java.util.ArrayList;
import java.util.List;

public class UserChart {
    private List<String> labels = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public void addData(UserQueryChart data) {
        this.labels.add(data.getLabel());
        this.data.add(data.getValue());
    }
}

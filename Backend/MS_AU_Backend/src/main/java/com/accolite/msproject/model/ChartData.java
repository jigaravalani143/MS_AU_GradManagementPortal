package com.accolite.msproject.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ChartData implements Serializable {
    //chartData retrieves the data and label to be plotted by chart
    //"chartData":{"label":"Graduates","data":[20,20,20,20,20]}

    String label;
    List<BigDecimal> data;

    public ChartData() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<BigDecimal> getData() {
        return data;
    }

    public void setData(List<BigDecimal> data) {
        this.data = data;
    }
}

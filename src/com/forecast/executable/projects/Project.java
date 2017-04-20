package com.forecast.executable.projects;

import com.forecast.lib.graph.DataPoint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zachary on 4/3/2017.
 */
public class Project implements Serializable {

    private ProjectStub stub;

    private List<DataPoint> dataPoints;

    public Project(final ProjectStub stub, final List<DataPoint> dataPoints) {
        this.stub = stub;
        this.dataPoints = dataPoints;
    }


    public Project(final ProjectStub stub) {
        this.stub = stub;
        this.dataPoints = new ArrayList<>();
    }

    public ProjectStub getStub() {
        return stub;
    }

    public List<DataPoint> getDataPoints() {
        return dataPoints;
    }
}

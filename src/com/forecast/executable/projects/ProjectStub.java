package edu.wit.sheltonz.forecast.projects;

import java.io.Serializable;

/**
 * Created by Zachary on 4/3/2017.
 */
public class ProjectStub implements Serializable {

    private String name;


    public ProjectStub(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

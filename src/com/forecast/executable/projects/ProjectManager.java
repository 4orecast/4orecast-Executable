package edu.wit.sheltonz.forecast.projects;

import edu.wit.sheltonz.forecast.Main;
import edu.wit.sheltonz.forecast.Util;

import java.io.File;
import java.io.IOException;

/**
 * Created by Zachary on 4/3/2017.
 */
public class ProjectManager {

    private Project currentProject;


    public Project loadProject(final File file) throws IOException, ClassNotFoundException {
        return Util.readObjFromFile(file, Project.class);
    }

    public void saveProject(final File file, final Project project) throws IOException {
        Util.saveObjToFile(file, project);
    }

    public void saveCurrentProject() throws IOException {
        this.saveProject(new File(Main.getProjectDir(), String.format("%s.proj", currentProject.getStub().getName())), currentProject);
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

}

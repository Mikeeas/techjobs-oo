package org.launchcode.models.forms;

import org.launchcode.models.CoreCompetency;
import org.launchcode.models.Employer;
import org.launchcode.models.Location;
import org.launchcode.models.PositionType;
import org.launchcode.models.data.JobData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobForm {



    @NotNull
    @Size(min = 1, message = "Name may not be empty")
    private String name;

    @NotNull
    private int employerId;

    @NotNull
    private int locationsId;

    @NotNull
    private int coreCompetenciesId;

    @NotNull
    private int positionTypesId;




    /*
        TODO #3 - Included other fields needed to create a job,
        with correct validation attributes and display names.
        Don't forget to add getters and setters
     */

    private ArrayList<Employer> employers;
    private ArrayList<Location> locations;
    private ArrayList<CoreCompetency> coreCompetencies;
    private ArrayList<PositionType> positionTypes;

    public JobForm() {

        JobData jobData = JobData.getInstance();

        /*
            TODO #4 - populate the other ArrayList collections needed in the view
        */

        employers = jobData.getEmployers().findAll();
        coreCompetencies = jobData.getCoreCompetencies().findAll();
        positionTypes = jobData.getPositionTypes().findAll();
        locations = jobData.getLocations().findAll();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public int getLocationsId() {
        return locationsId;
    }

    public void setLocationsId(int locationsId) {
        this.locationsId = locationsId;
    }

    public int getCoreCompetenciesId() {
        return coreCompetenciesId;
    }

    public void setCoreCompetenciesId(int coreCompetenciesId) {
        this.coreCompetenciesId = coreCompetenciesId;
    }

    public int getPositionTypesId() {
        return positionTypesId;
    }

    public void setPositionTypesId(int positionTypesId) {
        this.positionTypesId = positionTypesId;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public void setCoreCompetencies(ArrayList<CoreCompetency> coreCompetencies) {
        this.coreCompetencies = coreCompetencies;
    }

    public ArrayList<PositionType> getPositionTypes() {
        return positionTypes;
    }

    public void setPositionTypes(ArrayList<PositionType> positionTypes) {
        this.positionTypes = positionTypes;
    }

}

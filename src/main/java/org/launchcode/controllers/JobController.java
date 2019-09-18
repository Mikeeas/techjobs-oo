package org.launchcode.controllers;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.launchcode.models.*;
import org.launchcode.models.data.JobFieldData;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {
        // TODO #1 - get the Job with the given ID and pass it into the view

        Job job = jobData.findById(id);
        model.addAttribute("job", job );

        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("name", "Name may not be empty");
            return "new-job";
        }
            String aName = jobForm.getName();
            Employer aEmployer = jobData.getEmployers().findById(jobForm.getEmployerId());
            Location aLocation = jobData.getLocations().findById(jobForm.getLocationsId());
            PositionType aPositionType = jobData.getPositionTypes().findById(jobForm.getPositionTypesId());
            CoreCompetency aSkill = jobData.getCoreCompetencies().findById(jobForm.getCoreCompetenciesId());
            Job newJob = new Job(aName, aEmployer, aLocation, aPositionType, aSkill);
            jobData.add(newJob);
            model.addAttribute("job", newJob);
            // TODO #6 - Validate the JobForm model, and if valid, create a
            // new Job and add it to the jobData data store. Then
            // redirect to the job detail view for the new Job.

            return "job-detail";
        }

}

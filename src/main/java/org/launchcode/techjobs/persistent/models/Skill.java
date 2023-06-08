package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    private String description;

    public Skill () {}

//    In your Skill class, add a jobs field.
//    >What type should this field be? Initialize it in the field declaration accordingly.
//    >Add a getter and setter for the field.
//    >This field has a many-to-many type relationship with skills.
//    You’ll need to add the @ManyToMany annotation with an argument mappedBy="skills" to configure this mapping.

    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }



}
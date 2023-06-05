package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Job extends AbstractEntity{

//    >Since the Job model class has id and name fields, it too can inherit from AbstractEntity.
//    >Update the class definition of Job to extend AbstractEntity. Remove the redundant fields from Job

//    >Replace the type of the field employer to be of type Employer.
//    You will also need to refactor the affected constructor and getter and setter that use this field.
//    >Add the @ManyToOne annotation on the field employer

    @ManyToOne
    private Employer employer;

    private String skills;

    public Job() {
    }

    public Job(Employer anEmployer, String someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    // Getters and setters.


    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}

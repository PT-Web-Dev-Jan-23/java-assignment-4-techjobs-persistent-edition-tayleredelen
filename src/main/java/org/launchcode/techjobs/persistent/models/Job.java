package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

//    Update your Job model class to fit its many-to-many relationship with skills.
//    Job.skills already exists. What needs to change and/or be added to map this relationship?
//    Be sure to check the whole class for any necessary type updates. (update type to Skill)

    @ManyToMany
    private List<Skill> skills = new ArrayList<>();

    public Job() {
    }

    public Job(Employer anEmployer, List<Skill> someSkills) {
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

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}

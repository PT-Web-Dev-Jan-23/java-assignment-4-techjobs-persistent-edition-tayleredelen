package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

//    >Within Employer, add a private property jobs of type List<Job> and initialize it to
//    an empty ArrayList. After we set up the Job class to work with Employer objects,
//    this list will represent the list of all items in a given job. We’ll do this in a bit.

//    >Use the @OneToMany and @JoinColumn annotations on the jobs list in Employer to
//    declare the relationship between data tables. Recall that this annotation needs a
//    name parameter. What should its value be?

    @OneToMany
    @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();


    @NotNull(message = "Location is required")
    @Size(min = 3, max = 50, message = "Location must be between 3 and 50 characters")
    private String location;

    public Employer () {}
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}

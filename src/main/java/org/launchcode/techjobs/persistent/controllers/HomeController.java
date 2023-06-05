package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

//    Add a field employerRepository annotated with @Autowired.

    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "My Jobs");
        return "index";
    }


//    Add the employer data from employerRepository into the form template.
//    The add job form already includes an employer selection option.
//    Be sure your variable name for the employer data matches that already used in templates/add.
    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute("job", new Job());
        model.addAttribute("employer", employerRepository);
        return "add";
    }


//    In processAddJobForm, add code inside of this method to select the employer object that has been chosen
//    to be affiliated with the new job. You will need to select the employer using the request parameter you’ve
//    added to the method.

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            model.addAttribute(new Job());
            model.addAttribute("employers", employerRepository.findAll());
            model.addAttribute("skills", skillRepository.findAll());
            return "add"; //if validation errors submit in form returns to add view
        }
//        Employer employer = employerRepository.findById(employerId).orElse(null);
        newJob.setEmployer(employerRepository.findById(employerId).orElse(null));
        newJob.setSkills(String.valueOf(skills));
        jobRepository.save(newJob);
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        return "view";
    }


}

package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
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

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {
//        @RequestParam int employerId, @RequestParam List<Integer> skills
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            model.addAttribute("employers", employerRepository.findAll());
            model.addAttribute("skills", skillRepository.findAll());
            return "add";
        }
        Optional<Employer> employerToSet = employerRepository.findById(employerId);
        if (employerToSet.isPresent()) {
            newJob.setEmployer(employerToSet.get());
            // get the employer out of the optional with the dot get
            jobRepository.save(newJob);
        }
//        jobRepository.save(newJob);
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        return "view";
    }


}






///**
// * Created by LaunchCode
// */
//@Controller
//public class HomeController {
//
//    @Autowired
//    private JobRepository jobRepository;
//
//    @Autowired
//    private EmployerRepository employerRepository;
//
//    @Autowired
//    private SkillRepository skillRepository;
//
//    @RequestMapping("")
//    public String index(Model model) {
//
//        model.addAttribute("title", "My Jobs");
//
//        return "index";
//    }
//
//    @GetMapping("add")
//    public String displayAddJobForm(Model model) {
//        // EmployerRepository employerRepository taken out of constructor
//        model.addAttribute("title", "Add Job");
//        model.addAttribute("employers", employerRepository.findAll());
//        model.addAttribute("skills", skillRepository.findAll());
//        model.addAttribute(new Job());
//        return "add";
//    }
//
//    @PostMapping("add")
//    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
//                                       Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {
//// currently not adding EmployerRepository employerRepository in the constructor we'll see if that's right
//       // I removed this from the constructor @RequestParam List<Integer> skills
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Job");
//            model.addAttribute("employers", employerRepository.findAll());
//            model.addAttribute("skills", skillRepository.findAll());
//            return "add";
//        }
//
////        newJob.setEmployer(employerRepository.findById(employerId));
////        Employer employerToUpdate = employerRepository.findById(employerId);
////        employerToUpdate.addJob(newJob);
////        employerRepository.findById(employerId).addJob(newJob);
//
//        jobRepository.save(newJob);
//        return "redirect:";
//    }
//
//    @GetMapping("view/{jobId}")
//    public String displayViewJob(Model model, @PathVariable int jobId) {
//
//        return "view";
//    }
//
//
//}

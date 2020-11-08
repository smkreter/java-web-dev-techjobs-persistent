package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Entity
public class Job extends AbstractEntity {

//    @Id
//    @GeneratedValue
//    private int id;
//
//    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Employer is required")
    private Employer employer;

    //should it be skills or skill? is this maybe the persistence problem
//    private Skill skills;

    @ManyToOne(cascade = CascadeType.ALL)
//    @NotNull(message = "choose a skill")
    private Skill skills;

    public Job() {
    }

    public Job(Employer anEmployer, Skill someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
        // ??       this.skills = someSkills;
    }

//    public Job(Employer anEmployer) {
//        super();
//        this.employer = anEmployer;
////        this.skills = someSkills;
//        // ??       this.skills = someSkills;
//    }

    // Getters and setters.
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Skill getSkills() {
        return skills;
    }

    public void setSkills(Skill skills) {
        this.skills = skills;
    }
}


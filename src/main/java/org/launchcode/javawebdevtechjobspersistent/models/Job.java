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
    private Employer employer;

    //should it be skills or skill? is this maybe the persistence problem
//    private Skill skills;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Skill> skills;

    public Job() {
    }

    public Job(Employer employer, List<Skill> someSkills) {
        super();
        this.employer = employer;
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

    public List<Skill> getSkills() {
        return skills;
    }

//    public List<Skill> getSkills() {
//
//    }
//    public void setSkill(Skill skill) {
//        this.skills.add(skill);
//    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}


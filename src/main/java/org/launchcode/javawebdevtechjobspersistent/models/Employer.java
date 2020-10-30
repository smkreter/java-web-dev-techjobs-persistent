package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    @Size(max = 255, message = "The length of the name of the location must be under 255 characters")
    private String location;

    public Employer (String location) {
//        this.name = name;
        this.location = location;
    }

    public Employer() {}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

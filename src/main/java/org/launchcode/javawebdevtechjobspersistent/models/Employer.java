package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
    @Valid
    @NotBlank(message = "Location is required")
    @Size(max=100, message="Location can be no longer than 100 characters")
    private String location;

    public Employer(String l) {
        this.location = l;
    }
    public Employer() {}

    @OneToMany
    @JoinColumn
    private final List<Job> jobs = new ArrayList<>();
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}

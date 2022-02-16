package de.neuefische.Repos;

import org.springframework.stereotype.Repository;

@Repository
public class Repo {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

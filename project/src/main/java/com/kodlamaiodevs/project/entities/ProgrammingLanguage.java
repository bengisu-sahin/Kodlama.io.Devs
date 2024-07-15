package com.kodlamaiodevs.project.entities;

public class ProgrammingLanguage {

    private int id;
    private String name;

    public ProgrammingLanguage(int id,String name) {
        this.name = name;
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }
}

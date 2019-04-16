package com.example.uidesign;

//This class helps to add new subjects to the list

public class Subject {

    int image;
    String name, progress;

    public Subject(int image, String name, String team) {
        this.image = image;
        this.name = name;
        this.progress = team;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }
}

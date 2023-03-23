package com.example.ratemystudyspace;

/**
 * This class represents StudySpaceFragment in code
 */
public class StudySpaceModel {

    private String name;
    private String location;
    private float rating;

    private int imageMain;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getImageMain() {
        return imageMain;
    }

    public void setImageMain(int imageMain) {
        this.imageMain = imageMain;
    }

    public float getRating() {
        return rating;
    }

    public StudySpaceModel(String name, String location, float rating, int imageMain){
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.imageMain = imageMain;
    }



}

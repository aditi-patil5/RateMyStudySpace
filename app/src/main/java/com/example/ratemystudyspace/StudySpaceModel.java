package com.example.ratemystudyspace;

import java.util.ArrayList;

/**
 * This class represents StudySpaceFragment in code
 */
public class StudySpaceModel {

    private String name;
    private String location;
    private float rating;

    private int imageMain;

    private  ArrayList<String> reviews = new ArrayList<String>();

    private boolean naturalLight;
    private boolean outlets;
    private boolean whiteboards;
    private boolean isIndividual;
    private boolean isQuiet;
    private boolean isMedium;

    private boolean isLoud;

    private boolean hasWhiteboard;
    private boolean hasOutlets;
    private boolean hasNaturalLight;

    public StudySpaceModel(String name, String location, float rating, int imageMain,
                           ArrayList<String> reviews, boolean isLoud, boolean isMedium, boolean isQuiet,
                           boolean isIndividual, boolean hasNaturalLight, boolean hasWhiteboard,
                           boolean hasOutlets){
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.imageMain = imageMain;
        this.reviews = reviews;
        this.isLoud = isLoud;
        this.isMedium = isMedium;
        this.isQuiet = isQuiet;
        this.isIndividual = isIndividual;
        this.hasWhiteboard = hasWhiteboard;
        this.hasNaturalLight = hasNaturalLight;
        this.hasOutlets = hasOutlets;
    }

    public boolean isQuiet() {
        return isQuiet;
    }

    public boolean isMedium() {
        return isMedium;
    }

    public boolean isLoud() {
        return isLoud;
    }

    public boolean isNaturalLight() {
        return naturalLight;
    }

    public void setNaturalLight(boolean naturalLight) {
        this.naturalLight = naturalLight;
    }

    public boolean isOutlets() {
        return outlets;
    }

    public void setOutlets(boolean outlets) {
        this.outlets = outlets;
    }

    public boolean isWhiteboards() {
        return whiteboards;
    }

    public void setWhiteboards(boolean whiteboards) {
        this.whiteboards = whiteboards;
    }

    public boolean isIndividual() {
        return isIndividual;
    }

    public void setIndividual(boolean individual) {
        isIndividual = individual;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
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

    public void addReview(String review){
        reviews.add(review);
    }

    public String getReviewsString(){
        StringBuilder strReview = new StringBuilder("");
        for(int i = 0; i<reviews.size(); i++){
            strReview.append(reviews.get(i));
            if(i != reviews.size()-1){
                strReview.append(";");
            }
        }
        return strReview.toString();
    }

}

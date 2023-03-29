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
    private String noiseLevel;

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

    public String getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(String noiseLevel) {
        this.noiseLevel = noiseLevel;
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

    public StudySpaceModel(String name, String location, float rating, int imageMain, ArrayList<String> reviews){
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.imageMain = imageMain;
        this.reviews = reviews;
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

package com.example.licio.moringaeats.models;

import java.util.ArrayList;

public class Recipe {
    private String mRecipeName;
    private String mImageUrl;
    private String mCourse;
    private String mRating;
    private ArrayList<String> mIngredients = new ArrayList<>();

    public Recipe(String recipeName,String smallImageUrls, String course, ArrayList<String> ingredients, String rating){
        this.mRecipeName = recipeName;
        this.mImageUrl = smallImageUrls;
        this.mCourse = course;
        this.mIngredients = ingredients;
        this.mRating = rating;
    }

    public String getmRecipeName() {
        return mRecipeName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCourse() {
        return mCourse;
    }

    public ArrayList<String> getmIngredients() {
        return mIngredients;
    }
    public  String getmRating(){
        return mRating;
    }
}

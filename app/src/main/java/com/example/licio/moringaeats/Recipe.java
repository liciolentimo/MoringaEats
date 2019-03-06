package com.example.licio.moringaeats;

import java.util.ArrayList;

public class Recipe {
    private String mRecipeName;
    private String mImageUrl;
    private String mCourse;
    private ArrayList<String> mIngredients = new ArrayList<>();

    public Recipe(String recipeName,String smallImageUrls, String course, ArrayList<String> ingredients){
        this.mRecipeName = recipeName;
        this.mImageUrl = smallImageUrls;
        this.mCourse = course;
        this.mIngredients = ingredients;
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
}

package com.example.licio.moringaeats.services;

import com.example.licio.moringaeats.Constants;
import com.example.licio.moringaeats.models.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class YummlyService {
    public static void findRecipes(String ingredients, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YUMMLY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YUMMLY_INGREDIENT_QUERY_PARAMETER, ingredients);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", Constants.YUMMLY_TOKEN)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Recipe> processResults(Response response) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject yummlyJSON = new JSONObject(jsonData);
            JSONArray recipesJSON = yummlyJSON.getJSONArray("recipes");
            if (response.isSuccessful()) {
                for (int i = 0; i < recipesJSON.length(); i++) {
                    JSONObject recipeJSON = recipesJSON.getJSONObject(i);
                    String recipeName = recipeJSON.getString("recipeName");
                    String smallImageUrls = recipeJSON.getString("smallImageUrls");
                    String course = recipeJSON.getString("course");
                    String rating = recipeJSON.getString("rating");
                    ArrayList<String> ingredients = new ArrayList<>();
                    JSONArray ingredientsJSON = recipeJSON.getJSONObject("ingredients").getJSONArray("ingredients");
                    for (int y = 0; y < ingredientsJSON.length(); y++) {
                        ingredients.add(ingredientsJSON.get(y).toString());
                    }
                    Recipe recipe = new Recipe(recipeName, smallImageUrls, course, ingredients,rating);
                    recipes.add(recipe);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recipes;
    }
}

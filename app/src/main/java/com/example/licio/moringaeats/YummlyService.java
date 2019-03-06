package com.example.licio.moringaeats;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class YummlyService {
    public static void findRecipes(String ingredients, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YUMMLY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YUMMLY_INGREDIENT_QUERY_PARAMETER,ingredients);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", Constants.YUMMLY_TOKEN)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}

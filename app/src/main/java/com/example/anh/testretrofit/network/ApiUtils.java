package com.example.anh.testretrofit.network;

/**
 * Created by anh on 31/08/2017.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://api.github.com";

    public static ApiInterface getApiInterface() {
        return RetrofitClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}
package com.example.anh.testretrofit.network;

import com.example.anh.testretrofit.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by anh on 31/08/2017.
 */

public interface ApiInterface {
    @GET("/users/{username}/followers")
    Call<ArrayList<User>> getListUserfollowers(@Path("username") String username);
}

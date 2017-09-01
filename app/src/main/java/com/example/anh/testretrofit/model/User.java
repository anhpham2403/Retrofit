package com.example.anh.testretrofit.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anh on 31/08/2017.
 */

public class User {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("avatar_url")
    @Expose
    private String avatarURL;
    @SerializedName("login")
    @Expose
    private String username;
    public User() {
    }

    public User(long id, String avatarURL, String username) {
        this.id = id;
        this.avatarURL = avatarURL;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

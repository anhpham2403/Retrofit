package com.example.anh.testretrofit.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anh.testretrofit.network.ApiUtils;
import com.example.anh.testretrofit.R;
import com.example.anh.testretrofit.adapter.UserAdapter;
import com.example.anh.testretrofit.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    static final String MY_USERNAME = "mobilesiri";
    private ArrayList<User> users;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private TextView myUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        myUserName = (TextView)findViewById(R.id.my_username);
        users = new ArrayList<>();
        getUserFollower();
        userAdapter = new UserAdapter(MainActivity.this, users);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);
        myUserName.setText("List followers of "+MY_USERNAME);
    }

    private void getUserFollower() {
        Call<ArrayList<User>> call = ApiUtils.getApiInterface().getListUserfollowers(MY_USERNAME);
        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                users = response.body();
                userAdapter.updateUser(users);
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Can't get User list", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

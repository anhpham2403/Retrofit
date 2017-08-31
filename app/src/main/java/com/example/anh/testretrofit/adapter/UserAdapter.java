package com.example.anh.testretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anh.testretrofit.R;
import com.example.anh.testretrofit.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by anh on 31/08/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<User> mUsers;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.mContext = context;
        this.mUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View postView = inflater.inflate(R.layout.item_user, parent, false);
        ViewHolder viewHolder = new ViewHolder(postView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.username.setText("Name : " + user.getUsername());
        holder.id.setText("Id : " + String.valueOf(user.getId()));
        Picasso.with(mContext).load(user.getAvatarURL()).resize(100, 100).centerCrop().into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView username;
        public TextView id;
        public ImageView avatar;
        public ViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.username);
            id = (TextView) itemView.findViewById(R.id.id);
            avatar = (ImageView) itemView.findViewById(R.id.avatar);
        }
    }

    public void updateUser(ArrayList<User> users) {
        mUsers = users;
        notifyDataSetChanged();
    }
}

package com.earnsmart.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class MyAadapter extends FirebaseRecyclerAdapter<Team,MyAadapter.MyViewHolder> {
    public MyAadapter(@NonNull FirebaseRecyclerOptions<Team>options) {
        super(options);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, Team Team) {
        holder.name.setText(Team.getName());
        holder.position.setText(Team.getPosition());
        holder.refer.setText(Team.getRefer());
        holder.rank.setText(Team.getRank());
        holder.username.setText(Team.username);

    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, position, refer, rank, username;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tcname);
            position=itemView.findViewById(R.id.tcposition);
            refer=itemView.findViewById(R.id.tcrefer);
            rank=itemView.findViewById(R.id.tcrank);
            username=itemView.findViewById(R.id.tcparent);

        }
    }
}

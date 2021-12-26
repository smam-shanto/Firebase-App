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

public class MyAaadapter extends RecyclerView.Adapter<MyAaadapter.MyViewHolder> {

    Context context;
    ArrayList<Withdraw>list;

    public MyAaadapter(Context context, ArrayList<Withdraw> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Withdraw withdraw=list.get(position);
        holder.username.setText(withdraw.getUsername());
        holder.account.setText(withdraw.getAccount());
        holder.amount.setText(withdraw.getAmount());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }






    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView username, account, amount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.hisname);
            account=itemView.findViewById(R.id.hisaccount);
            amount=itemView.findViewById(R.id.hisamount);
        }
    }
}

package com.earnsmart.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myviewholder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView t1;
    Button advbtn;
    @SuppressLint("ResourceAsColor")
    public myviewholder(@NonNull View itemView)
    {
        super(itemView);
        img=(ImageView)itemView.findViewById(R.id.img1);
        t1=(TextView)itemView.findViewById(R.id.t1);
        advbtn=(Button) itemView.findViewById(R.id.advbtn);

    }
}

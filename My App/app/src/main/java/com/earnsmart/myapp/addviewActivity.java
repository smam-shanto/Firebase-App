package com.earnsmart.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

public class addviewActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    RecyclerView rcv;
    myadapter adapter;
    Button advbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addview);


        rcv = (RecyclerView) findViewById(R.id.recview);
        //  rcv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new myadapter(dataqueue(),getApplicationContext());
        rcv.setAdapter(adapter);

        //LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //rcv.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        rcv.setLayoutManager(gridLayoutManager);

    }

    public ArrayList<Model> dataqueue()
    {
        ArrayList<Model> holder=new ArrayList<>();

        Model ob1=new Model();
        ob1.setHeader("C Programming");
        ob1.setImgname(R.drawable.abcgroup);
        holder.add(ob1);

        Model ob2=new Model();
        ob2.setHeader("C++ Programming");
        ob2.setImgname(R.drawable.abcgroup);
        holder.add(ob2);

        Model ob3=new Model();
        ob3.setHeader("Java Programming");
        ob3.setImgname(R.drawable.abcgroup);
        holder.add(ob3);

        Model ob4=new Model();
        ob4.setHeader("PHP Programming");
        ob4.setImgname(R.drawable.abcgroup);
        holder.add(ob4);

        Model ob5=new Model();
        ob5.setHeader(".NET Programming");
        ob5.setImgname(R.drawable.abcgroup);
        holder.add(ob5);

        Model ob6=new Model();
        ob6.setHeader("Wordpress Framework");
        ob6.setImgname(R.drawable.abcgroup);
        holder.add(ob6);

        Model ob7=new Model();
        ob7.setHeader("Magento Framework");
        ob7.setImgname(R.drawable.abcgroup);
        holder.add(ob7);

        Model ob8=new Model();
        ob8.setHeader("Shopify Framework");
        ob8.setImgname(R.drawable.abcgroup);
        holder.add(ob8);

        Model ob9=new Model();
        ob9.setHeader("Angular Programming");
        ob9.setImgname(R.drawable.abcgroup);
        holder.add(ob9);

        Model ob10=new Model();
        ob10.setHeader("Python Programming");
        ob10.setImgname(R.drawable.abcgroup);
        holder.add(ob10);

        Model ob11=new Model();
        ob11.setHeader("Node JS Programming");
        ob11.setImgname(R.drawable.abcgroup);
        holder.add(ob11);



        return holder;
    }


    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu2);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        //
        if (id == R.id.item1) {
            Intent intent = new Intent(addviewActivity.this, proActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(addviewActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent intent = new Intent(addviewActivity.this, withdrawActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item4) {
            Intent intent = new Intent(addviewActivity.this, teamActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item5) {
            Intent intent = new Intent(addviewActivity.this, supportActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item6) {
            Intent intent = new Intent(addviewActivity.this, historyActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item7) {
            Intent intent = new Intent(addviewActivity.this, fundActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item8) {
            Intent intent = new Intent(addviewActivity.this, adduserActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }
}

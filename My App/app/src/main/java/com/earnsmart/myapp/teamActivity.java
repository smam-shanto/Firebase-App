package com.earnsmart.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class teamActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase rootNode;
    MyAadapter myAadapter;
    ArrayList<TeamChild> list;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        SearchView searchView=findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        recyclerView=findViewById(R.id.team);
        FirebaseRecyclerOptions<Team> options =
                new FirebaseRecyclerOptions.Builder<Team>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Team"), Team.class)
                        .build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAadapter=new MyAadapter(options);
        recyclerView.setAdapter(myAadapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        myAadapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAadapter.stopListening();
    }

    private void processsearch(String s) {
        FirebaseRecyclerOptions<Team> options =
                new FirebaseRecyclerOptions.Builder<Team>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Team").orderByChild("username").startAt(s).endAt(s+"\uf8ff"), Team.class)
                        .build();
        myAadapter=new MyAadapter(options);
        recyclerView.setAdapter(myAadapter);
        myAadapter.startListening();

    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu4);
        popup.inflate(R.menu.searchmenu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        //
        if (id == R.id.item1) {
            Intent intent = new Intent(teamActivity.this, proActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(teamActivity.this, addviewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent intent = new Intent(teamActivity.this, withdrawActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item4) {
            Intent intent = new Intent(teamActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item5) {
            Intent intent = new Intent(teamActivity.this, supportActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item6) {
            Intent intent = new Intent(teamActivity.this, historyActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item7) {
            Intent intent = new Intent(teamActivity.this, fundActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item8) {
            Intent intent = new Intent(teamActivity.this, adduserActivity.class);
            startActivity(intent);
            return true;
        }


        return false;
    }
}

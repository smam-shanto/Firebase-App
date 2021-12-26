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
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class historyActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase rootNode;
    TextView thname, thusername, thpassword;
    MyAaadapter myAaadapter;
    ArrayList<Withdraw>list;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);



        recyclerView=findViewById(R.id.rhistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference("Withdraw").child("Bkash");
        list=new ArrayList<>();
        myAaadapter=new MyAaadapter(this,list);
        recyclerView.setAdapter(myAaadapter);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot db:snapshot.getChildren()){
                    Withdraw withdraw=db.getValue(Withdraw.class);
                    list.add(withdraw);
                }
                myAaadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reference=rootNode.getReference("Withdraw").child("Rocket");
        list=new ArrayList<>();
        myAaadapter=new MyAaadapter(this,list);
        recyclerView.setAdapter(myAaadapter);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot db:snapshot.getChildren()){
                    Withdraw withdraw=db.getValue(Withdraw.class);
                    list.add(withdraw);
                }
                myAaadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reference=rootNode.getReference("Withdraw").child("Nagad");
        list=new ArrayList<>();
        myAaadapter=new MyAaadapter(this,list);
        recyclerView.setAdapter(myAaadapter);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot db:snapshot.getChildren()){
                    Withdraw withdraw=db.getValue(Withdraw.class);
                    list.add(withdraw);
                }
                myAaadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu6);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        //
        if (id == R.id.item1) {
            Intent intent = new Intent(historyActivity.this, proActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(historyActivity.this, addviewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent intent = new Intent(historyActivity.this, withdrawActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item4) {
            Intent intent = new Intent(historyActivity.this, teamActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item5) {
            Intent intent = new Intent(historyActivity.this, supportActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item6) {
            Intent intent = new Intent(historyActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item7) {
            Intent intent = new Intent(historyActivity.this, fundActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item8) {
            Intent intent = new Intent(historyActivity.this, adduserActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }
}

package com.earnsmart.myapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class proActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    Button pupbtn, showbtn, advbtn;
    TextView tpname, tpusername, tppassword, tprefer, tprank;
    EditText username;
    DatabaseReference reference;
    FirebaseAuth auth;
    FirebaseDatabase database;
    public static String pre_name="mypre";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro);
        tpname=findViewById(R.id.pname);
        tpusername=findViewById(R.id.pusername);
        tppassword=findViewById(R.id.ppassword);
        tprefer=findViewById(R.id.tprefer);
        tprank=findViewById(R.id.tprank);
        reference=FirebaseDatabase.getInstance().getReference().child("Team").child("sadik11");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("name").getValue().toString();
                String username=snapshot.child("username").getValue().toString();
                String password=snapshot.child("password").getValue().toString();
                String refer=snapshot.child("refer").getValue().toString();
                String rank=snapshot.child("rank").getValue().toString();
                tpname.setText(name);
                tpusername.setText(username);
                tppassword.setText(password);
                tprefer.setText(refer);
                tprank.setText(rank);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        }




    public void LogOut(View view){
        switch (view.getId()){
            case R.id.plobtn: FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(proActivity.this,loginActivity.class));
                finish();
                break;
        }
    }




    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu1);
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        //
        if (id == R.id.item1) {
            Intent intent = new Intent(proActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(proActivity.this, addviewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent intent = new Intent(proActivity.this, withdrawActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item4) {
            Intent intent = new Intent(proActivity.this, teamActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item5) {
            Intent intent = new Intent(proActivity.this, supportActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item6) {
            Intent intent = new Intent(proActivity.this, historyActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item7) {
            Intent intent = new Intent(proActivity.this, fundActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item8) {
            Intent intent = new Intent(proActivity.this, adduserActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}

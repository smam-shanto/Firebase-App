package com.earnsmart.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class withdrawActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    Button bkash, nagad, rocket, withbtn;
    EditText wusername, waccount, wamount;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        wusername=findViewById(R.id.wusername);
        waccount=findViewById(R.id.waccount);
        wamount=findViewById(R.id.wamount);
        bkash=findViewById(R.id.bkash);
        nagad=findViewById(R.id.nagad);
        rocket=findViewById(R.id.rocket);
        withbtn=findViewById(R.id.withbtn);
        bkash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Withdraw").child("Bkash");
                bkash.setBackgroundColor(getResources().getColor(R.color.selected));
                nagad.setBackgroundColor(getResources().getColor(R.color.nonselected));
                rocket.setBackgroundColor(getResources().getColor(R.color.nonselected));
                startActivity(new Intent(withdrawActivity.this,withdrawbActivity.class));
            }
        });
        nagad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Withdraw").child("Nagad");
                bkash.setBackgroundColor(getResources().getColor(R.color.nonselected));
                nagad.setBackgroundColor(getResources().getColor(R.color.selected));
                rocket.setBackgroundColor(getResources().getColor(R.color.nonselected));
                startActivity(new Intent(withdrawActivity.this,withdrawnActivity.class));
            }
        });
        rocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Withdraw").child("Rocket");
                bkash.setBackgroundColor(getResources().getColor(R.color.nonselected));
                nagad.setBackgroundColor(getResources().getColor(R.color.nonselected));
                rocket.setBackgroundColor(getResources().getColor(R.color.selected));
                startActivity(new Intent(withdrawActivity.this,withdrawrActivity.class));
            }
        });


    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu3);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        //
        if (id == R.id.item1) {
            Intent intent = new Intent(withdrawActivity.this, proActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(withdrawActivity.this, addviewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent intent = new Intent(withdrawActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item4) {
            Intent intent = new Intent(withdrawActivity.this, teamActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item5) {
            Intent intent = new Intent(withdrawActivity.this, supportActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item6) {
            Intent intent = new Intent(withdrawActivity.this, historyActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item7) {
            Intent intent = new Intent(withdrawActivity.this, fundActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item8) {
            Intent intent = new Intent(withdrawActivity.this, adduserActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }
}

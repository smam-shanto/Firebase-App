package com.earnsmart.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class adduserActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    Button button;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        button=findViewById(R.id.addubtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=1; i<=2;i++){
                    startActivity(new Intent(adduserActivity.this,adduser2Activity.class));
                }



            }


        });
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu8);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        //
        if (id == R.id.item1) {
            Intent intent = new Intent(adduserActivity.this, proActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(adduserActivity.this, addviewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent intent = new Intent(adduserActivity.this, withdrawActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item4) {
            Intent intent = new Intent(adduserActivity.this, teamActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item5) {
            Intent intent = new Intent(adduserActivity.this, supportActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item6) {
            Intent intent = new Intent(adduserActivity.this, historyActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item7) {
            Intent intent = new Intent(adduserActivity.this, fundActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item8) {
            Intent intent = new Intent(adduserActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}

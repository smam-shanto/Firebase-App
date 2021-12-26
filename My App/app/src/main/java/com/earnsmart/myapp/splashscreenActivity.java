package com.earnsmart.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splashscreenActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences(loginActivity.pre_name,0);
                boolean haslogin=sharedPreferences.getBoolean("haslogin",false);
                if (haslogin){
                    Intent intent=new Intent(splashscreenActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent=new Intent(splashscreenActivity.this,loginActivity.class);
                    startActivity(intent);
                    finish();

                }


            }
        },1200);
    }
}

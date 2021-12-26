package com.earnsmart.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtMarquee;
    Button profile, addview, withdraw, team, support, history, fund, adduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMarquee = (TextView) findViewById(R.id.marqueeText);
        txtMarquee.setSelected(true);

        profile=(Button) findViewById(R.id.profile);
        addview=(Button)findViewById(R.id.addview);
        withdraw=(Button)findViewById(R.id.withdraw);
        team=(Button)findViewById(R.id.team);
        support=(Button)findViewById(R.id.support);
        history=(Button)findViewById(R.id.history);
        fund=(Button)findViewById(R.id.fund);
        adduser=(Button)findViewById(R.id.adduser);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile.setBackgroundColor(getResources().getColor(R.color.selected));
                addview.setBackgroundColor(getResources().getColor(R.color.nonselected));
                withdraw.setBackgroundColor(getResources().getColor(R.color.nonselected));
                team.setBackgroundColor(getResources().getColor(R.color.nonselected));
                support.setBackgroundColor(getResources().getColor(R.color.nonselected));
                history.setBackgroundColor(getResources().getColor(R.color.nonselected));
                fund.setBackgroundColor(getResources().getColor(R.color.nonselected));
                adduser.setBackgroundColor(getResources().getColor(R.color.nonselected));
                startActivity(new Intent(MainActivity.this,proActivity.class));

            }
        });
        addview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addview.setBackgroundColor(getResources().getColor(R.color.selected));
                profile.setBackgroundColor(getResources().getColor(R.color.nonselected));
                withdraw.setBackgroundColor(getResources().getColor(R.color.nonselected));
                team.setBackgroundColor(getResources().getColor(R.color.nonselected));
                support.setBackgroundColor(getResources().getColor(R.color.nonselected));
                history.setBackgroundColor(getResources().getColor(R.color.nonselected));
                fund.setBackgroundColor(getResources().getColor(R.color.nonselected));
                adduser.setBackgroundColor(getResources().getColor(R.color.nonselected));
                startActivity(new Intent(MainActivity.this,addviewActivity.class));

            }
        });
        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                withdraw.setBackgroundColor(getResources().getColor(R.color.selected));
                addview.setBackgroundColor(getResources().getColor(R.color.nonselected));
                profile.setBackgroundColor(getResources().getColor(R.color.nonselected));
                team.setBackgroundColor(getResources().getColor(R.color.nonselected));
                support.setBackgroundColor(getResources().getColor(R.color.nonselected));
                history.setBackgroundColor(getResources().getColor(R.color.nonselected));
                fund.setBackgroundColor(getResources().getColor(R.color.nonselected));
                adduser.setBackgroundColor(getResources().getColor(R.color.nonselected));
                startActivity(new Intent(MainActivity.this,withdrawActivity.class));

            }
        });
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team.setBackgroundColor(getResources().getColor(R.color.selected));
                addview.setBackgroundColor(getResources().getColor(R.color.nonselected));
                withdraw.setBackgroundColor(getResources().getColor(R.color.nonselected));
                profile.setBackgroundColor(getResources().getColor(R.color.nonselected));
                support.setBackgroundColor(getResources().getColor(R.color.nonselected));
                history.setBackgroundColor(getResources().getColor(R.color.nonselected));
                fund.setBackgroundColor(getResources().getColor(R.color.nonselected));
                adduser.setBackgroundColor(getResources().getColor(R.color.nonselected));
                startActivity(new Intent(MainActivity.this,teamActivity.class));

            }
        });
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                support.setBackgroundColor(getResources().getColor(R.color.selected));
                addview.setBackgroundColor(getResources().getColor(R.color.nonselected));
                withdraw.setBackgroundColor(getResources().getColor(R.color.nonselected));
                team.setBackgroundColor(getResources().getColor(R.color.nonselected));
                profile.setBackgroundColor(getResources().getColor(R.color.nonselected));
                history.setBackgroundColor(getResources().getColor(R.color.nonselected));
                fund.setBackgroundColor(getResources().getColor(R.color.nonselected));
                adduser.setBackgroundColor(getResources().getColor(R.color.nonselected));
                startActivity(new Intent(MainActivity.this,supportActivity.class));


            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history.setBackgroundColor(getResources().getColor(R.color.selected));
                addview.setBackgroundColor(getResources().getColor(R.color.nonselected));
                withdraw.setBackgroundColor(getResources().getColor(R.color.nonselected));
                team.setBackgroundColor(getResources().getColor(R.color.nonselected));
                support.setBackgroundColor(getResources().getColor(R.color.nonselected));
                profile.setBackgroundColor(getResources().getColor(R.color.nonselected));
                fund.setBackgroundColor(getResources().getColor(R.color.nonselected));
                adduser.setBackgroundColor(getResources().getColor(R.color.nonselected));
                startActivity(new Intent(MainActivity.this,historyActivity.class));


            }
        });
        fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fund.setBackgroundColor(getResources().getColor(R.color.selected));
                addview.setBackgroundColor(getResources().getColor(R.color.nonselected));
                withdraw.setBackgroundColor(getResources().getColor(R.color.nonselected));
                team.setBackgroundColor(getResources().getColor(R.color.nonselected));
                support.setBackgroundColor(getResources().getColor(R.color.nonselected));
                history.setBackgroundColor(getResources().getColor(R.color.nonselected));
                profile.setBackgroundColor(getResources().getColor(R.color.nonselected));
                adduser.setBackgroundColor(getResources().getColor(R.color.nonselected));
                startActivity(new Intent(MainActivity.this,fundActivity.class));
            }
        });
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adduser.setBackgroundColor(getResources().getColor(R.color.selected));
                addview.setBackgroundColor(getResources().getColor(R.color.nonselected));
                withdraw.setBackgroundColor(getResources().getColor(R.color.nonselected));
                team.setBackgroundColor(getResources().getColor(R.color.nonselected));
                support.setBackgroundColor(getResources().getColor(R.color.nonselected));
                history.setBackgroundColor(getResources().getColor(R.color.nonselected));
                fund.setBackgroundColor(getResources().getColor(R.color.nonselected));
                profile.setBackgroundColor(getResources().getColor(R.color.nonselected));
                startActivity(new Intent(MainActivity.this,adduserActivity.class));
            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText( this, "Press Back again to exit", Toast.LENGTH_SHORT ).show();
        finish();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000 );


    }
}

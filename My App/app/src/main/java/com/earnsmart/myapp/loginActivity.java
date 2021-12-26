package com.earnsmart.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class loginActivity extends AppCompatActivity {
    Button logbtn;
    EditText username, password;
    TextView forpass;
    FirebaseAuth fauth;
    public static String pre_name="mypre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forpass=findViewById(R.id.forpass);
        logbtn=findViewById(R.id.logbtn);
        username=findViewById(R.id.logusername);
        password=findViewById(R.id.logpassword);
        fauth=FirebaseAuth.getInstance();

    }

    private Boolean validateUsername(){
        String val = username.getText().toString();
        if (val.isEmpty()){
            username.setError("field can not empty");
            return false;
        }else {
            username.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = password.getText().toString();
        if (val.isEmpty()){
            password.setError("field can not empty");
            return false;
        }else {
            password.setError(null);
            return true;
        }
    }

    public void loginUser(View view){
        SharedPreferences sharedPreferences=getSharedPreferences(loginActivity.pre_name,0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("haslogin",true);
        editor.commit();
        startActivity(new Intent(loginActivity.this,MainActivity.class));
        finish();
        if (!validateUsername() | !validatePassword()){
            return;
        }else {
            isUser();
        }
    }

    private void isUser() {
        String userEnteredUsername = username.getText().toString().trim();
        String userEnteredPassword = password.getText().toString().trim();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Team");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    username.setError(null);
                    String passwordFromDB = snapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)){

                        username.setError(null);

                        String nameFromDB = snapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String usernameFromDB = snapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        String emailFromDB = snapshot.child(userEnteredUsername).child("email").getValue(String.class);
                        String positionFromDB = snapshot.child(userEnteredUsername).child("position").getValue(String.class);
                        String referFromDB = snapshot.child(userEnteredUsername).child("refer").getValue(String.class);
                        String rankFromDB = snapshot.child(userEnteredUsername).child("rank").getValue(String.class);
                        Intent intent=new Intent();
                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("email",emailFromDB);
                        intent.putExtra("password",passwordFromDB);
                        intent.putExtra("position",positionFromDB);
                        intent.putExtra("refer",referFromDB);
                        intent.putExtra("rank",rankFromDB);
                        startActivity(intent);

                    }else {
                        password.setError("wrong password");
                        password.requestFocus();
                    }
                }else {
                    username.setError("doesn't exist");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onBackPressed(){
        finish();

    }
}

package com.earnsmart.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class withdrawbActivity extends AppCompatActivity {
    Button withbtn;
    EditText wusername, waccount, wamount;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawb);
        wusername=findViewById(R.id.wusername);
        waccount=findViewById(R.id.waccount);
        wamount=findViewById(R.id.wamount);
        wusername.addTextChangedListener(textWatcher);
        waccount.addTextChangedListener(textWatcher);
        wamount.addTextChangedListener(textWatcher);
        withbtn=findViewById(R.id.withbtn);
        withbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Withdraw").child("Bkash");

                String username = wusername.getText().toString();
                String account = waccount.getText().toString();
                String amount = wamount.getText().toString();
                Withdraw withdraw= new Withdraw(username, account, amount);
                reference.child(username).setValue(withdraw).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(withdrawbActivity.this,withdrawActivity.class));
                        }
                    }
                });
            }
        });
    }
    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String username = wusername.getText().toString();
            String account = waccount.getText().toString();
            String amount = wamount.getText().toString();
            withbtn.setEnabled(!username.isEmpty() & !account.isEmpty() & !amount.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

package com.earnsmart.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fundActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Button fbtn;
    EditText etcusername, etcpassword, etfamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund);
        etcusername=findViewById(R.id.fusername);
        etcpassword=findViewById(R.id.fpassword);
        etfamount=findViewById(R.id.famount);
        etcusername.addTextChangedListener(textWatcher);
        etcpassword.addTextChangedListener(textWatcher);
        etfamount.addTextChangedListener(textWatcher);
        fbtn=findViewById(R.id.fbtn);

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Fund");
                String username = etcusername.getText().toString();
                String password = etcpassword.getText().toString();
                String amount = etfamount.getText().toString();

                Fund fund = new Fund(username, password, amount);
                reference.child(username).setValue(fund).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(fundActivity.this,"Successfully fund transfer",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

    }
    private TextWatcher textWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String username = etcusername.getText().toString();
            String password = etcpassword.getText().toString();
            String amount = etfamount.getText().toString();
            fbtn.setEnabled(!username.isEmpty() & !password.isEmpty() & !amount.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu7);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        //
        if (id == R.id.item1) {
            Intent intent = new Intent(fundActivity.this, proActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(fundActivity.this, addviewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent intent = new Intent(fundActivity.this, withdrawActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item4) {
            Intent intent = new Intent(fundActivity.this, teamActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item5) {
            Intent intent = new Intent(fundActivity.this, supportActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item6) {
            Intent intent = new Intent(fundActivity.this, historyActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item7) {
            Intent intent = new Intent(fundActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item8) {
            Intent intent = new Intent(fundActivity.this, adduserActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }
}

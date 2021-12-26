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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class adduser2Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    Button addu2btn;
    EditText addunusername, addupassword, addunrefer, addutranid;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser2);
        addutranid=findViewById(R.id.transactionid);
        addunusername=findViewById(R.id.addunusername);

        addutranid.addTextChangedListener(textWatcher);
        addunusername.addTextChangedListener(textWatcher);
        addu2btn=findViewById(R.id.addu2btn);
        addu2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Transaction");

                String username = addunusername.getText().toString();
                String tid = addutranid.getText().toString();

                Transaction transaction = new Transaction(username, tid);
                reference.child(username).setValue(transaction).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(adduser2Activity.this,childActivity.class));
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
            String username = addunusername.getText().toString();
            String tid = addutranid.getText().toString();
            addu2btn.setEnabled(!username.isEmpty() & !tid.isEmpty() );

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

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
            Intent intent = new Intent(adduser2Activity.this, proActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(adduser2Activity.this, addviewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent intent = new Intent(adduser2Activity.this, withdrawActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item4) {
            Intent intent = new Intent(adduser2Activity.this, teamActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item5) {
            Intent intent = new Intent(adduser2Activity.this, supportActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item6) {
            Intent intent = new Intent(adduser2Activity.this, historyActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item7) {
            Intent intent = new Intent(adduser2Activity.this, fundActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item8) {
            Intent intent = new Intent(adduser2Activity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}

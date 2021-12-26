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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class childActivity extends AppCompatActivity {

    TextView textView;
    FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Button cbtn;
    EditText etcname, etcemail, etcusername, etcpassword, etcposition, etcrefer, etcrank, etcparent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        mAuth = FirebaseAuth.getInstance();
        cbtn=findViewById(R.id.cbtn);
        etcname=findViewById(R.id.cname);
        etcusername=findViewById(R.id.cusername);
        etcposition=findViewById(R.id.cposition);
        etcrefer=findViewById(R.id.crefer);
        etcrank=findViewById(R.id.crank);
        etcpassword=findViewById(R.id.cpassword);

        textView =findViewById(R.id.main);

        etcname.addTextChangedListener(textWatcher);
        etcusername.addTextChangedListener(textWatcher);
        etcposition.addTextChangedListener(textWatcher);
        etcrefer.addTextChangedListener(textWatcher);
        etcrank.addTextChangedListener(textWatcher);
        etcpassword.addTextChangedListener(textWatcher);



        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Team");

                String name = etcname.getText().toString();
                String username = etcusername.getText().toString();
                String position = etcposition.getText().toString();
                String refer = etcrefer.getText().toString();
                String rank = etcrank.getText().toString();
                String password = etcpassword.getText().toString();


                Team team = new Team(name, username, position, refer, rank, password);
                reference.child(username).setValue(team).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(childActivity.this,"submitted successfully",Toast.LENGTH_LONG).show();
                           startActivity(new Intent(childActivity.this,adduserActivity.class));
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
            String name = etcname.getText().toString();
            String username = etcusername.getText().toString();
            String position = etcposition.getText().toString();
            String refer = etcrefer.getText().toString();
            String rank = etcrank.getText().toString();
            String password = etcpassword.getText().toString();
            cbtn.setEnabled(!name.isEmpty() & !username.isEmpty() & !position.isEmpty() & !refer.isEmpty() & !rank.isEmpty() & !password.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}

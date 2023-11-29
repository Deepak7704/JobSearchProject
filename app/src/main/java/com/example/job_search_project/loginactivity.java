package com.example.job_search_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class loginactivity extends AppCompatActivity {
    EditText loginuser,loginpassword;
    Button loginbutton;
    TextView signupredirect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        loginuser=findViewById(R.id.lusername);
        loginpassword=findViewById(R.id.password);
        signupredirect=findViewById(R.id.noaccount);
        loginbutton=findViewById(R.id.loginbtn);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateuser() || !validatepassword()){
                }
                else {
                    checkuser();
                }
            }
        });
        signupredirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loginactivity.this, signup.class);
                Toast.makeText(loginactivity.this, "", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
    public Boolean validateuser(){
        String val=loginuser.getText().toString();
        if(val.isEmpty()){
            loginuser.setError("Username cannot be empty");
            return false;
        }
        else {
            loginuser.setError(null);
            return true;
        }
    }
    public Boolean validatepassword(){
        String val=loginpassword.getText().toString();
        if(val.isEmpty()){
            loginpassword.setError("Password cannot be empty");
            return false;
        }
        else {
            loginpassword.setError(null);
            return true;
        }
    }
    public void checkuser(){
        String userUsername=loginuser.getText().toString().trim();
        String userUserpassword=loginpassword.getText().toString().trim();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase=reference.orderByChild("username").equalTo(userUsername);


        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    loginuser.setError(null);
                    String passwordfromDB=snapshot.child(userUsername).child("password").getValue(String.class);

                    if(passwordfromDB.equals(userUserpassword)){
                        loginuser.setError(null);
                        String n=loginuser.getText().toString();
                        Intent intent=new Intent(loginactivity.this, MainActivity.class);
                        intent.putExtra("Username",n);

                        startActivity(intent);
                    }

                    else {
                        loginpassword.setError("Invalid credentials");
                        loginpassword.requestFocus();
                    }

                }else {
                    loginuser.setError("User does not exist");
                    loginuser.requestFocus();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}



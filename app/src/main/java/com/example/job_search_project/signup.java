package com.example.job_search_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    EditText signupName,signupEmail,signupUserName,signupPassword;
    TextView loginRedirectText;
    Button singupbutton;
    FirebaseDatabase database;
    DatabaseReference reference;
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupName=findViewById(R.id.fullname);
        signupEmail=findViewById(R.id.email);
        signupUserName=findViewById(R.id.password);
        signupPassword=findViewById(R.id.phone);
        singupbutton=findViewById(R.id.registerbtn);
        loginRedirectText=findViewById(R.id.loginRedirect);

        singupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!signupName.getText().toString().isEmpty()&!signupPassword.getText().toString().isEmpty()&!signupUserName.getText().toString().isEmpty()&!signupEmail.getText().toString().isEmpty()) {



                database=FirebaseDatabase.getInstance();
                reference=database.getReference("users");



                String name=signupName.getText().toString();
                String mail=signupEmail.getText().toString();
                String username=signupUserName.getText().toString();
                String password=signupPassword.getText().toString();

                HelperClass helperClass=new HelperClass(name,mail,username,password);
                reference.child(username).setValue(helperClass);
                Toast.makeText(signup.this,"You have registered successfully!",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(signup.this, loginactivity.class);
                startActivity(intent);
            }else {
                    Toast.makeText(signup.this, "Above fields cannot be empty", Toast.LENGTH_LONG).show();
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signup.this, loginactivity.class);
                startActivity(intent);
            }
        });
    }
    public void checkusername(){
        if(signupUserName==null){
            signupUserName.setError(null);
        }
        else{
            signupUserName.setError("Username cannot be empty");
        }
    }

}
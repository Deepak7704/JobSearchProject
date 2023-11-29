package com.example.job_search_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class userdetails extends AppCompatActivity {
    TextView logoutredirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);
        logoutredirect=findViewById(R.id.logout);
        logoutredirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(userdetails.this, signup.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

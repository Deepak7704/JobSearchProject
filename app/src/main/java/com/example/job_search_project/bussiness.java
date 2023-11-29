package com.example.job_search_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bussiness extends AppCompatActivity {
    private Button b1,b2,b3,b4,ab1,ab2,ab3,ab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussiness);
        b1=findViewById(R.id.bussinessb1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bussiness.this, bussinessdescription.class);
                startActivity(intent);
            }
        });
        b2=findViewById(R.id.bussinessb2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(bussiness.this, bussinessanalyst.class);
                startActivity(intent2);
            }
        });
        b3=findViewById(R.id.bussinessb3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(bussiness.this, financialanalyst.class);
                startActivity(intent3);
            }
        });
        b4=findViewById(R.id.bussinessb4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(bussiness.this, marketingmanager.class);
                startActivity(intent4);
            }
        });
        ab1=findViewById(R.id.buttonb1);
        ab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bussiness.this, applybutton.class);
                startActivity(intent);
            }
        });
        ab2=findViewById(R.id.buttonb2);
        ab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bussiness.this, applybutton.class);
                startActivity(intent);
            }
        });
        ab3=findViewById(R.id.buttonb3);
        ab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bussiness.this, applybutton.class);
                startActivity(intent);
            }
        });
        ab4=findViewById(R.id.buttonb4);
        ab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bussiness.this, applybutton.class);
                startActivity(intent);
            }
        });


    }
}
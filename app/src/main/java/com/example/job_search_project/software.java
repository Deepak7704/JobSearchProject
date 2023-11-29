package com.example.job_search_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class software extends AppCompatActivity {
    private Button s1,s2,s3,s4,s5,as1,as2,as3,as4,as5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software);
        s1=findViewById(R.id.softwareb1);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(software.this, datascientist1.class);
                startActivity(intent);
            }
        });
        s2=findViewById(R.id.softwareb2);
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(software.this, cloudarchitect.class);
                startActivity(intent1);
            }
        });
        s3=findViewById(R.id.softwareb3);
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(software.this, uxuidesigner.class);
                startActivity(intent2);
            }
        });
        s4=findViewById(R.id.softwareb4);
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(software.this, devopsengineer.class);
                startActivity(intent3);
            }
        });
        s5=findViewById(R.id.softwareb5);
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(software.this, softwaredeveloper.class);
                startActivity(intent4);
            }
        });
        as1=findViewById(R.id.buttons1);
        as1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(software.this, applybutton.class);
                startActivity(intent);
            }
        });
        as2=findViewById(R.id.buttons2);
        as2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(software.this, applybutton.class);
                startActivity(intent);
            }
        });
        as3=findViewById(R.id.buttons3);
        as3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(software.this, applybutton.class);
                startActivity(intent);
            }
        });
        as4=findViewById(R.id.buttons4);
        as4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(software.this, applybutton.class);
                startActivity(intent);
            }
        });
        as5=findViewById(R.id.buttons5);
        as5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(software.this, applybutton.class);
                startActivity(intent);
            }
        });


    }
}
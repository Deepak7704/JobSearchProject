package com.example.job_search_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class architecture extends AppCompatActivity {
    private Button a1,a2,a3,a4,a5,ap1,ap2,ap3,ap4,ap5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);
        a1=findViewById(R.id.architectureb1);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(architecture.this, architecturedescription.class);
                startActivity(intent);
            }
        });
        a2=findViewById(R.id.architectureb2);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(architecture.this,interiordesigner_architecture.class);
                startActivity(intent2);
            }
        });
        a3=findViewById(R.id.architectureb3);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(architecture.this, builinginscpector.class);
                startActivity(intent3);
            }
        });
        a4=findViewById(R.id.architectureb4);
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(architecture.this, construction_manager.class);
                startActivity(intent4);
            }
        });
        a5=findViewById((R.id.architectureb5));
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(architecture.this, architect.class);
                startActivity(intent5);
            }
        });
        ap1=findViewById(R.id.buttona1);
        ap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(architecture.this, applybutton.class);
                startActivity(intent);
            }
        });
        ap2=findViewById(R.id.buttona2);
        ap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(architecture.this, applybutton.class);
                startActivity(intent);
            }
        });
        ap3=findViewById(R.id.buttona3);
        ap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(architecture.this, applybutton.class);
                startActivity(intent);
            }
        });
        ap4=findViewById(R.id.buttona4);
        ap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(architecture.this, applybutton.class);
                startActivity(intent);
            }
        });
        ap5=findViewById(R.id.buttona5);
        ap5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(architecture.this, applybutton.class);
                startActivity(intent);
            }
        });


    }
}
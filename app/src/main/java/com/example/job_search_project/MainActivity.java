package com.example.job_search_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageButton move,move2,move3,move4,info;
    private View header;
    TextView nameuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        move = findViewById(R.id.imageButton);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, architecture.class);
                startActivity(intent);
            }
        });
        move2 = findViewById(R.id.imageButton2);
        move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, bussiness.class);
                startActivity(intent2);
            }
        });
        move3 = findViewById(R.id.imageButton3);
        move3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, teacher.class);
                startActivity(intent3);
            }
        });
        move4 = findViewById(R.id.imageButton4);
        move4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, software.class);
                startActivity(intent4);
            }
        });
        info=findViewById(R.id.imageButton5);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(MainActivity.this, userdetails.class);
                startActivity(intent5);
            }
        });
        nameuser=findViewById(R.id.textView46);
        String username=getIntent().getStringExtra("Username");
        nameuser.setText("Welcome back "+username+",");
    }

}
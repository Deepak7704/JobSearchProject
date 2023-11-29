package com.example.job_search_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class teacher extends AppCompatActivity {
    private Button t1,t2,t3,t4,at1,at2,at3,at4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        t1=findViewById(R.id.teacherb1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(teacher.this, assitatnt_prof_ds.class);
                startActivity(intent);
            }
        });
        t2=findViewById(R.id.teacherb2);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(teacher.this, assistant_prof_math.class);
                startActivity(intent1);
            }
        });
        t3=findViewById(R.id.teacherb3);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(teacher.this, prof_ml.class);
                startActivity(intent2);
            }
        });
        t4=findViewById(R.id.teacherb4);
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(teacher.this, teaching_assistant.class);
                startActivity(intent3);
            }
        });
        at1=findViewById(R.id.buttont1);
        at1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(teacher.this, applybutton.class);
                startActivity(intent);
            }
        });
        at2=findViewById(R.id.buttont2);
        at2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(teacher.this, applybutton.class);
                startActivity(intent);
            }
        });
        at3=findViewById(R.id.buttont3);
        at3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(teacher.this, applybutton.class);
                startActivity(intent);
            }
        });
        at4=findViewById(R.id.buttont4);
        at4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(teacher.this, applybutton.class);
                startActivity(intent);
            }
        });
    }
}
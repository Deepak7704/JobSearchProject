package com.example.job_search_project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class applybutton extends AppCompatActivity {
    private Button dialogbutton,resumebutton;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    EditText e1,e2,e3,e4,e5,e6,e7,e8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applybutton);
        e1=findViewById(R.id.firstname);
        e2=findViewById(R.id.middlename);
        e3=findViewById(R.id.age);
        e4=findViewById(R.id.email);
        e5=findViewById(R.id.phone);
        e6=findViewById(R.id.qualification);
        e7=findViewById(R.id.experience);
        e8=findViewById(R.id.address);
        resumebutton=findViewById(R.id.uploadresumebutton);
        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference=FirebaseDatabase.getInstance().getReference("users");
        resumebutton.setEnabled(false);
        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPDF();
            }
        });

        dialogbutton=findViewById(R.id.applybtn);
        dialogbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!e1.getText().toString().isEmpty()&!e2.getText().toString().isEmpty()&!e3.getText().toString().isEmpty()&!e4.getText().toString().isEmpty()&!e5.getText().toString().isEmpty()&!e6.getText().toString().isEmpty()&!e6.getText().toString().isEmpty()&!e7.getText().toString().isEmpty()&!e8.getText().toString().isEmpty()){
                    showDialogBox();
                }
                else{
                    Toast.makeText(applybutton.this, "Above field cannot be empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    private void showDialogBox() {
        ConstraintLayout dialogboxobj=findViewById(R.id.dialogbox1);
        View view= LayoutInflater.from(applybutton.this).inflate(R.layout.dialogbox,dialogboxobj);
        Button close=view.findViewById(R.id.closebutton);
        AlertDialog.Builder builder=new AlertDialog.Builder(applybutton.this);
        builder.setView(view);
        final AlertDialog alertDialog=builder.create();
        close.findViewById(R.id.closebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 alertDialog.dismiss();
                Toast.makeText(applybutton.this, "Application sent successfully", Toast.LENGTH_SHORT).show();
            }
        });
        if(alertDialog.getWindow()!=null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();

    }
    private void selectPDF(){
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"PDF FILE SELECT"),12);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==12 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            resumebutton.setEnabled(true);
            e2.setText(data.getDataString()
                    .substring((data.getDataString()).lastIndexOf("/")+1));
            e2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    uploadPDFFIlEFIREBASE(data.getData());
                }
            });
        }
    }

    private void uploadPDFFIlEFIREBASE(Uri data) {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("File is uploading");
        progressDialog.show();

        StorageReference reference=storageReference.child("upload"+System.currentTimeMillis()+".pdf");
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask =taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri uri=uriTask.getResult();
                putPDF putPDF=new putPDF(e2.getText().toString(),uri.toString());
                databaseReference.child(databaseReference.push().getKey()).setValue(putPDF);
                Toast.makeText(applybutton.this, "Resume uploaded sucessfully", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progress=(100.0* snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                progressDialog.setMessage("File is uploading"+(int) progress +"%");
            }
        });
    }
}
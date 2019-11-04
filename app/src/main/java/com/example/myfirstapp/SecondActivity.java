package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private String age, gender, sexualActivity, name, number;
    private EditText ageInput, genderInput, sexInput,nameInput, numInput;
    private Button submit;
    private FirebaseAuth mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mFirebase = FirebaseAuth.getInstance();
        nameInput = (EditText) findViewById(R.id.editname);
        numInput = (EditText) findViewById(R.id.editnumber);
        ageInput = (EditText) findViewById(R.id.age_num);
        genderInput = (EditText) findViewById(R.id.gender_user);
        sexInput = (EditText) findViewById(R.id.sexact_user);


        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                number = numInput.getText().toString();
                age = ageInput.getText().toString();
                gender = genderInput.getText().toString();
                sexualActivity = sexInput.getText().toString();
                if (name.isEmpty()){
                    nameInput.setError("Please enter name!");
                }

                mFirebase.createUserWithEmailAndPassword(name, number).addOnCompleteListener(SecondActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            System.out.print("failed!");
                            Toast.makeText(SecondActivity.this, "Failed!", Toast.LENGTH_SHORT);
                        }
                        else {
                            openNextPage();
                        }
                    }
                });

            }
        });
    }

    public void openNextPage() {
        Intent intent = new Intent(this, Activity_LastTime.class);
        startActivity(intent);
    }


}

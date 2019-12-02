package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    private String age, gender, sexualActivity, name, number;
    private EditText ageInput, genderInput, sexInput,nameInput, numInput;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        nameInput = (EditText) findViewById(R.id.editname);
        numInput = (EditText) findViewById(R.id.editnumber);
        ageInput = (EditText) findViewById(R.id.age_num);
        genderInput = (EditText) findViewById(R.id.gender_user);
        sexInput = (EditText) findViewById(R.id.sexact_user);


        submit = (Button) findViewById(R.id.submit_second_activity);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                number = numInput.getText().toString();
                age = ageInput.getText().toString();
                gender = genderInput.getText().toString();
                sexualActivity = sexInput.getText().toString();

                if (checkInputs())
                    openNextPage();
            }
        });
    }

    //functions that check for input user info
    public boolean checkInputs(){
        if(TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(age)){
            Toast.makeText(this, "Please enter your age", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(number)){
            Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(gender)){
            Toast.makeText(this, "Please enter your gender", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(sexualActivity)){
            Toast.makeText(this, "Please enter your sexual activity or health", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true; }
    }

    public void openNextPage() {
        Intent intent = new Intent(this, All_Cases.class);
        startActivity(intent);
    }


}

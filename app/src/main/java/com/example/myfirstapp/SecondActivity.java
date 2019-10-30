package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private String age, gender, sexualActivity;
    private EditText ageInput, genderInput, sexInput;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /*ageInput = (EditText) findViewById(R.id.age);
        genderInput = (EditText) findViewById(R.id.gender);
        sexInput = (EditText) findViewById(R.id.sexual_activity);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = ageInput.getText().toString();
                gender = genderInput.getText().toString();
                sexualActivity = sexInput.getText().toString();

                //openNextPage();
            }
        });*/
    }

    public void openNextPage() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}

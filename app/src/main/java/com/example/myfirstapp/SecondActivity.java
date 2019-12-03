package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Context;


public class SecondActivity extends AppCompatActivity {

    private String age, gender, sexualActivity, name, number;
    private EditText ageInput, genderInput, sexInput,nameInput, numInput;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        nameInput = findViewById(R.id.editname);
        numInput = findViewById(R.id.age_num);
        sexInput = findViewById(R.id.sexact_user);

        Spinner ageInput = findViewById(R.id.spinner_age);
        String[] age_options = new String[]{"< 18", "18-24", "25-39", "40-60", "60+"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, age_options);
        ageInput.setAdapter(adapter);

        Spinner genderInput = findViewById(R.id.spinner_gender);
        String[] gender_options = new String[]{"Female", "Male", "Non Binary/Gender Non-Conforming", "Other"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gender_options);
        genderInput.setAdapter(adapter2);

        submit = (Button) findViewById(R.id.submitbutton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                number = numInput.getText().toString();
                sexualActivity = sexInput.getText().toString();

                //if (checkInputs()){
                Context context = v.getContext();
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                openNextPage();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                returnHome();
                                break;
                        }
                    }
                };


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Do you want to use OmniSMS to store your information?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();


                //}

            }
        });
    }

    //functions that check for input user info
    public boolean checkInputs(){
        if(TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(number)){
            Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(sexualActivity)){
            Toast.makeText(this, "Please enter your sexual activity or health", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true; }
    }

    public void openNextPage() {
        Intent intent = new Intent(this, All_Cases_NewUser.class);
        startActivity(intent);
    }

    public void returnHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

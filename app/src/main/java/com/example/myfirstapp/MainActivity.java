package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    private String PhoneNumber, password;
    private EditText phoneInput;
    private EditText passInput;
    private Button submit, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneInput = (EditText) findViewById(R.id.phoneNum);
        passInput = (EditText) findViewById(R.id.password);

        //new user button
        submit = (Button) findViewById(R.id.submitbutton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PhoneNumber = phoneInput.getText().toString();
                password = passInput.getText().toString();

                //if (checkPhone(PhoneNumber) && checkName(password)) {
                    openInfoPage();
                //}
            }
        });

        //returning user button
        register = (Button) findViewById(R.id.submitbutton2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PhoneNumber = phoneInput.getText().toString();
                password = passInput.getText().toString();

                if (checkPhone(PhoneNumber) && checkName(password)) {
                    openLastTimePage(password);
                }
            }
        });
    }

    //functions that check for input user info
    public boolean checkPhone(String phone){
        if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean checkName(String name){
        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    //function that opens page for returning user
    public void openLastTimePage(String s){
        Intent intent = new Intent(this, All_Cases_NewUser.class);
        if (s.compareTo("Password8!") == 0) {
            intent = new Intent(this, All_Cases.class);
        } else if (s.compareTo("Password8!!") == 0){
            intent = new Intent(this, All_Cases_Pending.class);
        } else if (s.compareTo("Password9!!") == 0){
            intent = new Intent(this, AllCasesProcessed.class);
        }
        startActivity(intent);
    }

    //function that opens page for new user
    public void openInfoPage(){
        Intent intent = new Intent(this, Activity_Init_Info.class);
        startActivity(intent);
    }



}

package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Activity_CheckIn extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "topic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__check_in);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        //Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        ImageButton left = (ImageButton) findViewById(R.id.leftButton);
        ImageButton right = (ImageButton) findViewById(R.id.rightButton);
        Button home = (Button) findViewById(R.id.homebutton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonVal = (Button) findViewById(R.id.button1);
                String buttonText = buttonVal.getText().toString();
                sendInformation(Activity_Information.class, buttonText);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonVal = (Button) findViewById(R.id.button2);
                String buttonText = buttonVal.getText().toString();
                sendInformation(Activity_Information.class, buttonText);
            }
        });
        /*
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInformation(Activity_LastTime.class);
            }
        });
        */

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonVal = (Button) findViewById(R.id.button4);
                String buttonText = buttonVal.getText().toString();
                sendInformation(Activity_Information.class, buttonText);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonVal = (Button) findViewById(R.id.button5);
                String buttonText = buttonVal.getText().toString();
                sendInformation(Activity_Information.class, buttonText);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonVal = (Button) findViewById(R.id.button6);
                String buttonText = buttonVal.getText().toString();
                sendInformation(Activity_Information.class, buttonText);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(All_Cases_NewUser.class);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe(v);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(All_Cases_NewUser.class);
            }
        });

    }

    public void sendInformation(final Class<? extends Activity> ActivityToOpen, String s) {
        Intent intent = new Intent(this, ActivityToOpen);
        intent.putExtra(EXTRA_MESSAGE, s);
        startActivity(intent);
    }

    public void openNextPage(final Class<? extends Activity> ActivityToOpen){
        Intent intent = new Intent(this, ActivityToOpen);
        startActivity(intent);
    }

    //function that displays "submitted" message
    public void toastMe(View view){
        // Toast myToast = Toast.makeText(this, message, duration);
        Toast myToast = Toast.makeText(this, "Please click one of the topics and press submit!",
                Toast.LENGTH_SHORT);
        myToast.show();
    }

}

package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Information extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__information);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Activity_CheckIn.EXTRA_MESSAGE);


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.heading);
        textView.setText(message);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button3 = (Button) findViewById(R.id.button3);
        Button submit = (Button) findViewById(R.id.submit_second_activity);
        ImageButton left = (ImageButton) findViewById(R.id.leftButton);
        ImageButton right = (ImageButton) findViewById(R.id.rightButton);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe(v);
                Button buttonVal = (Button) findViewById(R.id.button1);
                String buttonText = buttonVal.getText().toString();
                sendInformation(CaseActivity.class, buttonText);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe(v);
                Button buttonVal = (Button) findViewById(R.id.button2);
                String buttonText = buttonVal.getText().toString();
                sendInformation(CaseActivity.class, buttonText);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe(v);
                Button buttonVal = (Button) findViewById(R.id.button3);
                String buttonText = buttonVal.getText().toString();
                sendInformation(CaseActivity.class, buttonText);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe(v);
                Button buttonVal = (Button) findViewById(R.id.button3);
                String buttonText = buttonVal.getText().toString();
                sendInformation(CaseActivity.class, buttonText);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe(v);
                Button buttonVal = (Button) findViewById(R.id.button5);
                String buttonText = buttonVal.getText().toString();
                sendInformation(CaseActivity.class, buttonText);
            }
        });
        /*button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe(v);
                Button buttonVal = (Button) findViewById(R.id.submit);
                String buttonText = buttonVal.getText().toString();
                sendInformation(CaseActivity.class, buttonText);
            }
        });
         */
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(Activity_CheckIn.class);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(CaseActivity.class);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(CaseActivity.class);
            }
        });



    }

    public void sendInformation(final Class<? extends Activity> ActivityToOpen, String buttonText) {
        Intent intent = new Intent(this, ActivityToOpen);
        intent.putExtra(EXTRA_MESSAGE, buttonText);
        startActivity(intent);
    }

    public void openNextPage(final Class<? extends Activity> ActivityToOpen){
        Intent intent = new Intent(this, ActivityToOpen);
        startActivity(intent);
    }

    public void toastMe(View view){
        // Toast myToast = Toast.makeText(this, message, duration);
        Toast myToast = Toast.makeText(this, "Added to case!",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
}

package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ImageButton;
import android.app.Activity;

import android.os.Bundle;

public class Activity_LastTime extends AppCompatActivity {

    private Button helptoday;
    private ImageButton left, right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lasttime);

        left = (ImageButton) findViewById(R.id.leftButton);
        right = (ImageButton) findViewById(R.id.rightButton);
        helptoday = (Button) findViewById(R.id.helptoday);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(SecondActivity.class);
            }
        });
        /*right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(SecondActivity.class);
            }
        });*/


    }

    public void openNextPage(final Class<? extends Activity> ActivityToOpen){
        Intent intent = new Intent(this, ActivityToOpen);
        startActivity(intent);
    }
}


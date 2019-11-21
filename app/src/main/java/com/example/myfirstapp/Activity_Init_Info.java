package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class Activity_Init_Info extends AppCompatActivity {

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_info);

        next = (Button) findViewById(R.id.donebutton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage();
            }
        });
    }

    //opens registration page
    public void openNextPage(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}

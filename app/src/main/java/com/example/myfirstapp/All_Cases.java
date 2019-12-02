package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import java.lang.Boolean;

public class All_Cases extends AppCompatActivity {

    ImageButton left, right;
    Button home,pcase1,pcase2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cases);

        final Bundle b = getIntent().getExtras();
        if (b != null) {
            if (b.containsKey("case?")) {
                boolean isCase = b.getBoolean("case?");
                if (isCase){
                    // add the new case to the list...but how

                }
            }
        }

        left = (ImageButton) findViewById(R.id.leftButton);
        right = (ImageButton) findViewById(R.id.rightButton);
        home = (Button) findViewById(R.id.homebutton);
        pcase1 = findViewById(R.id.pcase1);
        pcase2 = findViewById(R.id.pcase2);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(MainActivity.class);
            }

        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(Activity_CheckIn.class);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(MainActivity.class);
            }
        });
        /// On Click of the Cases:
        pcase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(InfoPage_Activity.class);
            }
        });


    }

    public void openNextPage(final Class<? extends Activity> ActivityToOpen){
        Intent intent = new Intent(this, ActivityToOpen);
        startActivity(intent);
    }
}

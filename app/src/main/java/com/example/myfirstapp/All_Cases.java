package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

public class All_Cases extends AppCompatActivity {

    Button logout, newcase;
    Button home,pcase1,pcase2,case1, case2, case3;
    public static final String EXTRA_MESSAGE = "casenumber";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cases);
        home = (Button) findViewById(R.id.homebutton);
        logout = findViewById(R.id.logout);
        newcase = findViewById(R.id.newcase);

        pcase1 = findViewById(R.id.pcase1);
        pcase2 = findViewById(R.id.pcase2);
        case1 = findViewById(R.id.pcase1);
        case2 = findViewById(R.id.case2);
        case3 = findViewById(R.id.case3);

        final Bundle b = getIntent().getExtras();
        if (b != null) {
            if (b.containsKey("case?")) {
                boolean isCase = b.getBoolean("case?");
                if (isCase){
                    // add the new case to the list...but how

                }
            }
        }

        /// On Click of the Cases:
        pcase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(InfoPage_Activity.class);
            }
        });

        pcase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(InfoPage_Activity.class);
            }
        });

        case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonVal = (Button) findViewById(R.id.pcase1);
                String buttonText = buttonVal.getText().toString();
                editcases(EditCases.class, buttonText);
            }
        });
        case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonVal = (Button) findViewById(R.id.case2);
                String buttonText = buttonVal.getText().toString();
                editcases(EditCases.class, buttonText);
            }
        });
        case3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonVal = (Button) findViewById(R.id.case3);
                String buttonText = buttonVal.getText().toString();
                editcases(EditCases.class, buttonText);
            }
        });


        /// Standard Bottom buttons
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(MainActivity.class);
            }

        });
        newcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(Activity_CheckIn.class);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(All_Cases.class);
            }
        });



    }

    public void openNextPage(final Class<? extends Activity> ActivityToOpen){
        Intent intent = new Intent(this, ActivityToOpen);
        startActivity(intent);
    }

    public void editcases(final Class<? extends Activity> ActivityToOpen, String s) {
        Intent intent = new Intent(this, ActivityToOpen);
        intent.putExtra(EXTRA_MESSAGE, s);
        startActivity(intent);
    }
}

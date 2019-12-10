package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class EditCases extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "case0";
    Button delete, home;
    TextView heading, subheading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_cases);

        Intent intent = getIntent();
        final String message = intent.getStringExtra(All_Cases.EXTRA_MESSAGE);

        heading = findViewById(R.id.heading);
        subheading = findViewById(R.id.heading2);
        delete = findViewById(R.id.submitbutton);
        home = findViewById(R.id.homebutton);
        heading.setText(message);

        assert message != null;

        //hardcoded cases
        if (message.compareTo("Case 4 ---- Submitted: Two Hours Ago") == 0) {
            /// Read from file and store
            subheading.setText("Pregnancy");
            String[] case1_array = {"Pregnancy symptoms", "Preventing Pregnancy", "Nutrition while Pregnant", "Trying to Conceive"};
            ListView lv = (ListView) findViewById(R.id.outputList);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, case1_array);
            lv.setAdapter(adapter);
        } else if (message.compareTo("Case 5 ---- Submitted: Three Days Ago") == 0) {
            subheading.setText("Menstruation");
            String[] case1_array = {"Menstrual Products (i.e. Pads, Tampons, Cups)", "Premenstrual Syndrome (PMS)", "Menstrual Cramps", "Irregular Bleeding"};
            ListView lv = (ListView) findViewById(R.id.outputList);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, case1_array);
            lv.setAdapter(adapter);
        } else if (message.compareTo("Case 6 ---- Submitted: Five Days Ago") == 0) {
            subheading.setText("Birth Control");
            String[] case1_array = {"Emergency Contraception", "Birth Control and STIs", "Buying Products", "Sterilization"};
            ListView lv = (ListView) findViewById(R.id.outputList);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, case1_array);
            lv.setAdapter(adapter);
        } else if (message.compareTo("Case 1 ---- Submitted: 1 Minute Ago") == 0) {
            /// Read from file and store
            subheading.setText("Pregnancy");
            String[] case1_array = {"Pregnancy symptoms", "Preventing Pregnancy", "Nutrition while Pregnant", "Trying to Conceive"};
            ListView lv = (ListView) findViewById(R.id.outputList);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, case1_array);
            lv.setAdapter(adapter);
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateDialog(message);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (message.compareTo("Case 4 ---- Submitted: Two Hours Ago") == 0) {
                    openNextPage(All_Cases.class);
                } else if (message.compareTo("Case 5 ---- Submitted: Three Days Ago") == 0) {
                    openNextPage(All_Cases.class);
                } else if (message.compareTo("Case 6 ---- Submitted: Five Days Ago") == 0) {
                    openNextPage(All_Cases.class);
                } else if (message.compareTo("Case 1 ---- Submitted: 1 Minute Ago") == 0) {
                    openNextPage(All_Cases_Pending.class);
                }
                //openNextPage(All_Cases_Pending.class);
            }
        });


    }

    public void openNextPage(final Class<? extends Activity> ActivityToOpen){
        Intent intent = new Intent(this, ActivityToOpen);
        startActivity(intent);
    }

    public void CreateDialog(String message){
        if (message.compareTo("Case 5 ---- Submitted: Three Days Ago") == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to delete the case?")
                    .setTitle("Deleting Case")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            openNextPage(AllCases_Removed.class);}

                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // CANCEL
                        }
                    });
            // Create the AlertDialog object and return it
            builder.create().show();
         }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to delete the case?")
                        .setTitle("Deleting Case")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                openNextPage(All_Cases_NewUser.class);}

                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // CANCEL
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create().show();

            }

    }

}


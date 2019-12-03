package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class EditCases extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "case0";
    Button delete, update;
    TextView heading, subheading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_cases);

        Intent intent = getIntent();
        final String message = intent.getStringExtra(All_Cases.EXTRA_MESSAGE);

        heading = findViewById(R.id.heading);
        subheading = findViewById(R.id.heading2);
        delete = findViewById(R.id.delete_case);
        update = findViewById(R.id.update_case);

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
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /// check if really want to delete
                openNextPage(All_Cases.class);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
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

}


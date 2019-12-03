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
import java.util.ArrayList;

import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity_Information extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    ListView list;
    ArrayAdapter<String> adapter;
    Button submit;
    String details[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__information);

        Intent intent = getIntent();
        final String message = intent.getStringExtra(Activity_CheckIn.EXTRA_MESSAGE);

       // Log.d("myMessage", message);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.heading);
        textView.setText(message);

        submit = (Button) findViewById(R.id.submit_bundle);

        //list
        list = (ListView) findViewById(R.id.list);

        assert message != null;
        if (message.compareTo("Pregnancy") == 0) {
            details = getResources().getStringArray(R.array.pregnancy_array);
        } else if (message.compareTo("Child Health") == 0) {
            details = getResources().getStringArray(R.array.childhealth_array);
        } else if (message.compareTo("Menstruation") == 0) {
            details = getResources().getStringArray(R.array.menstruation_array);
        } else if (message.compareTo("HIV and AIDS") == 0) {
            details = getResources().getStringArray(R.array.hiv_array);
        } else if (message.compareTo("Birth Control") == 0) {
            details = getResources().getStringArray(R.array.birthcontrol_array);
        }

        //details = getResources().getStringArray(R.array.pregnancy_array);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, details);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);


        //left and right buttons
        ImageButton left = (ImageButton) findViewById(R.id.leftButton);
        ImageButton right = (ImageButton) findViewById(R.id.rightButton);
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

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SparseBooleanArray checked = list.getCheckedItemPositions();
                ArrayList<String> selectedItems = new ArrayList<String>();
                for (int i = 0; i < checked.size(); i++) {
                    int position = checked.keyAt(i);
                    if (checked.valueAt(i))
                        selectedItems.add(adapter.getItem(position));
                }

                String[] outputStrArr = new String[selectedItems.size()];
                for (int i = 0; i < selectedItems.size(); i++) {
                    outputStrArr[i] = selectedItems.get(i);
                }

                // Create a bundle object
                Bundle b = new Bundle();
                b.putStringArray("selectedItems", outputStrArr);
                b.putString("topic", message);
                //b.putBoolean("case?", true);

                openAfterSubmit(CaseActivity.class, b);
            }
        });


    }

    public void openAfterSubmit(final Class<? extends Activity> ActivityToOpen, Bundle b){
        Intent intent = new Intent(this, CaseActivity.class);
        intent.putExtras(b);
        startActivity(intent);
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

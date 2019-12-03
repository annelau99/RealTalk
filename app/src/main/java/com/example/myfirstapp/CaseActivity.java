package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CaseActivity extends AppCompatActivity {

    Spinner contact;
    private static final String[] methods = {"Call", "Text Message", "I do not wish to be contacted"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);

        final Bundle b = getIntent().getExtras();
        if (b != null) {
            String[] resultArr = b.getStringArray("selectedItems");
            ListView lv = (ListView) findViewById(R.id.outputList);

            String message = b.getString("topic");
            TextView textView = findViewById(R.id.heading2);
            textView.setText(message);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, resultArr);
            lv.setAdapter(adapter);
        }


        /// Contact method
        contact = findViewById(R.id.contact_mthd);
        ArrayAdapter<String>contactadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,methods);

        contactadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        contact.setAdapter(contactadapter);


        Button submit = (Button) findViewById(R.id.delete_case);
        ImageButton left = (ImageButton) findViewById(R.id.leftButton);
        ImageButton right = (ImageButton) findViewById(R.id.rightButton);
        Button home = (Button) findViewById(R.id.homebutton3);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(All_Cases.class, b);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(Activity_Information.class, b);
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
                openNextPage(MainActivity.class, b);
            }
        });

    }

    public void toastMe(View view){
        // Toast myToast = Toast.makeText(this, message, duration);
        Toast myToast = Toast.makeText(this, "Press submit button!",
                Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void openNextPage(final Class<? extends Activity> ActivityToOpen, Bundle b){
        Intent intent = new Intent(this, ActivityToOpen);
        intent.putExtras(b);
        startActivity(intent);
    }


}

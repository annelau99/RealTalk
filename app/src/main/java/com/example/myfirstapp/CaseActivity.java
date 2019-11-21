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
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Activity_Information.EXTRA_MESSAGE);

        Bundle b = getIntent().getExtras();
        String[] resultArr = b.getStringArray("selectedItems");
        ListView lv = (ListView) findViewById(R.id.outputList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, resultArr);
        lv.setAdapter(adapter);

        Button submit = (Button) findViewById(R.id.submit_second_activity);
        ImageButton left = (ImageButton) findViewById(R.id.leftButton);
        ImageButton right = (ImageButton) findViewById(R.id.rightButton);
        Button home = (Button) findViewById(R.id.homebutton3);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMe(v);
                openNextPage(All_Cases.class);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(Activity_Information.class);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(CaseActivity.class);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(MainActivity.class);
            }
        });

    }

    public void toastMe(View view){
        // Toast myToast = Toast.makeText(this, message, duration);
        Toast myToast = Toast.makeText(this, "You submitted!",
                Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void openNextPage(final Class<? extends Activity> ActivityToOpen){
        Intent intent = new Intent(this, ActivityToOpen);
        startActivity(intent);
    }

}

package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String PhoneNumber, password;
    EditText phoneInput;
    EditText passInput;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneInput = (EditText) findViewById(R.id.phoneNum);
        passInput = (EditText) findViewById(R.id.password);

        submit = (Button) findViewById(R.id.submitbutton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneNumber = phoneInput.getText().toString();
                password = passInput.getText().toString();

                toastMe(v);
            }
        });
    }

    /*public void login(View view){
        phoneInput = (EditText) findViewById(R.id.phoneNum);
        passInput = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submitbutton);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void OnClick(view) {
                PhoneNumber = phoneInput.getText().toString();
                password = passInput.getText().toString();

                toastMe(view);
            }
        });
    }*/

    public void toastMe(View view){
        // Toast myToast = Toast.makeText(this, message, duration);
        Toast myToast = Toast.makeText(this, "You submitted",
                Toast.LENGTH_SHORT);
        myToast.show();
    }


    /*public void countMe (View view) {
        // Get the text view.
        TextView showCountTextView = (TextView)
                findViewById(R.id.welcome);

        // Get the value of the text view.
        String countString = showCountTextView.getText().toString();

        // Convert value to a number and increment it.
        Integer count = Integer.parseInt(countString);
        count++;

        // Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }

    private static final String TOTAL_COUNT = "total_count";

    public void randomMe (View view) {

        // Create an Intent to start the second activity
        Intent randomIntent = new Intent(this, SecondActivity.class);

        // Get the text view that shows the count.
        TextView showCountTextView = (TextView) findViewById(R.id.welcome);

        // Get the value of the text view.
        String countString = showCountTextView.getText().toString();

        // Convert the count to an int
        int count = Integer.parseInt(countString);

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(TOTAL_COUNT, count);

        // Start the new activity.
        startActivity(randomIntent);
    }*/

}

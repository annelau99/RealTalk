package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.IDNA;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class InfoPage_Activity extends AppCompatActivity {
    Button done, stop, sound, call;
    private MediaPlayer myMediaPlayer;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page_);
        done = findViewById(R.id.donebutton);
        sound = findViewById(R.id.start);
        stop = findViewById(R.id.stopbutton);
        call = findViewById(R.id.callbutton);
        myMediaPlayer = MediaPlayer.create(this, R.raw.translate_tts);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(AllCasesProcessed.class);
            }

        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateDialog();
            }
        });
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMediaPlayer.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                myMediaPlayer.pause();
            }
        });

        myMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //Toast.makeText(this,"I am done!", Toast.LENGTH_SHORT);
                ReleaseMediaPlayer();
            }
        });


    }

    //opens registration page
    public void openNextPage(final Class<? extends Activity> ActivityToOpen){
        Intent intent = new Intent(this, ActivityToOpen);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        ReleaseMediaPlayer();
    }

    private void ReleaseMediaPlayer(){
        if (myMediaPlayer == null){
            myMediaPlayer.release();
            myMediaPlayer = null;

        }
    }

    public void CreateDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to make a call?")
                    .setTitle("Hello")
                    .setPositiveButton("Yes (Call)", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
//                            finish();
//                            System.exit(0);
                             Intent intent = new Intent(Intent.ACTION_DIAL);
                             startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // CANCEL does nothing
                        }
                    });
            // Create the AlertDialog object and return it
            builder.create().show();
        }
}

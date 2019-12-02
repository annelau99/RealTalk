package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.IDNA;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class InfoPage_Activity extends AppCompatActivity {
    Button done, stop, sound;
    private MediaPlayer myMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page_);
        done = findViewById(R.id.donebutton);
        sound = findViewById(R.id.start);
        stop = findViewById(R.id.stopbutton);
        myMediaPlayer = MediaPlayer.create(this, R.raw.lethergo);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage(All_Cases.class);
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
}

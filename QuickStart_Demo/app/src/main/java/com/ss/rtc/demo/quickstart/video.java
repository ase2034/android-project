package com.ss.rtc.demo.quickstart;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class video extends AppCompatActivity {
    private Button buttonPlay;
    private Button buttonPause;
    private Button webvideo;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_video);
            buttonPause = findViewById(R.id.buttonPause);
            buttonPause.setOnClickListener(v -> videoView.pause());
            webvideo=findViewById(R.id.web);
            buttonPlay = findViewById(R.id.buttonPlay);
            buttonPlay.setOnClickListener(v -> videoView.start());
            videoView = findViewById(R.id.videoView);
           Uri uri= Uri.parse(Localvideo.path);
           String uri2 = "https://media.w3.org/2010/05/sintel/trailer.mp4";
            Uri uri1= Uri.parse(uri2);
           webvideo.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   videoView.setVideoURI(uri1);
                   videoView.start();
               }
           });
           videoView.setVideoURI(uri);
           videoView.start();
        }

        }
    }

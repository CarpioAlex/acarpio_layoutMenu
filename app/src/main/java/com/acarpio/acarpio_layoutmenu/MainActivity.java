package com.acarpio.acarpio_layoutmenu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });
    }

    // First menu option
    public void radioActivity(View view) {
        Intent intent = new Intent(this, RadioActivity.class);
        startActivity(intent);

    }

    public void weightActivity(View view) {
        Intent intent = new Intent(this, WeightActivity.class);
        startActivity(intent);
    }

    public void URLActivity(View view) {
        Intent intent = new Intent(this, URLActivity.class);
        startActivity(intent);
    }

    public void OverlapActivity(View view) {
        Intent intent = new Intent(this, OverlapActivity.class);
        startActivity(intent);
    }

    public void formActivity(View view) {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }






}
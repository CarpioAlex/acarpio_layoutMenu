package com.acarpio.acarpio_layoutmenu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OverlapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_overlap);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button bigButton = findViewById(R.id.bigButton);
        bigButton.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "BIG BUTTON Clicked", Toast.LENGTH_SHORT).show();

        });

        Button smallButton = findViewById(R.id.smallButton);
        smallButton.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "SMALL BUTTON Clicked", Toast.LENGTH_SHORT).show();
        });

    }




}
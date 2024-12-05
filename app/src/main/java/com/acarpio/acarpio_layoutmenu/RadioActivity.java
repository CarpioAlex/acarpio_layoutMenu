package com.acarpio.acarpio_layoutmenu;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup orientationGroup;
    RadioGroup gravityGroup;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.radiomain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        orientationGroup = findViewById(R.id.orientationGroup);
        gravityGroup = findViewById(R.id.gravityGroup);

        orientationGroup.setOnCheckedChangeListener(this);
        gravityGroup.setOnCheckedChangeListener(this);

        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    checkBox.setText("Not checked");
                } else {
                    checkBox.setText("Checked");
                }
            }
        });


    }
    // Radio actions
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.horizontal) {
            orientationGroup.setOrientation(RadioGroup.HORIZONTAL);
        } else if (checkedId == R.id.vertical) {
            orientationGroup.setOrientation(RadioGroup.VERTICAL);
        } else if (checkedId == R.id.left) {
            gravityGroup.setGravity(android.view.Gravity.LEFT);
        } else if (checkedId == R.id.center) {
            gravityGroup.setGravity(android.view.Gravity.CENTER);
        } else if (checkedId == R.id.right) {
            gravityGroup.setGravity(android.view.Gravity.RIGHT);
        }
        }



}
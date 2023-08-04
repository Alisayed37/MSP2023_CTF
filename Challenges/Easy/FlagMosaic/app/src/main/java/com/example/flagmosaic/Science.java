package com.example.flagmosaic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Science extends AppCompatActivity {
    private TextView ScienceView , flag_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);
        ScienceView = findViewById(R.id.ScienceView);
        ScienceView.setText("Natural world exploration through experiments.   \uD83C\uDF04  ");
        flag_1 = findViewById(R.id.flag_1);
        flag_1.setText("MSPCTF{m461c4l");
    }
}
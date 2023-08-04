package com.example.flagmosaic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Music extends AppCompatActivity {
    private TextView MusicView,flag_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        MusicView = findViewById(R.id.MusicView);
        MusicView.setText("Musical expression through instruments or vocals.     \uD83C\uDFBB");
        flag_2 = findViewById(R.id.flag_2);
        flag_2.setText("_cl455_");
    }
}
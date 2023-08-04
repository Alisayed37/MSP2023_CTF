package com.example.flagmosaic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class Philosophy extends AppCompatActivity {
    private TextView PhilosophyView ,flag_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_philosophy);
        PhilosophyView = findViewById(R.id.PhilosophyView);
        PhilosophyView.setText("Study of fundamental questions about existence. \uD83D\uDCAD");
        flag_3 = findViewById(R.id.flag_3);
        flag_3.setText("h4ck3r}");
    }
}
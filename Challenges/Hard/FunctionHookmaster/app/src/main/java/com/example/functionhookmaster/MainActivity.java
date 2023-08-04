package com.example.functionhookmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        login = findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Admin()){
                    textView.setTextColor(Color.BLUE);
                    textView.setText(Utilities.getFlag());
                }
                else {
                    textView.setTextColor(Color.RED);
                    textView.setText("You are not the Admin 😎");
                }
            }
        });
    }
    private boolean Admin(){
        return false;
    }
}
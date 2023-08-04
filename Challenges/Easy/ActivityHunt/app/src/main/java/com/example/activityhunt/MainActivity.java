package com.example.activityhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button Submit;
    private TextView res;
    private EditText Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Password = findViewById(R.id.editPassword);
        Submit = findViewById(R.id.btnSubmit);
        res = findViewById(R.id.textView2);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(Password.toString());
                if (Password.getText().toString().equals("SecretPassword1234")){
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                }
                else {
                    res.setText("Wrong Password");
                }
            }
        });
    }
}
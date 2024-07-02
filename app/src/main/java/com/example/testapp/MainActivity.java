package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonStart;
    Button buttonInfoApp;
    Button buttonQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart=findViewById(R.id.btn_start);
        buttonInfoApp=findViewById(R.id.btn_infoApp);
        buttonQuit=findViewById(R.id.btn_quit);


        buttonQuit.setOnClickListener(view -> {
            finish();
        });

        Intent intent=new Intent(this,InfoScreen.class);
        buttonInfoApp.setOnClickListener(view -> {
            startActivity(intent);
        });


        buttonStart.setOnClickListener(view -> {
            Intent intent1=new Intent(this,TestScreen.class);
            startActivity(intent1);
        });


    }
}
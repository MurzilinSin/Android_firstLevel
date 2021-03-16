package com.example.appforfirsthomework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button btnBack;
    //Первое домашнее задание
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        initViews();
        clickOnBtnBack();
    }

    private void initViews(){
        btnBack = findViewById(R.id.btnJumpBack);
    }

    private void clickOnBtnBack(){
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}

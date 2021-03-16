package com.example.appforfirsthomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener  {
    private TextView changingText;
    private TextView checkBoxTitle;
    private EditText editText;
    private Button button;
    private Button btnNextWork;
    private ToggleButton toggleButton;
    private Switch switchDark;
    private CheckBox checkBox;
    private CheckBox checkBox2;
    private ScrollView scrollView;
    //Первое домашнее задание
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElements();
        switchDark.setOnCheckedChangeListener(this);
        setTextOnBtnClick();
        disabledBtnOnClick();
        moveToNextScreen();
    }

    private void initElements(){
        changingText = findViewById(R.id.changingText);

        checkBoxTitle = findViewById(R.id.checkBoxTitle);
        editText = findViewById(R.id.editText);

        button = findViewById(R.id.button);
        btnNextWork = findViewById(R.id.btnNextWork);

        toggleButton = findViewById(R.id.toggleButton);
        switchDark = findViewById(R.id.switchDark);

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);

        scrollView = findViewById(R.id.scroll);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int colorResWhite = R.color.white;
        int colorResDark = R.color.dark;
        int colorWhite = ContextCompat.getColor(getApplicationContext(),colorResWhite);
        int colorDark = ContextCompat.getColor(getApplicationContext(),colorResDark);
        if (isChecked) {
            scrollView.setBackgroundColor(colorDark);
            setAllTextOneColor(colorWhite);
        } else {
            scrollView.setBackgroundColor(colorWhite);
            setAllTextOneColor(colorDark);
        }
    }

    private void setTextOnBtnClick(){
        button.setOnClickListener(v -> {
            int colorRes = R.color.purple_500;
            int color = ContextCompat.getColor(getApplicationContext(),colorRes);
            String text = editText.getText().toString().trim();
            changingText.setText(text);
            changingText.setTextColor(color);
            editText.setText("");
        });
    }

    private void setAllTextOneColor(int color){
        switchDark.setTextColor(color);
        checkBoxTitle.setTextColor(color);
        checkBox.setTextColor(color);
        checkBox2.setTextColor(color);

    }

    private void disabledBtnOnClick(){
        toggleButton.setOnClickListener(v -> {
            boolean isChecked = toggleButton.isChecked();
            if(isChecked){
                button.setEnabled(false);
            }
            else{
                button.setEnabled(true);
            }
        });
    }

    private void moveToNextScreen() {
        btnNextWork.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
}
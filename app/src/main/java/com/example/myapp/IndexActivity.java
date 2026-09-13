package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IndexActivity extends AppCompatActivity {

    private Button mCurrencyButton;
    private Button mSignUpButton;
    private Button mListViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_index);

        initView();
        setListener();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setListener() {
        mCurrencyButton.setOnClickListener(this::handleButtonClick);
        mSignUpButton.setOnClickListener(this::handleButtonClick);
        mListViewButton.setOnClickListener(this::handleButtonClick);
    }

    private void initView() {
        mCurrencyButton = findViewById(R.id.buttonCurrency);
        mSignUpButton = findViewById(R.id.buttonSignUpForm);
        mListViewButton = findViewById(R.id.buttonListView);
    }

    private void handleButtonClick(View view) {

        int id = view.getId();

        if (id == R.id.buttonCurrency){
            navigateRoute(SignUpAactivity.class);
        } else if (id == R.id.buttonSignUpForm) {
            navigateRoute(CurrencyConverterActivity.class);
        }else if (id == R.id.buttonListView){
            navigateRoute(ListViewActivity.class);
        }
    }

    private void navigateRoute(Class<?> activityClass){
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

//    private void handleSignUpClick() {
//        Intent intent = new Intent(this, SignUpAactivity.class);
//        startActivity(intent);
//    }
//
//    private void handleCurrencyClick() {
//        Intent intent = new Intent(this, CurrencyConverterActivity.class);
//        startActivity(intent);
//
//    }
}
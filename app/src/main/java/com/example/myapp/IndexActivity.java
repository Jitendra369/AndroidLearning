package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapp.dto.Place;

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
            Place place = new Place("Bhakti-Dham","Chandur Bazar");
            navigateRoute(CurrencyConverterActivity.class, place);
        } else if (id == R.id.buttonSignUpForm) {
            navigateRoute(SignUpAactivity.class, null);
        }else if (id == R.id.buttonListView){
            navigateRoute(ListViewActivity.class, null);
        }
    }

    private void navigateRoute(Class<?> activityClass, Parcelable object){
        Intent intent = new Intent(this, activityClass);
        if (object != null){
            intent.putExtra("place", object);
        }
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
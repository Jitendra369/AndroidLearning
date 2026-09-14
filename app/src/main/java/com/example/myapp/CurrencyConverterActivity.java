package com.example.myapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapp.dto.Place;

public class CurrencyConverterActivity extends AppCompatActivity {

    private EditText mEditTextUserInput;
    private TextView mTextViewConvertedValue;
    private Button mButtonConvertValue;
    private Spinner mSpinnerCurrValues;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_currency_converter);

        initView();
        setupSpinner();
        setListners();
        getInputFomPreviousActivity();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void getInputFomPreviousActivity() {
        Intent receivedPlace = getIntent();
        if (receivedPlace != null){
            Place place = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                place = receivedPlace.getParcelableExtra("place", Place.class);
            }
            Toast.makeText(this, "Place : "+ place.getName()+ ", City: "+ place.getCity(), Toast.LENGTH_SHORT).show();
        }
    }


    private void setListners() {
        mButtonConvertValue.setOnClickListener(view -> {
            convertCurrency();
        });

        mSpinnerCurrValues.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedCurrency = parent.getItemAtPosition(position).toString();
                        // handle selection
                        onCurrencySelected(selectedCurrency);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );
    }

    private void onCurrencySelected(String selectedCurrency) {
        Toast.makeText(this, "user selected :" + selectedCurrency, Toast.LENGTH_SHORT).show();
    }


    private void convertCurrency() {
        // handle the logic
        Editable userInputText = mEditTextUserInput.getText();
        String amountText = userInputText.toString().trim();
        if (amountText.isEmpty()) {
            mEditTextUserInput.setError("Please Enter amount");
            return;
        }
        double rupees = Double.parseDouble(amountText);
        double result = 0;
        String selectedCurrencyValue = mSpinnerCurrValues.getSelectedItem().toString();
        switch (selectedCurrencyValue) {
            case "USD":
                result = rupees / 83;
                break;
            case "EUR":
                result = rupees / 90;
                break;
            case "JPY":
                result = rupees / 105;
                break;
            default:
                result = 0;
        }
        mTextViewConvertedValue.setText(String.format("%.2f %s", result, amountText));
    }

    private void setupSpinner() {
        ArrayAdapter<CharSequence> adaptor = ArrayAdapter.createFromResource(
                this,
                R.array.currency_category,
                android.R.layout.simple_spinner_item
        );
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerCurrValues.setAdapter(adaptor);
    }

    private void initView() {
        mEditTextUserInput = findViewById(R.id.editTextInputInRupees);
        mTextViewConvertedValue = findViewById(R.id.textViewFinalConvertValue);
        mButtonConvertValue = findViewById(R.id.buttonConvert);
        mSpinnerCurrValues = findViewById(R.id.spinnerCategory);
    }
}
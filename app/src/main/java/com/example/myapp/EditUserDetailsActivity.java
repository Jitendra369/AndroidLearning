package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditUserDetailsActivity extends AppCompatActivity {


    private EditText mEditTextEditUserName;
    private Button mButtonSaveUpdatedDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_user_details);

        viewInit();
        setListener();
        // set data from main-activity
        setData();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setData() {
        String place = getIntent().getStringExtra("place");
        mEditTextEditUserName.setText(place);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart called");
//        mEditTextEditUserName.setText();
    }

    private void viewInit() {
        mEditTextEditUserName = findViewById(R.id.edittextEditUserName);
        mButtonSaveUpdatedDetails = findViewById(R.id.buttonSaveEditedUserName);
    }

    private void setListener() {
        mButtonSaveUpdatedDetails.setOnClickListener(this::handleClickListener);
    }

    // handle click
    private void handleClickListener(View view) {
        int id = view.getId();
        if (id == R.id.buttonSaveEditedUserName){
            String editedPlace = mEditTextEditUserName.getText().toString();
            if (editedPlace.isEmpty()){
                Log.d(EditUserDetailsActivity.class.getName(),"updated edit place is null");
            }
            Intent intentResult = new Intent();
            intentResult.putExtra("updatedPlace",editedPlace);
            // set the result back to the activity
            setResult(RESULT_OK, intentResult);
            // close the current activity
            finish();
        }
    }


}
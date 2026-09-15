package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapp.dto.UserDetailsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SignUpAactivity extends AppCompatActivity {

    // signUp form Fields
    private EditText    mEditTextFullName;
    private EditText    mEditTextEmail;
    private EditText    mEditTextPassword;
    private EditText    mEditTextConformPassword;
    private TextView    mTextViewErrorMessage;
    private Button      mButtonSignUp;
    private RadioGroup  mRadioGroupGender;

    //    show SignUp form details
    private TextView    mTextViewShowFullName;
    private TextView    mTextViewShowEmail;
    private TextView    mTextViewShowPassword;
    private TextView    mTextViewGender;
    private RadioButton mGenderRadioButton;
    private CheckBox    mCheckBoxJava;
    private CheckBox    mCheckBoxAndroid;
    private CheckBox    mCheckBoxSpringBoot;
    private TextView    mTextViewLanguage;
    private Button      mButtonEditUserDetails;
    private ListView    mListViewUserDetails;
    private List<String> userList = new ArrayList<>();
    private ArrayAdapter<String> userDetailsAdaptors;

    ActivityResultLauncher<Intent> editPlaceLauncher;

    private List<UserDetailsDto> userDetailsDtoList = new ArrayList<>();

    private final String TAG = this.getClass().getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up_aactivity);

        initView();
        setAdaptors();
        setLiner();
        editUserDetailsLauncher();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setAdaptors() {

        userDetailsAdaptors = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                userList
        );
        mListViewUserDetails.setAdapter(userDetailsAdaptors);

//        mListViewUserDetails.setOnItemClickListener((parent, view, position, id) -> {
//            String selectedPlaces = userList.get(position);
//            Toast.makeText(this,"You have selected "+ selectedPlaces,Toast.LENGTH_SHORT).show();
//        });
    }

    // execute the code , after returning from editUserDetails activity
    private void editUserDetailsLauncher() {
        editPlaceLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result ->{
                    if (result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                        if (data != null){
                            String updatedPlace = data.getStringExtra("updatedPlace");
                            Toast.makeText(this,"updated "+ updatedPlace, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    private void setLiner() {
        mButtonSignUp.setOnClickListener(this::handleClick);
//        mButtonEditUserDetails.setOnClickListener(this::handleClick);

    }

    private void initView() {
        mEditTextFullName =             findViewById(R.id.editTextFullName);
        mEditTextEmail =                findViewById(R.id.editTextEmail);
        mEditTextPassword =             findViewById(R.id.editTextPassword);
        mEditTextConformPassword =      findViewById(R.id.editTextConfirmPassword);
        mButtonSignUp =                 findViewById(R.id.buttonSaveUserDetails);
        mTextViewErrorMessage =         findViewById(R.id.textView_error_message_sign);

//        mTextViewShowFullName =         findViewById(R.id.textViewShowFullName);
//        mTextViewShowEmail =            findViewById(R.id.textViewShowEmail);
//        mTextViewShowPassword =         findViewById(R.id.textViewShowPassword);
//        mTextViewGender =               findViewById(R.id.textViewGender);
        mRadioGroupGender =             findViewById(R.id.radionGroupGender);
        mCheckBoxJava =                 findViewById(R.id.checkBoxLangJava);
        mCheckBoxAndroid =              findViewById(R.id.checkBoxLangAndroid);
        mCheckBoxSpringBoot =           findViewById(R.id.checkBoxLangSpringboot);
//        mTextViewLanguage =             findViewById(R.id.textViewLangaugeOptions);
//        mButtonEditUserDetails =        findViewById(R.id.buttonEditUserDetails);
        mListViewUserDetails =          findViewById(R.id.listViewUserDetails);

    }

    private void handleClick(View view) {
        int id = view.getId();
        if (id == 0) {
            return;
        }
        if (id == R.id.buttonSaveUserDetails) {
            UserDetailsDto userDetailsDto = validateInputFields();
            if (userDetailsDto != null) {
                setDataView(userDetailsDto);
            } else {
            }
        }
//        if (id == R.id.buttonEditUserDetails){
//            // start the activity for result
//            Intent intent = new Intent(this, EditUserDetailsActivity.class);
//            intent.putExtra("place","Mumbai");
//            editPlaceLauncher.launch(intent);
//        }
    }

    private void setDataView(UserDetailsDto userDetailsDto) {
        Log.d(TAG, "setting value to formData");

        userDetailsDtoList.add(userDetailsDto);
        userList.add(userDetailsDto.getFullName());
        userDetailsAdaptors.notifyDataSetChanged();

//        mTextViewShowFullName.setText(userDetailsDto.getFullName());
//        mTextViewShowEmail.setText(userDetailsDto.getEmail());
//        mTextViewShowPassword.setText(userDetailsDto.getPassword());
//        mTextViewGender.setText(userDetailsDto.getGender());
//        mTextViewLanguage.setText(userDetailsDto.getLanguages());

//        int selectedRadioButtonId = mRadioGroupGender.getCheckedRadioButtonId();
//        if (selectedRadioButtonId == -1) {
//            publishToastMessage("Please selected Gender");
//        } else {
//            RadioButton genderRadioButton = findViewById(selectedRadioButtonId);
//            String gender = genderRadioButton.getText().toString();
//            mTextViewGender.setText(gender);
//        }

    }

    private void publishToastMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }


    private UserDetailsDto validateInputFields() {
        int selectedGenderId = mRadioGroupGender.getCheckedRadioButtonId();

        if (selectedGenderId == -1) {
            setErrorMessageField("Please select Gender", View.VISIBLE);
            return null;
        }
        mGenderRadioButton = findViewById(selectedGenderId);

        StringBuilder selectedLanguageOptions = new StringBuilder();
        if (mCheckBoxJava.isChecked()){
            selectedLanguageOptions.append("Java");
        }
        if (mCheckBoxAndroid.isChecked()){
            selectedLanguageOptions.append("Android");
        }
        if (mCheckBoxSpringBoot.isChecked()){
            selectedLanguageOptions.append("SpringBoot");
        }


        UserDetailsDto userDetails = getUserDetailsDto(selectedLanguageOptions);

        if (checkEmptyValueValidation(userDetails) && checkPassEqualsCond(userDetails)) {
            setErrorMessageField(" ", View.INVISIBLE);
            return userDetails;
        }
        return null;

    }

    private UserDetailsDto getUserDetailsDto(StringBuilder selectedLanguageOptions) {
        return new UserDetailsDto.Builder()
                .fullName(mEditTextFullName.getText() != null ? mEditTextFullName.getText().toString().trim() : "")
                .email(mEditTextEmail.getText() != null ? mEditTextEmail.getText().toString().trim() : "")
                .password(mEditTextPassword.getText() != null ? mEditTextPassword.getText().toString().trim() : "")
                .conformPassword(mEditTextConformPassword.getText() != null ? mEditTextConformPassword.getText().toString().trim() : "")
                .gender(mGenderRadioButton.getText().toString())
                .languages(selectedLanguageOptions.toString())
                .build();
    }


    private boolean checkEmptyValueValidation(UserDetailsDto userDetails) {
        if (userDetails.getFullName().isEmpty() || userDetails.getEmail().isEmpty() || userDetails.getPassword().isEmpty() || userDetails.getConformPassword().isEmpty()) {
            setErrorMessageField(getString(R.string.all_feild_are_mandatory_here), View.VISIBLE);

            return false;
        }
        return true;
    }

    private boolean checkPassEqualsCond(UserDetailsDto userDetails) {
        if (!userDetails.getPassword().equals(userDetails.getConformPassword())) {
            setErrorMessageField(getString(R.string.password_fields_are_not_matched), View.VISIBLE);
            return false;
        }
        return true;
    }

    private void setErrorMessageField(String message, int visibility) {
        mTextViewErrorMessage.setText(message);
        mTextViewErrorMessage.setVisibility(visibility);
    }

    private void logMessage(String message) {
        Log.d(TAG, message);
    }
}
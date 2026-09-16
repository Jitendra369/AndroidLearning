package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapp.adaptor.UserAdaptor;
import com.example.myapp.dto.User;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {


    private ListView mListViewUser;
    private List<User> userList;
    private UserAdaptor userAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list_view);

        userList = new ArrayList<>();
        loadSampleUserDetails();
        viewInit();

        userAdaptor = new UserAdaptor(this, userList);
        mListViewUser.setAdapter(userAdaptor);

        mListViewUser.setOnItemClickListener((parent, view, position, id) -> {
            User user = userList.get(position);
            Toast.makeText(this,"user selected "+ user.getName(), Toast.LENGTH_SHORT).show();
        });


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }



    private void loadSampleUserDetails() {
        userList.add(
                new User(
                        "Rahul",
                        "rahul@gmail.com",
                        "Male",
                        R.drawable.user_12
                )
        );

        userList.add(
                new User(
                        "Amit",
                        "amit@gmail.com",
                        "Male",
                        R.drawable.user_31267
                )
        );

        userList.add(
                new User(
                        "Sneha",
                        "sneha@gmail.com",
                        "Female",
                        R.drawable.user_181761
                )
        );

        userList.add(
                new User(
                        "Priya",
                        "priya@gmail.com",
                        "Female",
                        R.drawable.user_342664
                )
        );
    }

    private void viewInit() {
        mListViewUser = findViewById(R.id.listViewUsers);
    }
}
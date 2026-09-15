package com.example.myapp.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapp.R;
import com.example.myapp.dto.User;

import java.util.List;

public class UserAdaptor extends ArrayAdapter<User> {

    public UserAdaptor(@NonNull Context context, List<User> users) {
        super(context, 0,users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);

        // create a row
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_user, // Use your custom layout name here
                    parent,             // The ListView is the parent
                    false               // Do NOT attach to root yet
            );
        }

        // find view
        TextView textViewUsername  = convertView.findViewById(R.id.textViewLvName);
        TextView textViewEmail  = convertView.findViewById(R.id.textViewLvEmail);
        TextView textViewGender  = convertView.findViewById(R.id.textViewLvGender);

        // set data
        textViewUsername.setText(user.getName());
        textViewEmail.setText(user.getEmail());
        textViewGender.setText(user.getGender());

        return convertView;
    }
}

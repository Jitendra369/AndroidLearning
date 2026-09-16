package com.example.myapp.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapp.R;
import com.example.myapp.dto.User;

import java.util.List;

public class UserAdaptor extends ArrayAdapter<User> {

    public UserAdaptor(@NonNull Context context, List<User> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);
        ViewHolder viewHolder;

        // create a row
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_user, // Use your custom layout name here
                    parent,             // The ListView is the parent
                    false               // Do NOT attach to root yet
            );
            viewHolder = new ViewHolder();
            // find view
//        TextView textViewUsername = convertView.findViewById(R.id.textViewLvName);
//        TextView textViewEmail = convertView.findViewById(R.id.textViewLvEmail);
//        TextView textViewGender = convertView.findViewById(R.id.textViewLvGender);
//        ImageView imageViewUser = convertView.findViewById(R.id.imageViewUser);
            viewHolder.name = convertView.findViewById(R.id.textViewLvName);
            viewHolder.email = convertView.findViewById(R.id.textViewLvEmail);
            viewHolder.gender = convertView.findViewById(R.id.textViewLvGender);
            viewHolder.imageView = convertView.findViewById(R.id.imageViewUser);
            // 3. Store the holder in the view's tag
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

// 5. Bind the data to the views via the holder
        if (user != null) {
            // set data
            viewHolder.name.setText(user.getName());
            viewHolder.email.setText(user.getEmail());
            viewHolder.gender.setText(user.getGender());
            // setting image
            viewHolder.imageView.setImageResource(user.getImageResId());
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView email;
        TextView gender;
        ImageView imageView;
    }
}

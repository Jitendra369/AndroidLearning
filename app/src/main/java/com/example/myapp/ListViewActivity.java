package com.example.myapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {


    private ListView mListViewPlacesToVisit;
    private List<String> placesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);

        viewInit();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void viewInit() {
        initListView();
    }

    private void initListView() {
        mListViewPlacesToVisit = findViewById(R.id.listViewPlaces);
        String[] places = getResources()
                .getStringArray(R.array.india_top_destinations);
        placesList = new ArrayList<>(Arrays.asList(places));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                placesList
        );
        mListViewPlacesToVisit.setAdapter(arrayAdapter);
        mListViewPlacesToVisit.setOnItemClickListener((parent, view, position, id) -> {
            String selectedPlaces = places[position];
            Toast.makeText(this,"You have selected "+ selectedPlaces,Toast.LENGTH_SHORT).show();
        });

        mListViewPlacesToVisit.setOnItemLongClickListener((parent, view, position, id) -> {
            String selectedPlace = placesList.get(position);
            PopupMenu popupMenu = new PopupMenu(this, view);
            popupMenu.getMenu().add("Delete : " + selectedPlace);
            popupMenu.getMenu().add("Edit :" + selectedPlace);

            popupMenu.setOnMenuItemClickListener( item -> {
                if (item.getTitle().toString().contains("Delete")){
                    placesList.remove(position);
                    arrayAdapter.notifyDataSetChanged();
                    Toast.makeText(this, "deleted : "+ selectedPlace, Toast.LENGTH_SHORT);
                    return true;
                } else if (item.getTitle().toString().contains("Edit")) {
                    // edit the row in the list
                    EditText editText = new EditText(this);
                    editText.setText(selectedPlace);
                    new AlertDialog.Builder(this)
                            .setTitle("Edit Place")
                            .setView(editText)
                            .setNegativeButton("Cancel", null)
                            .setPositiveButton("Save", ((dialog, which) -> {
                                String editedPlace = editText.getText().toString().trim();
                                if (!editedPlace.isEmpty()){
                                    placesList.set(position, editedPlace);
                                    arrayAdapter.notifyDataSetChanged();
                                    Toast.makeText(this,"list has been updated ", Toast.LENGTH_SHORT).show();
                                }
                            }))
                            .show();
                }
                return false;
            });
            popupMenu.show();
            return true;
        });
    }

    private void handleClick(View view){
        int id = view.getId();
//        if (id == R.id.listViewPlaces){
//
//        }
    }
}
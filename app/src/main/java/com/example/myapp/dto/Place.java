package com.example.myapp.dto;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class Place implements Parcelable {

    private String name;
    private String city;

    public Place(String name, String city) {
        this.name = name;
        this.city = city;
    }

    // FIX 1: Added 'Parcel in' as a parameter so it can read the data
    protected Place(Parcel in) {
        name = in.readString();
        city = in.readString();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            // FIX 2: Pass the 'in' parcel to the constructor
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        // The order here MUST match the order in the constructor above
        dest.writeString(name);
        dest.writeString(city);
    }
}
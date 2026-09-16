package com.example.myapp.dto;

import java.util.List;

public class User {

    private String name;
    private String email;
    private String password;
    private String gender;
    private int imageResId;
    private List<String> lang;

    public User() {
    }

    public User(String name, String email, String gender, int imageResId) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.imageResId = imageResId;
    }

    public User(String name, String email, String password, String gender, List<String> lang) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.lang = lang;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getLang() {
        return lang;
    }

    public void setLang(List<String> lang) {
        this.lang = lang;
    }
}

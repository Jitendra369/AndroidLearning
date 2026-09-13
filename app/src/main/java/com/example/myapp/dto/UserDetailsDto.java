package com.example.myapp.dto;

import java.util.List;

public class UserDetailsDto {

    private String fullName;
    private String email;
    private String password;
    private String conformPassword;
    private String gender;
    private String languages;

    public UserDetailsDto() {
    }

    private UserDetailsDto(Builder builder) {
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.password = builder.password;
        this.conformPassword = builder.conformPassword;
        this.gender = builder.gender;
        this.languages = builder.languages;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConformPassword() {
        return conformPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static class Builder {

        private String fullName;
        private String email;
        private String password;
        private String conformPassword;
        private String gender;
        private String languages;


        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder languages(String languages){
            this.languages = languages;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder conformPassword(String conformPassword) {
            this.conformPassword = conformPassword;
            return this;
        }

        public UserDetailsDto build() {
            return new UserDetailsDto(this);
        }
    }
}
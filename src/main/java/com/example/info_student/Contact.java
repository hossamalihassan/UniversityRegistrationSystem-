package com.example.info_student;

public class Contact {

    String email;
    String homeNumber;
    String mobileNumber;

    public void setContact(String email, String homeNumber, String mobileNumber){
        this.email = email;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
    }


    public String getEmail() {
        return email;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}

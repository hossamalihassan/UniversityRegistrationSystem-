package com.example.info_student;


public class Name {

    String firstName, middleName, lastName;

    String fullName;

   public void setName(String firstName, String middleName, String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return firstName + " " + middleName.charAt(0) + ". " + lastName;
    }
}

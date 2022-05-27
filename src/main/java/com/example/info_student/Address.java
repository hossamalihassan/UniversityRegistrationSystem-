package com.example.info_student;

import java.util.HashMap;

public class Address {
    HashMap<String, String> homeAddress;
    String address;

    Address() {
        this.homeAddress = new HashMap<>();
    }

    public void setHomeAddress(String houseNum, String flatNum, String streetName, String areaName, String cityName, String governorateName, String country, String postalCode) {
        homeAddress.put("houseNum", houseNum);
        homeAddress.put("flatNum", flatNum);
        homeAddress.put("streetName", streetName);
        homeAddress.put("areaName", areaName);
        homeAddress.put("cityName", cityName);
        homeAddress.put("governorateName", governorateName);
        homeAddress.put("countryName", country);
        homeAddress.put("postalCode", postalCode);
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getHomeAddress() {
        return homeAddress.toString();
    }

    public String getAddress() {
        return address;
    }
}

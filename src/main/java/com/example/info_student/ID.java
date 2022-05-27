package com.example.info_student;

import java.net.IDN;
import java.util.Scanner;

public class ID {

    String IDType;
    String IDNumber;
    int IDValidity;

    public void setID(String IDNumber, int IDValidity, String IDType) {
        this.IDType = IDType;
        this.IDNumber = IDNumber;
        this.IDValidity = IDValidity;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public int getIDValidity() {
        return IDValidity;
    }

    public String getIDType() {
        return IDType;
    }
}

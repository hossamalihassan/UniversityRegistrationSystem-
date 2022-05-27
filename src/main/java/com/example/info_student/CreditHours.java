package com.example.info_student;

import java.util.Scanner;

public class CreditHours {

    int finishedHours;
    int remainingHours;


    public void setCreditHours(int finishedHours){
        this.finishedHours = finishedHours;
        this.remainingHours = 120 - finishedHours;
    }

    public int getFinishedHours() {
        return finishedHours;
    }
}

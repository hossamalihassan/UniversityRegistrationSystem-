package com.example.info_student;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Scanner;

public class Age {
    int day;
    int month;
    int year;

    int age;

    public void setBirthday(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int calcAge() {
        LocalDate dateOfBirth = LocalDate.of(this.year, this.month, this.day);
        LocalDate now = LocalDate.now();

        return (Period.between(dateOfBirth, now)).getYears();
    }
}

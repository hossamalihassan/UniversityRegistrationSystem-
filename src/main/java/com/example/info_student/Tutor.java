package com.example.info_student;

import java.util.Scanner;

public class Tutor {

    String tutorName;
    String tutorCode;

    public void setTutor(String tutorName, String tutorCode){
        this.tutorName = tutorName;
        this.tutorCode = tutorCode;
    }

    public String getTutorInfo() {
        return tutorName + " - " + tutorCode;
    }
}

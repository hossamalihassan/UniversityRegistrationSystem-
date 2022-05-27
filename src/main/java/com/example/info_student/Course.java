package com.example.info_student;

import java.util.Random;

public class Course {

    String courseCode;
    String courseName;
    int numberOfTimesTakingThisCourse;
    int semesterTakingThisCourseIn;
    float seventhMark;
    float twelfthMark;
    float yearWork;
    float finalExam;
    float total;
    float grade;
    float studentAbsencePercentage;

    Course(String name, String code){
        this.courseName = name;
        this.courseCode = code;
    }



}

package com.example.info_student;

public class Courses {

    String finishedCourses, currentCourses;
    public void setCourses(String finishedCourses, String currentCourses) {
        this.currentCourses = currentCourses;
        this.finishedCourses = finishedCourses;
    }

    public String getCurrentCourses() { return currentCourses; }

    public String getFinishedCourses() { return finishedCourses; }
}

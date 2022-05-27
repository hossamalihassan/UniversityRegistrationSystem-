package com.example.info_student;

public class StudentRegistrationNumber {


    StringBuffer regNumberGenerated;
    String RegNum;

    StudentRegistrationNumber() {}

    public void setStudentRegistrationNumber(String num){
        this.RegNum = num;
    }

    public void generateRegNumber(int year, int term, int facultyNum, int departmentNum, int studentNum) {
        regNumberGenerated = new StringBuffer();
        regNumberGenerated.append(year);
        regNumberGenerated.append(term);
        regNumberGenerated.append(facultyNum);
        regNumberGenerated.append(departmentNum);
        regNumberGenerated.append(String.format("%04d", studentNum));
        RegNum = regNumberGenerated.toString();
    }

    public String getRegNum() {
        return RegNum;
    }


}

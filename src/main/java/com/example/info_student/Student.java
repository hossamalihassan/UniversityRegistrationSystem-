package com.example.info_student;

import java.sql.*;

public class Student {

    int studentsNum;

    // personal info
    Name studentName;
    Gender gender;
    Nationality nationality;
    ID id;
    Age studentAge;

    // Address
    Address homeAddress;
    Address mailingAddress;

    // College Info
    FirstEnrolmentYear firstEnrolmentYear;
    Department department;
    Tutor tutor_info;
    GPA studentGPA;
    CreditHours creditHrs;
    CurrentTerm currentTerm;
    StudentRegistrationNumber regNumber;

    // payments
    Payments payments;

    // Courses
    Courses courses;

    // contact info
    Contact contact;

    public Student() {
        this.courses = new Courses();
        this.studentName = new Name();
        this.studentAge = new Age();
        this.nationality = new Nationality();
        this.id = new ID();
        this.gender = new Gender();
        this.homeAddress = new Address();
        this.tutor_info = new Tutor();
        this.department = new Department();
        this.studentGPA = new GPA();
        this.creditHrs = new CreditHours();
        this.mailingAddress = new Address();
        this.currentTerm = new CurrentTerm();
        this.firstEnrolmentYear = new FirstEnrolmentYear();
        this.regNumber = new StudentRegistrationNumber();
        this.payments = new Payments();
        this.contact = new Contact();
    }

    public void setPersonalInfo(String firstName, String middleName, String lastName, String gender, String nationality, int day, int month, int year, String idType, String idNum, int idValidity) {
        this.studentName.setName(firstName, middleName, lastName);
        this.gender.setGender(gender);
        this.nationality.setNationality(nationality);
        this.studentAge.setBirthday(day, month, year);
        this.id.setID(idNum, idValidity, idType);
    }

    public void setPersonalInfoFromDatabase(String fullName, String gender, String nationality, int age, String idNum) {
        this.studentName.setFullName(fullName);
        this.gender.setGender(gender);
        this.nationality.setNationality(nationality);
        this.studentAge.setAge(age);
        this.id.setIDNumber(idNum);
    }

    public void setHomeAddress(String houseNum, String flatNum, String streetName, String areaName, String cityName, String governorateName, String country, String postalCode){
        homeAddress.setHomeAddress(houseNum, flatNum, streetName, areaName, cityName, governorateName, country, postalCode);
    }

    public void setHomeAddressFromDatabase(String address){
        homeAddress.setAddress(address);
    }

    public void setMailingAddress(String houseNum, String flatNum, String streetName, String areaName, String cityName, String governorateName, String country, String postalCode){
        mailingAddress.setHomeAddress(houseNum, flatNum, streetName, areaName, cityName, governorateName, country, postalCode);
    }

    public void setMailingAddressFromDatabase(String address){
        mailingAddress.setAddress(address);
    }

    public void setCollegeInfo(int firstEnrolmentYear, String department, String tutorName, String tutorCode, double GPA, int finishedHrs, int currentTerm) {
        this.firstEnrolmentYear.setFirstEnrolmentYear(firstEnrolmentYear);
        this.department.setDepartment(department);
        this.tutor_info.setTutor(tutorName, tutorCode);
        this.studentGPA.setGPA(GPA);
        this.creditHrs.setCreditHours(finishedHrs);
        this.currentTerm.setCurrentTerm(currentTerm);
    }

    public void setCollegeInfoFromDatabase(int firstEnrolmentYear, String department, double GPA, int finishedHrs, int currentTerm) {
        this.firstEnrolmentYear.setFirstEnrolmentYear(firstEnrolmentYear);
        this.department.setDepartment(department);
        this.studentGPA.setGPA(GPA);
        this.creditHrs.setCreditHours(finishedHrs);
        this.currentTerm.setCurrentTerm(currentTerm);
    }

    public void setRegNumber(String regNum) {
        regNumber.setStudentRegistrationNumber(regNum);
    }

    public void generateRegNum(int departmentNum, int studentNum, int currentTerm) {
        this.regNumber.generateRegNumber(2022, currentTerm, 25, departmentNum, studentNum);
    }

    public void setPayments(String typeOfFunding){
        this.payments.setPayments(typeOfFunding);
    }

    public void setPaymentsFromDatabase(String typeOfFunding, double amountPaid, int numPayments){
        this.payments.setPaymentsData(typeOfFunding, numPayments, amountPaid);
    }

    public void setCourses(String finishedCourses, String currentCourses){
        this.courses.setCourses(finishedCourses, currentCourses);
    }

    public void setContact(String email, String homeNumber, String mobileNumber) {
        this.contact.setContact(email, homeNumber, mobileNumber);
    }

    // get Personal Info
    public int getStudentAge() {return (studentAge.age);}
    public String getStudentName() {return studentName.fullName;}
    public String getNationality() {return nationality.nationality;}
    public String getIDNum() {return id.getIDNumber();}
    public String getGender() {return gender.getGender();}

    // get Address
    public String getHomeAddress() {return homeAddress.getAddress();}
    public String getMailingAddress() {return mailingAddress.getAddress();}

    // get college info
    public int getFirstYear() {return firstEnrolmentYear.getFirstYear();}
    public String getDepartment() {return department.getStudentDepartment();}
    public int getCurrentTerm() {return currentTerm.getCurrentTerm();}
    public double getGPA() {return studentGPA.getCGPA();}
    public int getCreditHrs() {return creditHrs.getFinishedHours();}

    // get payments
    public String getTypeOfFunding() {return payments.getTypeOfFunding();}
    public double getAmountPaid() {return payments.getTotalAmountPaid();}
    public int getNumPayments() {return payments.getPaymentsDoneNum();}

    // Courses
    public String getFinishedCourses() {return courses.getFinishedCourses();}
    public String getCurrentCourses() {return courses.getCurrentCourses();}

    // get Contact
    public String getEmail() {return contact.getEmail();}
    public String getPhoneNumber() {return contact.getHomeNumber();}
    public String getMobileNUmber() {return contact.getMobileNumber();}


    public void addStudentToDB() {
        try {
            Connection conn;
            String url = "jdbc:sqlite:database\\universitySystem.db";
            conn = DriverManager.getConnection(url);

            String addStudent = "INSERT INTO students" +
                    " (student_name , student_nationality , student_homeAddress ," +
                    " student_mailingAddress, student_age, student_gender," +
                    " student_firstEnrolmentYear, student_department, student_tutor," +
                    " student_currentTerm, student_typeOfFunding, student_totalAmountPaid," +
                    " student_paymentsNum, student_email, student_phoneNumber," +
                    " student_homeNumber, student_creditHours, student_GPA," +
                    " student_idNumber, student_idValid, student_idType, student_RegNum," +
                    " student_finishedCourses, student_currentCourses)"
                    + " VALUES (?, ?, ?, ?, ?," +
                              " ?, ?, ?, ?, ?," +
                              " ?, ?, ?, ?, ?," +
                              " ?, ?, ?, ?, ?," +
                              " ?, ?, ?, ?);";

            PreparedStatement addStudentSt = conn.prepareStatement(addStudent);

            addStudentSt.setString(1, this.studentName.getName());
            addStudentSt.setString(2, this.nationality.getNationality());
            addStudentSt.setString(3, this.homeAddress.getHomeAddress());
            addStudentSt.setString(4, this.mailingAddress.getHomeAddress());
            addStudentSt.setInt(5, this.studentAge.calcAge());
            addStudentSt.setString(6, this.gender.getGender());
            addStudentSt.setInt(7, this.firstEnrolmentYear.getFirstYear());
            addStudentSt.setString(8, this.department.getStudentDepartment());
            addStudentSt.setString(9, this.tutor_info.getTutorInfo());
            addStudentSt.setInt(10, this.currentTerm.getCurrentTerm());
            addStudentSt.setString(11, this.payments.getTypeOfFunding());
            addStudentSt.setInt(12, 0);
            addStudentSt.setInt(13, 0);
            addStudentSt.setString(14, this.contact.getEmail());
            addStudentSt.setString(15, this.contact.getMobileNumber());
            addStudentSt.setString(16, this.contact.getHomeNumber());
            addStudentSt.setInt(17, this.creditHrs.getFinishedHours());
            addStudentSt.setDouble(18, this.studentGPA.getCGPA());
            addStudentSt.setString(19, this.id.getIDNumber());
            addStudentSt.setInt(20, this.id.getIDValidity());
            addStudentSt.setString(21, this.id.getIDType());
            addStudentSt.setString(22, this.regNumber.getRegNum());
            addStudentSt.setString(23, this.courses.getFinishedCourses());
            addStudentSt.setString(24, this.courses.getCurrentCourses());

            addStudentSt.executeUpdate(); // add student

            System.out.println("A student has been added to our database");

            // close connection
            addStudentSt.close();
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getStudentsNum() {
        try {
            Statement st;

            /* Set connection */
            String url = "jdbc:sqlite:database\\universitySystem.db";
            Connection conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            st = conn.createStatement();
            /* Get data */
            ResultSet getStudentsNumSt = st.executeQuery("SELECT COUNT(*) FROM students;");
            while(getStudentsNumSt.next()) {
                this.studentsNum = getStudentsNumSt.getInt(1);
            }
            /* close result set */
            getStudentsNumSt.close();

            st.close();
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return studentsNum;
    }


    public static Student searchForStudentInDB(String number) {
        Student student = null;
        
        try {
            Statement st;

            /* Set connection */
            String url = "jdbc:sqlite:database\\universitySystem.db";
            Connection conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            st = conn.createStatement();
            /* Get data */
            ResultSet searchST = st.executeQuery("SELECT * FROM students\n" +
                                                        "WHERE student_RegNum Like " + number);
            while(searchST.next()) {  // if the student is found
                student = new Student();
                student.setPersonalInfoFromDatabase(searchST.getString("student_name"), searchST.getString("student_gender"),
                        searchST.getString("student_nationality"), searchST.getInt("student_age"),
                        searchST.getString("student_idNumber"));

                student.setHomeAddressFromDatabase(searchST.getString("student_homeAddress"));

                student.setMailingAddressFromDatabase(searchST.getString("student_mailingAddress"));

                student.setCollegeInfoFromDatabase(searchST.getInt("student_firstEnrolmentYear"),
                        searchST.getString("student_department"), searchST.getDouble("student_GPA"),
                        searchST.getInt("student_creditHours"), searchST.getInt("student_currentTerm"));

                student.setPaymentsFromDatabase(searchST.getString("student_typeOfFunding"),
                        searchST.getDouble("student_totalAmountPaid"), searchST.getInt("student_paymentsNum"));

                student.setCourses(searchST.getString("student_finishedCourses"), searchST.getString("student_currentCourses"));

                student.setContact(searchST.getString("student_email"), searchST.getString("student_homeNumber"),
                        searchST.getString("student_phoneNumber"));
            }

            /* close result set */
            searchST.close();

            st.close();
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return student;
    }

}

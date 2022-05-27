package com.example.university_registration_system_gui;

import com.example.info_student.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GetDataScene {

    Student foundStudent;

    // Header
    @FXML
    TextField searchTextField;
    @FXML
    Button searchBtn;
    @FXML
    Label incorrectLabel;

    // Personal Info
    @FXML
    Label nameLabel, ageLabel, nationalityLabel, IDLabel, genderLabel;

    // Address
    @FXML
    Label homeLabel, mailingLabel;

    // College Info
    @FXML
    Label firstYearLabel, departmentLabel, currentTermLabel, creditHrsLabel, gpaLabel;

    // Payments
    @FXML
    Label fundingTypeLabel, totalAmountLabel, paymentsNumLabel;

    // Courses
    @FXML
    Label finishedCoursesLabel, currentCoursesLabel;

    // Contact
    @FXML
    Label emailLabel, phoneLabel, mobileLabel;


    @FXML
    public void searchForStudent() {
        if(Student.searchForStudentInDB(searchTextField.getText()) != null ) {
            foundStudent = Student.searchForStudentInDB(searchTextField.getText());
            incorrectLabel.setVisible(false);
            fillFields();
        } else {
            incorrectLabel.setVisible(true);
        }
    }

    public void fillFields() {
        // Personal info
        nameLabel.setText(foundStudent.getStudentName());
        IDLabel.setText(foundStudent.getIDNum());
        ageLabel.setText(String.valueOf(foundStudent.getStudentAge()));
        nationalityLabel.setText(foundStudent.getNationality());
        genderLabel.setText(foundStudent.getGender());

        // Address
        homeLabel.setText(foundStudent.getHomeAddress());
        mailingLabel.setText(foundStudent.getMailingAddress());

        // College info
        firstYearLabel.setText(String.valueOf(foundStudent.getFirstYear()));
        gpaLabel.setText(String.valueOf(foundStudent.getGPA()));
        creditHrsLabel.setText(String.valueOf(foundStudent.getCreditHrs()));
        departmentLabel.setText(foundStudent.getDepartment());
        currentTermLabel.setText(String.valueOf(foundStudent.getCurrentTerm()));

        // payments
        fundingTypeLabel.setText(foundStudent.getTypeOfFunding());
        totalAmountLabel.setText(String.valueOf(foundStudent.getAmountPaid()));
        paymentsNumLabel.setText(String.valueOf(foundStudent.getNumPayments()));

        // Courses
        finishedCoursesLabel.setText(foundStudent.getFinishedCourses());
        currentCoursesLabel.setText(foundStudent.getCurrentCourses());

        // Contact
        emailLabel.setText(foundStudent.getEmail());
        phoneLabel.setText(foundStudent.getPhoneNumber());
        mobileLabel.setText(foundStudent.getMobileNUmber());
    }

    @FXML
    public void backToHomeScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainScene.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}

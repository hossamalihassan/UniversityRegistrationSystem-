package com.example.university_registration_system_gui;
import com.example.info_student.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;

public class SetDataScene implements Initializable {

    Student student;

    // to track progress
    HashSet<String> finishedFields = new HashSet<>();
    int fieldsNum = 33;
    double progress = 0;
    @FXML
    ProgressIndicator setDataProgress;

    // Personal Info
    @FXML
    TextField firstName, middleName, lastName, nationality, gender, idNumber, idType;
    @FXML
    Spinner<Integer> dayOfBirth, monthOfBirth, yearOfBirth, IDValidity;

    // Address
    @FXML
    TextField houseNum, flatNum, streetName, areaName, cityName, governorateName, country, postalCode;
    @FXML
    CheckBox homeMailChoice;
    @FXML
    TextField houseNumMail, flatNumMail, streetNameMail, areaNameMail, cityNameMail, governorateNameMail,countryMail, postalCodeMail;

    // College Information
    @FXML
    Spinner<Integer> firstEnrolmentYear;
    @FXML
    ChoiceBox<String>  departmentMenu;
    String[] departments = {"Data Science and Computing", "Business Analytics", "Intelligent Systems", "Media Analytics", "Cybersecurity", "Healthcare Informatics and Data Analytics"};
    @FXML
    TextField tutorName, tutorCode, gpa, RegNum;
    @FXML
    Label GPAWarning;
    @FXML
    Spinner<Integer> finishedCreditHours, currentTerm;
    @FXML
    CheckBox newStudent;

    // Payments
    @FXML
    TextField fundingType;

    // Courses
    StringBuffer finishedCourses = new StringBuffer();
    StringBuffer currentCourses = new StringBuffer();
    @FXML
    TextField finishedCourseTextFiled, currentCourseTextFiled;
    @FXML
    TextArea finishedCourseTextView, currentCourseTextView;
    @FXML
    Button addFinishedCourse, addCurrentCourse;

    // Contact
    @FXML
    TextField studentEmail, studentMobileNumber, studentPhoneNum;

    // Submit Button
    @FXML
    Button submitBtn, backBtn;

    // Warnings
    @FXML
    Label emailWarning, phoneNumberWarning, mobileNumberWarning, submitLabel;

    @FXML
    public void ToggleMailInputs(ActionEvent event) throws IOException{
        if(homeMailChoice.isSelected()) {
            // set mail Address inputs to home address
            houseNumMail.setText(houseNum.getText());
            flatNumMail.setText(flatNum.getText());
            streetNameMail.setText(streetName.getText());
            areaNameMail.setText(areaName.getText());
            cityNameMail.setText(cityName.getText());
            governorateNameMail.setText(governorateName.getText());
            countryMail.setText(country.getText());
            postalCodeMail.setText(postalCode.getText());

            // forbid the user from entering mail address inputs
            houseNumMail.setDisable(true);
            flatNumMail.setDisable(true);
            streetNameMail.setDisable(true);
            areaNameMail.setDisable(true);
            cityNameMail.setDisable(true);
            governorateNameMail.setDisable(true);
            countryMail.setDisable(true);
            postalCodeMail.setDisable(true);

            // adjust the progress
            finishedFields.add("houseNumMail");
            finishedFields.add("flatNumMail");
            finishedFields.add("streetNameMail");
            finishedFields.add("areaNameMail");
            finishedFields.add("cityNameMail");
            finishedFields.add("governorateNameMail");
            finishedFields.add("countryMail");
            finishedFields.add("postalCodeMail");

            setProgress();
        } else {
            // set mail Address inputs to null
            houseNumMail.setText("");
            flatNumMail.setText("");
            streetNameMail.setText("");
            areaNameMail.setText("");
            cityNameMail.setText("");
            governorateNameMail.setText("");
            countryMail.setText("");
            postalCodeMail.setText("");

            // clear mail address inputs
            houseNumMail.setDisable(false);
            flatNumMail.setDisable(false);
            streetNameMail.setDisable(false);
            areaNameMail.setDisable(false);
            cityNameMail.setDisable(false);
            governorateNameMail.setDisable(false);
            countryMail.setDisable(false);
            postalCodeMail.setDisable(false);

            finishedFields.remove("houseNumMail");
            finishedFields.remove("flatNumMail");
            finishedFields.remove("streetNameMail");
            finishedFields.remove("areaNameMail");
            finishedFields.remove("cityNameMail");
            finishedFields.remove("governorateNameMail");
            finishedFields.remove("countryMail");
            finishedFields.remove("postalCodeMail");

            setProgress();
        }

    }


    // disable these if the "new student" checkbox is checked
    @FXML
    public void toggleGPAInput(ActionEvent event){
        gpa.setDisable(newStudent.isSelected());
        finishedCreditHours.setDisable(newStudent.isSelected());
        finishedCourseTextFiled.setDisable(newStudent.isSelected());
        addFinishedCourse.setDisable(newStudent.isSelected());
        GPA.CGPA = 0;
        firstEnrolmentYear.setDisable(newStudent.isSelected());
        currentTerm.setDisable(newStudent.isSelected());
        RegNum.setDisable(newStudent.isSelected());
        if(newStudent.isSelected()) {
            finishedFields.add("finishedCourse");
            finishedFields.add("GPA");
            finishedFields.add("currentTerm");
            finishedFields.add("RegNum");
            setProgress();
        } else {
            finishedFields.remove("finishedCourse");
            finishedFields.remove("GPA");
            finishedFields.remove("currentTerm");
            finishedFields.remove("RegNum");
            setProgress();
        }

    }

    // Add departments to the departments choice box
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        departmentMenu.getItems().addAll(departments);
    }

    // add finished and current courses to text view
    @FXML
    public void addFinishedCourse(ActionEvent event){
        finishedCourses.append(finishedCourseTextFiled.getText()).append(", ");
        finishedCourseTextFiled.setText("");
        finishedCourseTextView.setText(finishedCourses.toString());
        finishedFields.add("finishedCourses");
        setProgress();
    }
    @FXML
    public void addCurrentCourse(ActionEvent event){
        currentCourses.append(currentCourseTextFiled.getText()).append(", ");
        currentCourseTextFiled.setText("");
        currentCourseTextView.setText(currentCourses.toString());
        finishedFields.add("currentCourses");
        setProgress();
    }

    @FXML
    public void checkForFloat(KeyEvent event){      // To check if GPA Text field has double value
        if(!IsValid.checkForFloat(gpa.getText())){
            GPAWarning.setText("Your GPA must be a float number");
            GPAWarning.setVisible(true);
            finishedFields.remove("GPA");
        } else if(Double.parseDouble(gpa.getText()) > 4.0){
            GPAWarning.setText("Your GPA must between 0 and 4");
            GPAWarning.setVisible(true);
            finishedFields.remove("GPA");
        } else {
            GPAWarning.setVisible(false);
            finishedFields.add("GPA");
            setProgress();
        }
    }


    @FXML
    public void isEmailValid(KeyEvent event) {
        if(!IsValid.isEmailValid(studentEmail.getText())){
            emailWarning.setVisible(true);
            finishedFields.remove("Email");
        } else {
            emailWarning.setVisible(false);
            finishedFields.add("Email");
        }

        setProgress();
    }

    @FXML
    public void checkMobileNumber() {
        if(!IsValid.checkForMobileNumber(studentMobileNumber.getText())){
            mobileNumberWarning.setVisible(true);
            finishedFields.remove("studentMobileNumber");
        } else {
            mobileNumberWarning.setVisible(false);
            finishedFields.add("studentMobileNumber");
        }

        setProgress();
    }



    public void setProgress() {
        progress = (finishedFields.size() * 1.0 / fieldsNum);
        setDataProgress.setProgress(progress);

        if(progress >= 1.0){
            submitBtn.setDisable(false);
        } else {
            submitBtn.setDisable(true);
        }

    }

    @FXML
    public void updateProgress(KeyEvent event){
        Node source = (Node) event.getSource();
        TextField origin = (TextField) event.getSource();
        String id = source.getId();
        if(!origin.getText().isEmpty()) {
            finishedFields.add(id);
            setProgress();
        } else {
            finishedFields.remove(id);
            setProgress();
        }

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

    public void studentInfo() {
        student = new Student();
        student.setPersonalInfo(firstName.getText(), middleName.getText(), lastName.getText(),
                gender.getText(), nationality.getText(),
                dayOfBirth.getValue(), monthOfBirth.getValue(),
                yearOfBirth.getValue(),
                idType.getText(), idNumber.getText(), IDValidity.getValue());

        student.setHomeAddress(houseNum.getText(), flatNum.getText(), streetName.getText(), areaName.getText(),
                cityName.getText(), governorateName.getText(), country.getText(),postalCode.getText());

        if(!homeMailChoice.isSelected()){
            student.setMailingAddress(houseNumMail.getText(), flatNumMail.getText(), streetNameMail.getText(),
                    areaNameMail.getText(), cityNameMail.getText(), governorateNameMail.getText(), countryMail.getText(), postalCodeMail.getText());
        } else {
            student.setMailingAddress(houseNum.getText(), flatNum.getText(), streetName.getText(), areaName.getText(),
                    cityName.getText(), governorateName.getText(), country.getText(),postalCode.getText());
        }

        student.setCollegeInfo(firstEnrolmentYear.getValue(), departmentMenu.getValue(),
                tutorName.getText(), tutorCode.getText(), Double.parseDouble(gpa.getText()),
                finishedCreditHours.getValue(), currentTerm.getValue());

        if(newStudent.isSelected()) {
            student.generateRegNum(
                    (Arrays.asList(departments).indexOf(departmentMenu.getValue())+1),
                    student.getStudentsNum()+1, currentTerm.getValue()
            );

        } else {
            student.setRegNumber(RegNum.getText());
        }

        student.setCourses(finishedCourseTextView.getText(), currentCourseTextView.getText());

        student.setPayments(fundingType.getText());

        student.setContact(studentEmail.getText(), studentPhoneNum.getText(),
                studentMobileNumber.getText());
    }

    @FXML
    public void submit(ActionEvent event) throws IOException {
        studentInfo();
        student.addStudentToDB();
        submitBtn.setDisable(true);
        submitLabel.setVisible(true);
    }

}
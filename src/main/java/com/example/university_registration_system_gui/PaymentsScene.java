package com.example.university_registration_system_gui;

import com.example.info_student.SinglePayment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentsScene {

    SinglePayment payment;

    @FXML
    TextField studentNumber, amountPaid, bank, transactionNumber;
    @FXML
    DatePicker dateTransaction;
    @FXML
    Button addPayment;
    @FXML
    Label successLabel;

    @FXML
    public void submitPayment() {
        payment = new SinglePayment();
        payment.setNewPayment(studentNumber.getText(), Double.parseDouble(String.valueOf(amountPaid.getText())),
                transactionNumber.getText(), bank.getText(), String.valueOf(dateTransaction.getValue()));
        payment.addPaymentToDB();
        payment.getStudentBalance(studentNumber.getText());
        payment.updateStudentPaymentsData(studentNumber.getText());
        successLabel.setVisible(true);
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

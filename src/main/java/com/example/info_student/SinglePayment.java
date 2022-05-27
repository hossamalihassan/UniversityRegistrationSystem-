package com.example.info_student;

import java.sql.*;


public class SinglePayment {

    double studentBalance;
    int studentPaymentsNum;
    String studentNumber, transactionNumber, bank, paymentDate;
    double amount;


    public void setNewPayment(String number, double amount, String transactionNumber, String bank, String paymentDate){
        this.amount = amount;
        this.bank = bank;
        this.studentNumber = number;
        this.transactionNumber = transactionNumber;
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void addPaymentToDB() {
        try {
            Connection conn;
            String url = "jdbc:sqlite:database\\universitySystem.db";
            conn = DriverManager.getConnection(url);

            String addStudent = "INSERT INTO payments " +
                    " (studentNumber , amountPaid , transactionNumber ," +
                    " bank, paymentDate)"
                    + " VALUES (?, ?, ?, ?, ?)";

            PreparedStatement addPaymentST = conn.prepareStatement(addStudent);

            addPaymentST.setString(1, this.studentNumber);
            addPaymentST.setDouble(2, this.amount);
            addPaymentST.setString(3, this.transactionNumber);
            addPaymentST.setString(4, this.bank);
            addPaymentST.setString(5, this.paymentDate);

            addPaymentST.executeUpdate(); // add post

            System.out.println("A payment has been added to our database");

            // close connection
            addPaymentST.close();
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getStudentBalance(String number) {
        try {
            Statement st;

            /* Set connection */
            String url = "jdbc:sqlite:database\\universitySystem.db";
            Connection conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            st = conn.createStatement();

            // get student's balance
            ResultSet getStudentBalance = st.executeQuery("SELECT student_totalAmountPaid, student_paymentsNum FROM students " +
                    "WHERE student_RegNum=" + number);
            while(getStudentBalance.next()) {
                this.studentBalance = getStudentBalance.getDouble("student_totalAmountPaid");
                this.studentPaymentsNum = getStudentBalance.getInt("student_paymentsNum");
            }
            /* close result set */
            getStudentBalance.close();

            st.close();
            conn.close();

            // update his balance
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void updateStudentPaymentsData(String number) {
        try {
            String url = "jdbc:sqlite:database\\universitySystem.db";
            Connection conn = DriverManager.getConnection(url);

            String updateBalance = "UPDATE students " +
                    "SET student_totalAmountPaid=?, student_paymentsNum=? " +
                    "WHERE student_RegNum=? ";

            PreparedStatement updateBalanceST = conn.prepareStatement(updateBalance);
            updateBalanceST.setDouble(1, (this.getAmount() + this.studentBalance));
            updateBalanceST.setInt(2, ++studentPaymentsNum);
            updateBalanceST.setString(3, number);

            // update
            updateBalanceST.executeUpdate();

            // close connection
            updateBalanceST.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

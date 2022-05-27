package com.example.info_student;

public class Payments {

    String typeOfFunding;
    int paymentsDoneNum;
    double totalAmountPaid;

    SinglePayment[] everyPayment;

    public void setPayments(String typeOfFunding){
        this.typeOfFunding = typeOfFunding;
        this.totalAmountPaid = 0;
        this.paymentsDoneNum = 0;
    }

    public void setPaymentsData(String typeOfFunding, int paymentsDoneNum, double totalAmountPaid) {
        this.typeOfFunding = typeOfFunding;
        this.paymentsDoneNum = paymentsDoneNum;
        this.totalAmountPaid = totalAmountPaid;
    }

    public String getTypeOfFunding() {
        return typeOfFunding;
    }

    public int getPaymentsDoneNum() {
        return paymentsDoneNum;
    }

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }
}

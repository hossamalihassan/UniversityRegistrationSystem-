package com.example.info_student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsValid {

    IsValid(){}

    public static boolean isEmailValid(String email) {
        String regexEmail = "^(.+)@(.+)$";
        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(email);
        return matcherEmail.matches();
    }

    public static boolean checkForMobileNumber(String number){
        String regexMobileNumber = "^01[0125]\\d{8}$";
        Pattern patternMobileNumber = Pattern.compile(regexMobileNumber);
        Matcher matcherMobileNumber = patternMobileNumber.matcher(number);
        return matcherMobileNumber.matches();
    }

    public static boolean checkForFloat(String input) {
        try{
            Double num = Double.parseDouble(input);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean checkForNumeric(String input) {
        try{
            int num = Integer.parseInt(input);
        } catch (Exception e){
            return false;
        }
        return true;
    }

}

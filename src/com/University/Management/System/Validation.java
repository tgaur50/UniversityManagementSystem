package com.University.Management.System;

import java.util.SortedMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public boolean checkData(String data, String regex){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(data);
        return m.matches();
    }
    public boolean checkNames(String name){
        String regex = "^([^\\.\\'\\-])([A-z\\.\\'\\-])*(\\s)*([A-z])+[A-z\\.\\'\\-\\s]*$";
        return checkData(name, regex);
    }

    public boolean checkRollNo(String rollno){
        String regex = "[0-9]{8}";
        return checkData(rollno, regex);
    }

    public boolean checkEmpId(String empId){
        String regex = "[0-9]{7}";
        return checkData(empId, regex);
    }

    public boolean checkDOB(String dob){
        String regex = "[0-9]{2}-[A-z]{3,4}-[0-9]{4}";
        return checkData(dob, regex);
    }

    public boolean checkEmail(String email){
        String regex = "^([A-z]{1}[A-z0-9._-]+)@[A-z]{1}[A-z0-9._-]*[A-z0-9]+\\.[A-z]{2,}$";
        return checkData(email, regex);
    }

    public boolean checkPhone(String phoneNum){
        String regex = "^[0]*([\\+][0-9]{1,2})*([0-9]{10})";
        return checkData(phoneNum, regex);
    }

    public boolean checkAddress(String address){
        String regex = "^([^\\.\\'\\-])([A-z0-9\\.\\'\\-\\,])*(\\s)*([A-z0-9])+[A-z0-9\\.\\'\\-\\,\\s]*$";
        return checkData(address, regex);
    }

    public boolean checkMarks(String marks){
        String regex = "[0-9]{2}([\\.][0-9]{2})*";
        return checkData(marks,regex);
    }

    public boolean checkAadhaar(String aadhaarNo){
        String regex = "[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
        return checkData(aadhaarNo, regex);
    }
}

package com.University.Management.System;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDetailsDao {
    private final Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement stm;

    public StudentDetailsDao(){
        ConnectionToDB cnToDb = new ConnectionToDB();
        con = cnToDb.getCon();
    }
    public int insertStudentDetails(Student student){
        int numRows;
        String query = "insert into Student(name, RollNo, fathername, dob, address, phone, " +
                "emailid, classX, classXII, aadhaarNo, course, branch) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setLong(2, student.getRollNum());
            ps.setString(3, student.getFatherName());
            ps.setString(4, student.getDob());
            ps.setString(5, student.getAddress());
            ps.setLong(6, student.getPhone());
            ps.setString(7, student.getEmailId());
            ps.setDouble(8, student.getClassX());
            ps.setDouble(9, student.getClassXII());
            ps.setString(10, student.getAadhaarNo());
            ps.setString(11, student.getCourse());
            ps.setString(12, student.getBranch());
            numRows = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numRows;
    }

    public int insertFacultyDetails(Faculty faculty){
        int numRows;
        String query = "insert into Faculty(name, employeeid, fathername, dob, address, phone, " +
                "emailid, classX, classXII, aadharNo, education, department) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, faculty.getName());
            ps.setLong(2, faculty.getEmployeeId());
            ps.setString(3, faculty.getFatherName());
            ps.setString(4, faculty.getDob());
            ps.setString(5, faculty.getAddress());
            ps.setLong(6, faculty.getPhone());
            ps.setString(7, faculty.getEmailId());
            ps.setDouble(8, faculty.getClassX());
            ps.setDouble(9, faculty.getClassXII());
            ps.setString(10, faculty.getAadhaarNo());
            ps.setString(11, faculty.getEducation());
            ps.setString(12, faculty.getDepartment());
            numRows = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numRows;
    }

    public List<Student> getStudent(){
        List<Student> listOfStudents = new ArrayList<>();
        String query = "select * from Student";
        Student st;
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()){
                st = new Student();
                st.setName(rs.getString(1));
                st.setRollNum(rs.getLong(2));
                st.setFatherName(rs.getString(3));
                st.setDob(rs.getString(4));
                st.setAddress(rs.getString(5));
                st.setPhone(rs.getLong(6));
                st.setEmailId(rs.getString(7));
                st.setClassX(rs.getDouble(8));
                st.setClassXII(rs.getDouble(9));
                st.setAadhaarNo(rs.getString(10));
                st.setCourse(rs.getString(11));
                st.setBranch(rs.getString(12));
                listOfStudents.add(st);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listOfStudents;
    }

    public List<Faculty> getTeachers(){
        List<Faculty> listOfTeachers = new ArrayList<>();
        String query = "select * from Faculty";
        Faculty ft;
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()){
                ft = new Faculty();
                ft.setName(rs.getString(1));
                ft.setEmployeeId(rs.getLong(2));
                ft.setFatherName(rs.getString(3));
                ft.setDob(rs.getString(4));
                ft.setAddress(rs.getString(5));
                ft.setPhone(rs.getLong(6));
                ft.setEmailId(rs.getString(7));
                ft.setClassX(rs.getDouble(8));
                ft.setClassXII(rs.getDouble(9));
                ft.setAadhaarNo(rs.getString(10));
                ft.setEducation(rs.getString(11));
                ft.setDepartment(rs.getString(12));
                listOfTeachers.add(ft);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listOfTeachers;
    }

    public Student searchByRollNum(String rollNumStr){
        long rollNum = Long.parseLong(rollNumStr);
        Student st = null;
        String query = "select * from Student where RollNo = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, rollNum);
            rs = ps.executeQuery();
            if (rs.next()){
                st = new Student();
                st.setName(rs.getString(1));
                st.setRollNum(rs.getLong(2));
                st.setFatherName(rs.getString(3));
                st.setDob(rs.getString(4));
                st.setAddress(rs.getString(5));
                st.setPhone(rs.getLong(6));
                st.setEmailId(rs.getString(7));
                st.setClassX(rs.getDouble(8));
                st.setClassXII(rs.getDouble(9));
                st.setAadhaarNo(rs.getString(10));
                st.setCourse(rs.getString(11));
                st.setBranch(rs.getString(12));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return st;
    }

    public Faculty searchByEmployeeId(String empId){
        long empIdVal = Long.parseLong(empId);
        Faculty ft = null;
        String query = "select * from Faculty where employeeid = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, empIdVal);
            rs = ps.executeQuery();
            if (rs.next()){
                ft = new Faculty();
                ft.setName(rs.getString(1));
                ft.setEmployeeId(rs.getLong(2));
                ft.setFatherName(rs.getString(3));
                ft.setDob(rs.getString(4));
                ft.setAddress(rs.getString(5));
                ft.setPhone(rs.getLong(6));
                ft.setEmailId(rs.getString(7));
                ft.setClassX(rs.getDouble(8));
                ft.setClassXII(rs.getDouble(9));
                ft.setAadhaarNo(rs.getString(10));
                ft.setEducation(rs.getString(11));
                ft.setDepartment(rs.getString(12));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ft;
    }

    public int updateStudentDetails(long rollNum, Student std){
        int numOfRowsUpdated;
        String query = "update Student set address = ?, phone = ?, emailid = ?, " +
                "course = ?, branch = ? where RollNo = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, std.getAddress());
            ps.setLong(2, std.getPhone());
            ps.setString(3, std.getEmailId());
            ps.setString(4, std.getCourse());
            ps.setString(5, std.getBranch());
            ps.setLong(6, rollNum);
            numOfRowsUpdated = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numOfRowsUpdated;
    }

    public int updateTeacherDetails(long empId, Faculty ft){
        int numOfRowsUpdated;
        String query = "update Faculty set address = ?, phone = ?, emailid = ?, " +
                "education = ?, department = ? where employeeid = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, ft.getAddress());
            ps.setLong(2, ft.getPhone());
            ps.setString(3, ft.getEmailId());
            ps.setString(4, ft.getEducation());
            ps.setString(5, ft.getDepartment());
            ps.setLong(6, empId);
            numOfRowsUpdated = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numOfRowsUpdated;
    }

    public int applyStudentLeave(long rollNum, String date, String time){
        int numRows;
        String query = "insert into studentleaves (rollnum, date, time) values(?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, rollNum);
            ps.setString(2, date);
            ps.setString(3, time);
            numRows = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numRows;
    }

    public int applyTeacherLeave(long empId, String date, String time){
        int numRows;
        String query = "insert into teacherleaves (employeeid, date, time) values(?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, empId);
            ps.setString(2, date);
            ps.setString(3, time);
            numRows = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numRows;
    }

    public List<String[]> getStudentLeaves(){
        List<String[]> studentLeaves = new ArrayList<>();
        String query = "select * from studentleaves";
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            int index;
            while (rs.next()){
                index = 0;
                String[] leaveDetail = new String[3];
                leaveDetail[index] = String.valueOf(rs.getLong(1));
                index++;
                leaveDetail[index] = rs.getString(2);
                index++;
                leaveDetail[index] = rs.getString(3);
                index++;
                studentLeaves.add(leaveDetail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentLeaves;
    }

    public List<String[]> getTeacherLeaves(){
        List<String[]> teacherLeaves = new ArrayList<>();
        String query = "select * from teacherleaves";
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            int index;
            while (rs.next()){
                index = 0;
                String[] leaveDetail = new String[3];
                leaveDetail[index] = String.valueOf(rs.getLong(1));
                index++;
                leaveDetail[index] = rs.getString(2);
                index++;
                leaveDetail[index] = rs.getString(3);
                index++;
                teacherLeaves.add(leaveDetail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacherLeaves;
    }

    public List<String[]> getStudentLeavesByRollNum(String rollNumStr){
        long rollNum = Long.parseLong(rollNumStr);
        List<String[]> studentLeavesByRollNum = new ArrayList<>();
        String query = "select * from studentleaves where rollnum = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, rollNum);
            rs = ps.executeQuery();
            int index;
            if (rs.next()){
                index = 0;
                String[] studentLeaveByRollNum = new String[3];
                studentLeaveByRollNum[index++] = String.valueOf(rs.getLong(1));
                studentLeaveByRollNum[index++] = rs.getString(2);
                studentLeaveByRollNum[index++] = rs.getString(3);
                studentLeavesByRollNum.add(studentLeaveByRollNum);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentLeavesByRollNum;
    }

    public List<String[]> getTeacherLeavesByEmployeeId(String empId){
        long empIdVal = Long.parseLong(empId);
        List<String[]> teacherLeavesByEmpId = new ArrayList<>();
        String query = "select * from teacherleaves where employeeid = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, empIdVal);
            rs = ps.executeQuery();
            int index;
            if (rs.next()){
                index = 0;
                String[] teacherLeaveByEmpId = new String[3];
                teacherLeaveByEmpId[index++] = String.valueOf(rs.getLong(1));
                teacherLeaveByEmpId[index++] = rs.getString(2);
                teacherLeaveByEmpId[index++] = rs.getString(3);
                teacherLeavesByEmpId.add(teacherLeaveByEmpId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacherLeavesByEmpId;
    }

    public int insertStudentMarks(long rollnum, String semester, String sub1, String sub2,
                                   String sub3, String sub4, String sub5, String marks1,
                                  String marks2, String marks3, String marks4, String marks5){
        int numRowsEffected;
        String query = "insert into studentmarks(rollnum, semester, subjectone, subjecttwo, " +
                "subjectthree, subjectfour, subjectfive, subjectonemarks, subjecttwomarks, " +
                "subjectthreemarks, subjectfourmarks, subjectfivemarks) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, rollnum);
            ps.setString(2, semester);
            ps.setString(3, sub1);
            ps.setString(4, sub2);
            ps.setString(5, sub3);
            ps.setString(6, sub4);
            ps.setString(7, sub5);
            ps.setDouble(8, Double.parseDouble(marks1));
            ps.setDouble(9, Double.parseDouble(marks2));
            ps.setDouble(10, Double.parseDouble(marks3));
            ps.setDouble(11, Double.parseDouble(marks4));
            ps.setDouble(12, Double.parseDouble(marks5));
            numRowsEffected = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numRowsEffected;
    }

    public ResultSet getStudentResult(long rollNum){
        String query = "select * from studentmarks where rollnum = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, rollNum);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

//    public int insertFeeDetails(List<FeeDetails> fdList){
//        int numRowsEffected = 0;
//        String query = "insert into feedetails (course, semester1fee, semester2fee, semester3fee, semester4fee, semester5fee, semester6fee, semester7fee, semester8fee) values(?,?,?,?,?,?,?,?,?)";
//        try {
//            ps = con.prepareStatement(query);
//            for (FeeDetails fd : fdList){
//                ps.setString(1, fd.getCourse());
//                ps.setInt(2, fd.getSemester1Fee());
//                ps.setInt(3, fd.getSemester2Fee());
//                ps.setInt(4, fd.getSemester3Fee());
//                ps.setInt(5, fd.getSemester4Fee());
//                ps.setInt(6, fd.getSemester5Fee());
//                ps.setInt(7, fd.getSemester6Fee());
//                ps.setInt(8, fd.getSemester7Fee());
//                ps.setInt(9, fd.getSemester8Fee());
//                numRowsEffected = ps.executeUpdate();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return numRowsEffected;
//    }

    public ResultSet getFeeDetails(){
        String query = "select * from feedetails";
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public int getTotalFeeToPay(String course, String semester){
        String semesterColumn;
        int totalFee = 0;
        semesterColumn = switch (semester) {
            case "1st Semester" -> "semester1fee";
            case "2nd Semester" -> "semester2fee";
            case "3rd Semester" -> "semester3fee";
            case "4th Semester" -> "semester4fee";
            case "5th Semester" -> "semester5fee";
            case "6th Semester" -> "semester6fee";
            case "7th Semester" -> "semester7fee";
            case "8th Semester" -> "semester8fee";
            default -> "";
        };
        String query = "select " + semesterColumn + " from feedetails where course = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, course);
            rs = ps.executeQuery();
            while (rs.next()){
                totalFee = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalFee;
    }
}

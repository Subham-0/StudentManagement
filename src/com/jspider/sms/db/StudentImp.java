package com.jspider.sms.db;

import com.jspider.sms.entity.Student;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentImp implements StudentDB {
    public static Connection conn = null;

    public void getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "Run@0");
                System.out.println("connect to database successfully");
            } catch (SQLException e) {
                throw new RuntimeException("failed to connect DB");
            }
        }

    }

    @Override
    public void update(int id, int option) {
        Scanner sc = new Scanner(System.in);
        PreparedStatement pst = null;
        try {

            if (option == 1) {
                System.out.println("Enter the updated student name");
                String name = sc.next();
                pst = conn.prepareStatement("update student set studentname = ? where idstudent=?");
                pst.setInt(2, id);
                pst.setString(1, name);
            } else if (option == 2) {
                System.out.println("Enter the studentdeptno name");
                int deptno = sc.nextInt();
                pst = conn.prepareStatement("update student set studentdeptno = ? where idstudent=?");
                pst.setInt(2, id);
                pst.setInt(1, deptno);
            } else if (option == 3) {
                System.out.println("Enter the dob of student ");
                String dob = sc.next();
                pst = conn.prepareStatement("update student set studentdob = ? where idstudent=?");
                pst.setInt(2, id);
                pst.setString(1, dob);
            } else if (option == 4) {
                System.out.println("Enter the skill of student ");
                String skill = sc.next();
                pst = conn.prepareStatement("update student set studentskill = ? where idstudent=?");
                pst.setInt(2, id);
                pst.setString(1, skill);
            } else if (option == 5) {
                System.out.println("Enter the activity of student");
                boolean activity = sc.nextBoolean();
                pst = conn.prepareStatement("update student set studentactivity = ? where idstudent=?");
                pst.setInt(2, id);
                pst.setBoolean(1, activity);
            }
            pst.execute();
            System.out.println("data is updated");
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Please enter a valid input");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void showAll() {
        Student st = new Student();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from student");
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                st.setIdstudent(rst.getInt("idstudent"));
                st.setStudentname(rst.getString("studentname"));
                st.setStudentdeptno(rst.getInt("studentdeptno"));
                st.setStudentdob(rst.getString("studentdob"));
                st.setStudentskill(rst.getString("studentskill"));
                st.setStudentactivity(rst.getBoolean("studentactivity"));
                System.out.println(st);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void showdate(int id) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from student where idstudent=?");
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            if (!rst.isBeforeFirst()) {
                System.out.println("record not found");
            } else {
                while (rst.next()) {
                    String stdname = rst.getString("studentname");
                    int stddeptno = rst.getInt("studentdeptno");
                    String stddob = rst.getString("studentdob");
                    String stdskill = rst.getString("studentskill");
                    boolean stdactivity = rst.getBoolean("studentactivity");
                    Student st = new Student(id, stdname, stddeptno, stddob, stdskill, stdactivity);
                    System.out.println(st);
                }

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String studentname, int studentdeptno, String studentdob, String studentskill, boolean studentactivity) {
        try {
            PreparedStatement pst = conn.prepareStatement("insert into student values(0,?,?,?,?,?)");
            pst.setString(1, studentname);
            pst.setInt(2, studentdeptno);
            pst.setString(3, studentdob);
            pst.setString(4, studentskill);
            pst.setBoolean(5, studentactivity);
            pst.execute();
            System.out.println("student data is successfully added to db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement pst = conn.prepareStatement("delete from student where idstudent = ?");
            pst.setInt(1, id);
            pst.execute();
            System.out.println("data deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

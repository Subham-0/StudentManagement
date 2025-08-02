package com.jspider.sms.runner;

import com.jspider.sms.db.StudentImp;


import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentRun {


    public static void main(String[] args) {
        System.out.println("Welcome to Student Management Application");


        try {
            StudentImp st = new StudentImp();
            st.getConnection();
            System.out.println("Choose the bellow options to go operation on application");
            showoptions();
            Scanner sc = new Scanner(System.in);
            boolean flag = true;
            while (flag) {
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        try {
                            System.out.println("Enter the student name");
                            String name = sc.next();
                            System.out.println("Enter the deptno");
                            int deptno = sc.nextInt();
                            System.out.println("Enter the dob");
                            String dob = sc.next();
                            System.out.println("Enter the student skill");
                            String skill = sc.next();
                            System.out.println("Enter the student activity");
                            boolean activity = sc.nextBoolean();
                            st.add(name, deptno, dob, skill, activity);
                        }
                        catch (InputMismatchException e){
                            throw new InputMismatchException("Please enter a valid input data");
                        }
                        showoptions();
                        break;
                    case 2:
                        System.out.println("Enter student ID where you want update");
                        int id = sc.nextInt();
                        chooseUpdateOptions();
                        boolean f = true;
                        while (f) {
                            int opt = sc.nextInt();
                            if (opt != 1 && opt != 2 && opt != 3 && opt != 4 && opt != 5) {
                                if (opt == 6) {
                                    System.out.println("Exited");
                                    f = false;
                                }
                                else {
                                    System.out.println("Please select a valid option");
                                    chooseUpdateOptions();
                                }
                            } else {
                                st.update(id, opt);
                                chooseUpdateOptions();
                            }
                        }
                        showoptions();
                        break;
                    case 3:
                        System.out.println("Enter the student ID to delete the data");
                        id = sc.nextInt();
                        st.delete(id);
                        showoptions();
                        break;
                    case 4:
                        System.out.println("Enter the student ID to show the data");
                        id = sc.nextInt();
                        st.showdate(id);
                        showoptions();
                        break;
                    case 5:
                        st.showAll();
                        showoptions();
                        break;
                    case 6:
                        flag = false;
                        break;
                    default:
                        System.out.println("choose a valid option");
                        showoptions();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static void showoptions() {
        System.out.println("Enter 1 to add new Student data");
        System.out.println("Enter 2 to update  Student data");
        System.out.println("Enter 3 to delete Student data");
        System.out.println("Enter 4 to show the particular Student data");
        System.out.println("Enter 5 to show all Students data");
        System.out.println("Enter 6 to exit from application");
    }

    private static void chooseUpdateOptions() {
        System.out.println("Enter 1 to update name");
        System.out.println("Enter 2 to update deptno");
        System.out.println("Enter 3 to update dob");
        System.out.println("Enter 4 to update skill");
        System.out.println("Enter 5 to update activity");
        System.out.println("Enter 6 to cancel update");
    }


}

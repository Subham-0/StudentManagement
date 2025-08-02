package com.jspider.sms.entity;

public class Student {
    private int idstudent;
    private String studentname;
    private int studentdeptno;
    private String studentdob;
    private String studentskill;
    private boolean studentactivity;

    public Student() {
    }

    public Student(int idstudent, String studentname, int studentdeptno, String studentdob, String studentskill, boolean studentactivity) {
        this.idstudent = idstudent;
        this.studentname = studentname;
        this.studentdeptno = studentdeptno;
        this.studentdob = studentdob;
        this.studentskill = studentskill;
        this.studentactivity = studentactivity;
    }

    @Override
    public String toString() {
        return
                "idstudent=" + idstudent +
                ", studentname='" + studentname + '\'' +
                ", studentdeptno=" + studentdeptno +
                ", studentdob='" + studentdob + '\'' +
                ", studentskill='" + studentskill + '\'' +
                ", studentactivity=" + studentactivity;
    }

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getStudentdeptno() {
        return studentdeptno;
    }

    public void setStudentdeptno(int studentdeptno) {
        this.studentdeptno = studentdeptno;
    }

    public String getStudentdob() {
        return studentdob;
    }

    public void setStudentdob(String studentdob) {
        this.studentdob = studentdob;
    }

    public String getStudentskill() {
        return studentskill;
    }

    public void setStudentskill(String studentskill) {
        this.studentskill = studentskill;
    }

    public boolean isStudentactivity() {
        return studentactivity;
    }

    public void setStudentactivity(boolean studentactivity) {
        this.studentactivity = studentactivity;
    }
}

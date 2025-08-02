package com.jspider.sms.db;


public interface StudentDB {
    void update(int id,int options);
    void showAll();
    void showdate(int id);
    void add(String studentname, int studentdeptno, String studentdob, String studentskill, boolean studentactivity);
    void delete(int id);
}

package com.itszw.edu.info.manager.controller;

import com.itszw.edu.info.manager.domain.Student;
import com.itszw.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class OtherStudentController extends BaseStudentController{

    private Scanner sc = new Scanner(System.in);

    //Open the student management system and display the student management system menu

    public  Student inputStudentInfo(String id){
        System.out.println("Entry student name please:");
        String name = sc.next();
        System.out.println("Entry student age please:");
        String age = sc.next();
        System.out.println("Entry student birthday please:");
        String birthday = sc.next();
        Student stu = new Student(id,name,age,birthday);
        return stu;
    }
}

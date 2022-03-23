package com.itszw.edu.info.manager.controller;

import com.itszw.edu.info.manager.domain.Student;
import com.itszw.edu.info.manager.service.StudentService;

import java.util.Scanner;

public abstract class BaseStudentController {

    private StudentService studentService = new StudentService();

    private Scanner sc = new Scanner(System.in);

    //Open the student management system and display the student management system menu
    public final void start() {
        //Scanner sc = new Scanner(System.in);
        studentLoop:
        while (true) {
            System.out.println("--------Welcome to Student Manager System--------");
            System.out.println("Please enter your choice: 1.add student 2.delete student 3.modify student 4.check student 5.exit");
            String choice = sc.next();

            switch (choice) {
                case "1":
                    //System.out.println("add");
                    addStudent();
                    break;
                case "2":
                    //System.out.println("delete");
                    deleteStudentById();
                    break;
                case "3":
                    //System.out.println("modify");
                    updateStudent();
                    break;
                case "4":
                    //System.out.println("check");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("Thanks for using student manager system!");
                    break studentLoop;
                default:
                    System.out.println("You have a wrong choice, please re-enter");
                    break;
            }
        }

    }

    public final void updateStudent() {

        String updateId = inputStudentId();

        Student newStu = inputStudentInfo(updateId);

        studentService.updateStudent(updateId,newStu);

        System.out.println("Modified successfully!");


    }

    public final void deleteStudentById() {

        String delId = inputStudentId();
        studentService.deleteStudentById(delId);
        System.out.println("Deleted successfully");

    }

    public final void findAllStudent() {

        Student[] stus = studentService.findAllStudent();
        if (stus == null) {
            System.out.println("No information, please add and try again");
            return;
        }
        System.out.println("StudentId\tname\tage\t\tbirthday");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null) {
                System.out.println(stu.getId() + "\t\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }
        }
    }

    private final void addStudent() {
        //StudentService studentService = new StudentService();

        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("Entry student id please:");
            id = sc.next();
            boolean flag = studentService.isExists(id);
            if (flag) {
                System.out.println("The student number has been occupied, please re-enter");
            } else {
                break;
            }
        }

        Student stu = inputStudentInfo(id);

        boolean result = studentService.addStudent(stu);
        if (result) {
            System.out.println("Add successfully");
        } else {
            System.out.println("Add Failed");
        }

    }

    public String inputStudentId(){
        String Id;
        while (true) {

            System.out.println("Please enter the student id:");
            Id = sc.next();
            boolean exists = studentService.isExists(Id);
            if (!exists) {
                System.out.println("The id you entered does not exist, please re-enter:");
            } else {
                break;
            }
        }
        return Id;
    }

    public  abstract Student inputStudentInfo(String id);
}

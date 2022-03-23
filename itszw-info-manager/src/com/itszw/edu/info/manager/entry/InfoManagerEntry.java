package com.itszw.edu.info.manager.entry;

import com.itszw.edu.info.manager.controller.OtherStudentController;
import com.itszw.edu.info.manager.controller.StudentController;
import com.itszw.edu.info.manager.controller.TeacherController;
import com.itszw.edu.info.manager.domain.Student;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            //Main Menu Build
            System.out.println("--------Welcome to Info Manager System--------");
            System.out.println("Please enter your choice: 1.Student Manager 2.Teacher Manager 3.exit");
            String choice = sc.next();
            switch (choice){
                case "1":
                   // System.out.println("Student Manager");
                    OtherStudentController studentController = new OtherStudentController();
                    studentController.start();
                    break;
                case "2":
                    System.out.println("Teacher Manager");
                    TeacherController teacherController = new TeacherController();
                    teacherController.start();

                    break;
                case "3":
                    System.out.println("Thanks for using");
                    //Quit the currently JVA machine
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have a wrong choice, please re-enter");
                    break;
            }

        }

    }
}

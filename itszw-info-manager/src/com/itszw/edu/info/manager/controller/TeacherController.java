package com.itszw.edu.info.manager.controller;

import com.itszw.edu.info.manager.domain.Student;
import com.itszw.edu.info.manager.domain.Teacher;
import com.itszw.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();

    public void start() {

        teacherLoop:
        while (true) {
            System.out.println("--------Welcome to Teacher Manager System--------");
            System.out.println("Please enter your choice: 1.add teacher 2.delete teacher 3.modify teacher 4.check teacher 5.exit");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    //System.out.println("add teacher");
                    addTeacher();
                    break;
                case "2":
                    //System.out.println("delete teacher");
                    deleteTeacherById();
                    break;
                case "3":
                    //System.out.println("modify teacher");
                    updateTeacher();
                    break;
                case "4":
                    //System.out.println("check teacher");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("Thanks for using teacher manager system!");
                    break teacherLoop;
                default:
                    System.out.println("You have a wrong choice, please re-enter!");
                    break;
            }

        }
    }

    private void updateTeacher() {
        String id = inputTeacherId();
        Teacher newTeacher = inputTeacherInfo(id);

        teacherService.updateTeacher(id,newTeacher);
        System.out.println("Modified successfully!");

    }

    public void deleteTeacherById() {
        String id = inputTeacherId();
        teacherService.deleteTeacherById(id);

        System.out.println("Deleted successfully");

    }

    public void findAllTeacher() {
        Teacher[] teachers = teacherService.findAllTeacher();

        if(teachers == null){
            System.out.println("No information, please add and try again!");
            return;
        }
        System.out.println("TeacherId\tname\tage\t\tbirthday");
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if(t != null){
                System.out.println(t.getId()+ "\t\t" + t.getName() + "\t" + t.getAge() + "\t\t" + t.getBirthday());
            }
        }

    }

    public void addTeacher() {
        String id;
        while (true) {
            System.out.println("Enter teacher Id please:");
            id = sc.next();
            boolean exits = teacherService.isExists(id);
            if (exits) {
                System.out.println("id already exists, please re-enter");
            } else {
                break;
            }
        }
        Teacher t = inputTeacherInfo(id);

        boolean result = teacherService.addTeacher(t);
        if(result){
            System.out.println("add successfully");
        }else {
            System.out.println("Add Failed");
        }
    }

    public String inputTeacherId(){
        String id;
        while(true){
            System.out.println("Please enter the teacher id:");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if(!exists){
                System.out.println("The id you entered does not exist, please re-enter:");
            }else {
                break;
            }
        }
        return id;
    }

    public Teacher inputTeacherInfo(String id){
        System.out.println("Entry teacher name please:");
        String name = sc.next();
        System.out.println("Entry teacher age please:");
        String age = sc.next();
        System.out.println("Entry teacher birthday please:");
        String birthday = sc.next();
        Teacher t = new Teacher();
        t.setId(id);
        t.setName(name);
        t.setAge(age);
        t.setBirthday(birthday);
        return t;
    }


}

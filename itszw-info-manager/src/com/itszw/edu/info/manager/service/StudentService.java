package com.itszw.edu.info.manager.service;

import com.itszw.edu.info.manager.dao.BaseStudentDao;
import com.itszw.edu.info.manager.dao.OtherStudentDao;
import com.itszw.edu.info.manager.dao.StudentDao;
import com.itszw.edu.info.manager.domain.Student;
import com.itszw.edu.info.manager.factory.StudentDaoFactory;

public class StudentService {

    //private OtherStudentDao studentDao = new OtherStudentDao();

    private BaseStudentDao studentDao = StudentDaoFactory.getStudentDao();

    public boolean addStudent(Student stu) {

        return studentDao.addStudent(stu);
    }

    public boolean isExists(String id) {

        Student[] stus = studentDao.findAllStudent();

        boolean exists = false;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student != null && student.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {

        Student[] allStudent = studentDao.findAllStudent();

        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student stu = allStudent[i];
            if (stu != null) {
                flag = true;
                break;
            }
        }
        if (flag) {

            return allStudent;
        } else {
            return null;
        }
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    public void updateStudent(String updateId, Student newStu) {
        studentDao.updateStudent(updateId, newStu);
    }
}

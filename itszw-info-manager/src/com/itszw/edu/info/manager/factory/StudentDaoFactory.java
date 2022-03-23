package com.itszw.edu.info.manager.factory;

import com.itszw.edu.info.manager.dao.BaseStudentDao;
import com.itszw.edu.info.manager.dao.OtherStudentDao;

public class StudentDaoFactory {
    public static BaseStudentDao getStudentDao(){
        return new OtherStudentDao();
    }
}

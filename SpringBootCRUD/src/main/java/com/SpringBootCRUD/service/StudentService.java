package com.SpringBootCRUD.service;


import com.SpringBootCRUD.bean.StudentBean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    StudentBean insert(StudentBean studentBean);

    StudentBean StudentId(int studentId);

    List<StudentBean> studentList();

    void StudentInsertList(List<StudentBean> studentBeanList);

    StudentBean editStudent(int studentId, StudentBean studentBean);

    void countStudent();

    void checking(int studentId);

    String deleteStudent(int studentId);
}

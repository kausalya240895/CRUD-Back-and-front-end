package com.SpringBootCRUD.service;

import com.SpringBootCRUD.bean.StudentBean;
import com.SpringBootCRUD.repository.StudentCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentCRUD studentCRUD;


    @Override
    public StudentBean insert(StudentBean studentBean) {
        return studentCRUD.save(studentBean);
    }

    @Override
    public StudentBean StudentId(int studentId) {
        return studentCRUD.findById(studentId).get();  //Java 8 Feature (optional class inside get())
    }

    @Override
    public List<StudentBean> studentList() {
        return studentCRUD.findAll();
    }

    @Override
    public void StudentInsertList(List<StudentBean> studentBeanList) {
        for(StudentBean bean :studentBeanList){
          System.out.println("ID "+bean.getId());
          System.out.println(("Name "+bean.getName()));
          System.out.println(("Age "+bean.getAge()));
          System.out.println(("Address "+bean.getAddress()));
        }
        studentCRUD.saveAll(studentBeanList);
    }

    @Override
    public StudentBean editStudent(int studentId, StudentBean studentBean) {
        StudentBean Bean=studentCRUD.findById(studentId).get();
        Bean.setId(studentBean.getId());
        Bean.setName((studentBean.getName()));
        Bean.setAge(studentBean.getAge());
        Bean.setAddress(studentBean.getAddress());

        StudentBean saveBean=studentCRUD.save(Bean);
        return saveBean;
    }

    @Override
    public void countStudent() {
        long i =studentCRUD.count();
        System.out.println("Student Count "+i);
    }

    @Override
    public void checking(int studentId) {
        boolean bool= studentCRUD.existsById(studentId);
        System.out.println(studentId+"ID Available :"+bool);
    }

    @Override
    public String deleteStudent(int studentId) {
        studentCRUD.deleteById(studentId);
        return "Deleted Successfully";
    }
}


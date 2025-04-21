package com.SpringBootCRUD.controller;

import com.SpringBootCRUD.bean.StudentBean;
import com.SpringBootCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentBean> insert(@RequestBody StudentBean studentBean) {
        return new ResponseEntity<>(studentService.insert(studentBean), HttpStatus.CREATED);
    }

//    @PostMapping("/insertList")
//    public void StudentInsertList(@RequestBody List<StudentBean> studentBeanList) {
//        studentService.StudentInsertList(studentBeanList);
//    }

    @GetMapping("{id}")
    public ResponseEntity<StudentBean> Studentid(@PathVariable("id") int studentId) {
        return new ResponseEntity<>(studentService.StudentId(studentId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentBean>> StudentList() {
        return ResponseEntity.ok(studentService.studentList());
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentBean> editStudent(@PathVariable("id") int StudentId, @RequestBody StudentBean studentBean) {
        studentBean.setId(StudentId);
        return ResponseEntity.ok(studentService.editStudent(StudentId, studentBean));
    }

//    @GetMapping("/studentcount")
//    public void countStudent() {
//        studentService.countStudent();
//    }
//
//    @GetMapping("/exists/{id}")
//    public void checking(@PathVariable("id") int studentId) {
//        studentService.checking(studentId);
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
      return  ResponseEntity.ok(studentService.deleteStudent(studentId));
    }
}


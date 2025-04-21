package com.SpringBootCRUD.repository;

import com.SpringBootCRUD.bean.StudentBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCRUD extends JpaRepository<StudentBean,Integer> {

}

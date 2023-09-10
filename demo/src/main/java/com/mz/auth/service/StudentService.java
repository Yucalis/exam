package com.mz.auth.service;

import com.mz.auth.entity.Student;
import com.mz.auth.query.StudentQuery;
import com.mz.auth.util.PageList;

public interface StudentService {

    void reg(Student student);

    Student login(Student student);

    String getNickName(Long stuId);

    PageList listpage(StudentQuery studentQuery);
}

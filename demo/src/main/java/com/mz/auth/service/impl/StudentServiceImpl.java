package com.mz.auth.service.impl;

import com.mz.auth.entity.Student;
import com.mz.auth.mapper.StudentMapper;
import com.mz.auth.query.StudentQuery;
import com.mz.auth.service.StudentService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void reg(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public Student login(Student student) {
        return studentMapper.login(student);
    }

    @Override
    public String getNickName(Long stuId) {
        return studentMapper.getNickName(stuId);
    }

    @Override
    public PageList listpage(StudentQuery studentQuery) {
        PageList pageList = new PageList();
        pageList.setTotal(studentMapper.queryTotalCount(studentQuery));
        pageList.setRows(studentMapper.queryData(studentQuery));
        return pageList;
    }
}

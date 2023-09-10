package com.mz.auth.web.controller;

import com.mz.auth.query.StudentQuery;
import com.mz.auth.service.StudentService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BehindStudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/index")
    public String toStudentIndex() {
        return "views/student/student_list";
    }

    @RequestMapping("/student/listpage")
    @ResponseBody
    public PageList listpage(StudentQuery studentQuery) {
        return studentService.listpage(studentQuery);
    }

}

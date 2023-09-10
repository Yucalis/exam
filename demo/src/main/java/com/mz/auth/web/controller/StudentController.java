package com.mz.auth.web.controller;

import com.mz.auth.entity.Student;
import com.mz.auth.service.StudentService;
import com.mz.auth.util.MzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/stu/login")
    @ResponseBody
    public MzResult login(Student student, HttpSession session) {
        try {
            String code = (String) session.getAttribute("code");
            if (!code.equals(student.getUsercode())) {
                return MzResult.error("验证码错误！");
            }
            Student stuDB = studentService.login(student);
            System.out.println("stuDB = " + stuDB);
            if (stuDB == null) {
                return MzResult.error("用户名或者密码错误！");
            } else {
                session.setAttribute("stuUser", stuDB);
                return MzResult.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    @PostMapping("/stu/regStu")
    @ResponseBody
    public MzResult regStu(Student student) {
        try {
            studentService.reg(student);
            return MzResult.ok();
        } catch (Exception e) {
            return MzResult.error(e.getMessage());
        }
    }

    @RequestMapping("/front/index")
    public String index() {
        return "/front/frontIndex";
    }

    @RequestMapping("/stu/logOut")
    public String logOut(HttpSession session) {
        session.removeAttribute("stuUser");
        return "/front/loginIndex";
    }

}

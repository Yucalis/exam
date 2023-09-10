package com.mz.auth.web.controller;

import com.mz.auth.entity.CheckPaperVO;
import com.mz.auth.entity.User;
import com.mz.auth.query.CheckExamQuery;
import com.mz.auth.query.UserQuery;
import com.mz.auth.service.TeacherService;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teacher/addTeacher")
    @ResponseBody
    public Long addTeacher(User user) {
        teacherService.addTeacher(user);
        return user.getId();
    }

    @RequestMapping("/teacher/index")
    public String index() {
        return "views/teacher/teacher_list";
    }

    @RequestMapping("/teacher/listpage")
    @ResponseBody
    public PageList teacherListPage(UserQuery userQuery) {
        userQuery.setType(2);
        return teacherService.listPage(userQuery);
    }

    @RequestMapping("/teacher/paperExamRecord")
    public String checkPaper() {
        return "views/teacher/paper_check";
    }

    @RequestMapping("/teacher/paperExamlistpage")
    @ResponseBody
    public PageList paperExamlistpage(CheckExamQuery checkExamQuery) {
        return teacherService.paperExamlistpage(checkExamQuery);
    }


    @RequestMapping("/teacher/updateJdtScore")
    @ResponseBody
    public MzResult updateJdtScore(CheckPaperVO checkPaperVO) {
        try {
            teacherService.updateJdtScore(checkPaperVO);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

}

package com.mz.auth.web.controller;

import com.mz.auth.entity.ExamScoreDetail;
import com.mz.auth.service.ExamService;
import com.mz.auth.util.MzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FrontExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/stu/examPaper")
    @ResponseBody
    public MzResult submitExamPaper(@RequestBody List<ExamScoreDetail> scoreDetails) {
        try {
            examService.saveExamScoreDetail(scoreDetails);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

}

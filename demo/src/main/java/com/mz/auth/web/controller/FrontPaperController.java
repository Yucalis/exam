package com.mz.auth.web.controller;

import com.mz.auth.entity.PaperGengerateVO;
import com.mz.auth.entity.Student;
import com.mz.auth.query.PaperQuery;
import com.mz.auth.service.ExamService;
import com.mz.auth.service.PaperQuestionService;
import com.mz.auth.service.PaperService;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class FrontPaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperQuestionService paperQuestionService;

    @Autowired
    private ExamService examService;

    @GetMapping("/paperindex/listpage")
    @ResponseBody
    public PageList listpage(PaperQuery paperQuery) {
        return paperService.listpage(paperQuery);
    }

    @GetMapping("/exam/canExam/{paperId}")
    @ResponseBody
    public MzResult isCanExam(@PathVariable("paperId") Long paperId, HttpSession session) {
        try {
            Student student = (Student) session.getAttribute("stuUser");
            System.out.println(student);
            if(examService.isCanExam(paperId, student.getId())) {
                return MzResult.ok();
            } else {
                return MzResult.error("考试已经完成，请勿重复考试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    @RequestMapping("/exam/popPaper/{paperId}")
    public String toExamPaper(@PathVariable("paperId")Long paperId, Model model) {
        PaperGengerateVO examPapersVO = paperQuestionService.previewPaper(paperId);
        model.addAttribute("examPapersVO", examPapersVO);
        return "front/examPaper";
    }

}

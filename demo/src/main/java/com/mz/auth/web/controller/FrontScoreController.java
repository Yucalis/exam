package com.mz.auth.web.controller;

import com.mz.auth.entity.Paper;
import com.mz.auth.entity.StuPaperQuestion;
import com.mz.auth.entity.StuScore;
import com.mz.auth.entity.Student;
import com.mz.auth.service.PaperService;
import com.mz.auth.service.StuScoreService;
import com.mz.auth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FrontScoreController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private StuScoreService stuScoreService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/stu/queryScorePage")
    public String toQueryScoreIndex(Model model, HttpSession session) {
        Student student = (Student) session.getAttribute("stuUser");
        if (student == null) {
            return "redirect:/front/login";
        }
        List<Paper> papers = paperService.findAll();
        model.addAttribute("papers", papers);
        return "front/queryScoreIndex";
    }

    @PostMapping("/stu/queryScoreData")
    @ResponseBody
    public StuScore queryScoreDate(@RequestBody StuScore stuScore) {
        StuScore score = stuScoreService.queryScoreDate(stuScore);
        if (score != null) {
            return score;
        } else {
            score = new StuScore();
            score.setStuId(stuScore.getStuId());
            score.setPaperId(stuScore.getPaperId());
            score.setNickName(studentService.getNickName(stuScore.getStuId()));
            score.setName(paperService.getPaperName(stuScore.getPaperId()));
            return score;
        }
    }

    @GetMapping("/stu/examDetailRecords")
    public String queryExamDetailRecords(Long paperId, Long stuId, Model model) {
        StuPaperQuestion stuPaperQuestion = stuScoreService.queryExamDetailRecords(paperId, stuId);
        model.addAttribute("stuPaperQuestionVO", stuPaperQuestion);
        return "front/examDetailIndex";
    }

    @RequestMapping("/stu/queryAllScorePage")
    public String queryAllScorePage(Model model, HttpSession session) {
        Student student = (Student) session.getAttribute("stuUser");
        if (student == null) {
            return "redirect:/front/login";
        }
        List<StuScore> allScores = stuScoreService.queryAllScoresByStuId(student.getId());
        model.addAttribute("allScores", allScores);
        return "front/queryAllScoreIndex";
    }

}

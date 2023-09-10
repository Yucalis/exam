package com.mz.auth.web.controller;

import com.mz.auth.entity.Question;
import com.mz.auth.query.QuestionQuery;
import com.mz.auth.service.QuestionService;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/listpage")
    @ResponseBody
    public PageList listpage(QuestionQuery questionQuery) {
        return questionService.listpage(questionQuery);
    }

    @RequestMapping("/question/index")
    public String index(Model model) {
        return "views/question/question_list";
    }

    @RequestMapping("/question/gotoAddQuestion")
    public String gotoAddQuestion() {
        return "views/question/question_add";
    }

    @PostMapping("/question/addQuestion")
    @ResponseBody
    public MzResult addQuestion(@RequestBody Question question) {
        try {
            questionService.addQuestion(question);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error("新增题目失败！");
        }
    }

    @RequestMapping("/question/gotoEditQuestion/{id}")
    public String gotoEditQuestion(@PathVariable("id") String id, Model model) {
        model.addAttribute("qid", id);
        return "views/question/question_edit";
    }

    @PostMapping("/question/queryQuestionByQid")
    @ResponseBody
    public Question queryQuestionByQid(Long qid) {
        return questionService.queryQuestionByQid(qid);
    }

    @PostMapping("/question/editQuestion")
    @ResponseBody
    public MzResult editQuestion(@RequestBody Question question) {
        try {
            questionService.editQuestion(question);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    @GetMapping("/question/deleteQuestion")
    @ResponseBody
    public MzResult deleteQuestion(Long id) {
        try {
            questionService.deleteQuestion(id);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

}

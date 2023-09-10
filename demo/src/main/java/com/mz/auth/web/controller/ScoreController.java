package com.mz.auth.web.controller;

import com.mz.auth.query.ScoreQuery;
import com.mz.auth.service.ScoreService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/score/index")
    public String toScoreIndex() {
        return "views/score/score_list";
    }

    @RequestMapping("/score/listpage")
    @ResponseBody
    public PageList listpage(ScoreQuery scoreQuery) {
        return scoreService.listpage(scoreQuery);
    }

}

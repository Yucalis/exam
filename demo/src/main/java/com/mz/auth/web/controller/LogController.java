package com.mz.auth.web.controller;

import com.mz.auth.query.LogQuery;
import com.mz.auth.service.LogService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/log/index")
    public String toLogIndex() {
        return "views/log/log_list";
    }

    @RequestMapping("/log/listpage")
    @ResponseBody
    public PageList listpage(LogQuery logQuery) {
        return logService.listpage(logQuery);
    }

}

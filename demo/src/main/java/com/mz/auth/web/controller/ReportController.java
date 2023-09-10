package com.mz.auth.web.controller;

import com.mz.auth.entity.ReportVO;
import com.mz.auth.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/report/index")
    public String toReportIndex() {
        return "views/report/report_list";
    }

    @RequestMapping("/report/getData")
    @ResponseBody
    public List<ReportVO> getData() {
        return reportService.getData();
    }

}

package com.mz.auth.service.impl;

import com.mz.auth.entity.ReportVO;
import com.mz.auth.mapper.ReportMapper;
import com.mz.auth.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<ReportVO> getData() {
        return reportMapper.getData();
    }
}

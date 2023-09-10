package com.mz.auth.service.impl;

import com.mz.auth.mapper.LogMapper;
import com.mz.auth.query.LogQuery;
import com.mz.auth.service.LogService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public PageList listpage(LogQuery logQuery) {
        PageList pageList = new PageList();
        pageList.setTotal(logMapper.getTotalCount(logQuery));
        pageList.setRows(logMapper.getData(logQuery));
        return pageList;
    }
}

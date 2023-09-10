package com.mz.auth.service.impl;

import com.mz.auth.mapper.ScoreMapper;
import com.mz.auth.query.ScoreQuery;
import com.mz.auth.service.ScoreService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public PageList listpage(ScoreQuery scoreQuery) {
        PageList pageList = new PageList();
        pageList.setTotal(scoreMapper.queryTotalCount(scoreQuery));
        pageList.setRows(scoreMapper.queryData(scoreQuery));
        return pageList;
    }
}

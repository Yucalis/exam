package com.mz.auth.service.impl;

import com.mz.auth.entity.StuPaperQuestion;
import com.mz.auth.entity.StuScore;
import com.mz.auth.mapper.StuScoreMapper;
import com.mz.auth.service.StuScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuScoreServiceImpl implements StuScoreService {

    @Autowired
    private StuScoreMapper stuScoreMapper;

    @Override
    public StuScore queryScoreDate(StuScore stuScore) {
        return stuScoreMapper.queryScoreDate(stuScore);
    }

    @Override
    public StuPaperQuestion queryExamDetailRecords(Long paperId, Long stuId) {
        return stuScoreMapper.queryExamDetailRecords(paperId, stuId);
    }

    @Override
    public List<StuScore> queryAllScoresByStuId(Long stuId) {
        return stuScoreMapper.queryAllScoresByStuId(stuId);
    }
}

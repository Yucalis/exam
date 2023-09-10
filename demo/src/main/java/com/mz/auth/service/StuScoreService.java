package com.mz.auth.service;

import com.mz.auth.entity.StuPaperQuestion;
import com.mz.auth.entity.StuScore;

import java.util.List;

public interface StuScoreService {

    StuScore queryScoreDate(StuScore stuScore);

    StuPaperQuestion queryExamDetailRecords(Long paperId, Long stuId);

    List<StuScore> queryAllScoresByStuId(Long stuId);
}

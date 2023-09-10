package com.mz.auth.service;

import com.mz.auth.entity.ExamScoreDetail;

import java.util.List;

public interface ExamService {

    void saveExamScoreDetail(List<ExamScoreDetail> scoreDetails);

    boolean isCanExam(Long paperId, Long stuId);
}

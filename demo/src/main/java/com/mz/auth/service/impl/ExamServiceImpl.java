package com.mz.auth.service.impl;

import com.mz.auth.entity.ExamScoreDetail;
import com.mz.auth.mapper.ExamMapper;
import com.mz.auth.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public void saveExamScoreDetail(List<ExamScoreDetail> scoreDetails) {
        examMapper.saveExamScoreDetail(scoreDetails);
    }

    @Override
    public boolean isCanExam(Long paperId, Long stuId) {
        List<ExamScoreDetail> scoreDetails = examMapper.isCanExam(paperId, stuId);
        if (!Objects.isNull(scoreDetails) && scoreDetails.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}

package com.mz.auth.mapper;

import com.mz.auth.entity.CheckPaperVO;
import com.mz.auth.query.CheckExamQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CheckExamMapper {

    List<CheckPaperVO> checkExamRecordData(CheckExamQuery checkExamQuery);

    Long checkExamRecordTotal(CheckExamQuery checkExamQuery);

    @Update("update exam_scoredetail set correntScore = #{correntScore} " +
            "where id = #{id}")
    void updateJdtScore(CheckPaperVO checkPaperVO);
}

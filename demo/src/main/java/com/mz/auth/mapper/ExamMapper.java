package com.mz.auth.mapper;

import com.mz.auth.entity.ExamScoreDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExamMapper {

    void saveExamScoreDetail(@Param("scoreDetails") List<ExamScoreDetail> scoreDetails);

    @Select("select * from exam_scoredetail where stuId = #{stuId} and paperId = #{paperId}")
    List<ExamScoreDetail> isCanExam(@Param("paperId") Long paperId, @Param("stuId") Long stuId);
}

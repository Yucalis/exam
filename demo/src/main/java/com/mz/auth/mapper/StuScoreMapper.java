package com.mz.auth.mapper;

import com.mz.auth.entity.StuPaperQuestion;
import com.mz.auth.entity.StuScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuScoreMapper {

    @Select("select * from v_stuscore where stuId = #{stuId} and paperId = #{paperId}")
    StuScore queryScoreDate(StuScore stuScore);

    StuPaperQuestion queryExamDetailRecords(@Param("paperId") Long paperId, @Param("stuId") Long stuId);

    @Select("select * from v_stuscore where stuId = #{stuId}")
    List<StuScore> queryAllScoresByStuId(@Param("stuId") Long stuId);
}

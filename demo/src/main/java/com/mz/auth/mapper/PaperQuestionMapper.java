package com.mz.auth.mapper;

import com.mz.auth.entity.PaperGengerateVO;
import com.mz.auth.entity.PaperQuestion;
import com.mz.auth.entity.TypeTotalVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaperQuestionMapper {

    @Select("select * from exam_paper_question where paperId = #{paperId}")
    List<PaperQuestion> queryQuestionByPaperId(Long paperId);

    @Delete("delete from exam_paper_question where paperid = #{id}")
    void deletePaperQuestion(Long id);


    @Insert("<script>insert into exam_paper_question(paperId, questionId) values " +
            "<foreach collection='list' item='item' separator=','>\n" +
            "(#{item.paperId}, #{item.questionId})\n" +
            "</foreach>" +
            "</script>")
    void insertBatchPaperQuestion(List<Map> params);

    PaperGengerateVO previewPaper(Long paperId);

    @Select("select q_typeid, count(*) totalNum from exam_questionbank group by q_typeid")
    List<TypeTotalVO> queryTypeTotal();
}

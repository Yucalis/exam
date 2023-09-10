package com.mz.auth.mapper;

import com.mz.auth.entity.Question;
import com.mz.auth.entity.QuestionXztOptions;
import com.mz.auth.query.QuestionQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    Long queryTotal(QuestionQuery questionQuery);

    List<Question> queryData(QuestionQuery questionQuery);


    @Insert("insert into " +
            "exam_questionbank(questionTitle, questionAnswer, grade, " +
            "q_typeid, status, createTime, creatorId) " +
            "values(#{questionTitle}, #{questionAnswer}, #{grade}, " +
            "#{q_typeid}, #{status}, #{createTime}, #{creatorId})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")  //主键回填注解
    void addQuestion(Question question);

    @Insert("insert into " +
            "exam_xzt_options(optionA, optionB, optionC, optionD, questionId) " +
            "values(#{optionA}, #{optionB}, #{optionC}, #{optionD}, #{questionId})")
    void addXztOption(QuestionXztOptions questionXztOptions);

    @Select("select * from exam_questionbank where id = #{qid}")
    @Results(value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "id", property = "questionXztOptions",
                    one = @One(select = "getQuestionOptionsByQid"))
    })
    Question queryQuestionByQid(Long qid);

    @Select("select * from exam_xzt_options where questionId = #{qid}")
    QuestionXztOptions getQuestionOptionsByQid(Long qid);

    @Update("update exam_questionbank set questionTitle = #{questionTitle}, " +
            "questionAnswer = #{questionAnswer}, grade = #{grade}, " +
            "q_typeid = #{q_typeid}, creatorId = #{creatorId} where id = #{id}")
    void updateQuestion(Question question);

    @Delete("delete from exam_xzt_options where questionId = #{id}")
    void deleteXztOptions(Long id);

    @Delete("delete from exam_questionbank where id = #{id}")
    void deleteQuestion(Long id);

    @Select("select id from exam_questionbank where q_typeid = #{q_typeid}")
    @ResultType(Long.class)
    List<Long> queryQuestionByTypeId(Long q_typeid);
}

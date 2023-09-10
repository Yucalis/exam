package com.mz.auth.entity;

import lombok.Data;

@Data
public class StuQuestionQueryVO {

    /**
     * 问题主键id
     */
    private Long questionId;

    /**
     * 问题题目
     */
    private String questionTitle;

    /**
     * 学生答案
     */
    private String stuAnswer;

    /**
     * 正确答案
     */
    private String correntAnswer;

    /**
     * 题目类型id
     */
    private Long q_typeid;

    /**
     * 题目分数
     */
    private Integer grade;

    /**
     * 正确得分
     */
    private Integer correntScore;

    /**
     * 选择题选项
     */
    private QuestionXztOptions questionXztOptions;

}

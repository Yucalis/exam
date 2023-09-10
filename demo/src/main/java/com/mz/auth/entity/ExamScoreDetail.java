package com.mz.auth.entity;

import lombok.Data;

@Data
public class ExamScoreDetail {

    /**
     * 考试答题详情主键id
     */
    private Long id;

    /**
     * 学生主键id
     */
    private Long stuId;

    /**
     * 试卷主键id
     */
    private Long paperId;

    /**
     * 问题主键id
     */
    private Long questionId;

    /**
     * 问题题目
     */
    private String questionTitle;

    /**
     * 问题类型id
     */
    private Long q_typeid;

    /**
     * 问题答案
     */
    private String questionAnswer;

    /**
     * 问题分数
     */
    private String questionScore;

    /**
     * 学生答案
     */
    private String correntAnswer;

    /**
     * 学生分数
     */
    private String correntScore;

}

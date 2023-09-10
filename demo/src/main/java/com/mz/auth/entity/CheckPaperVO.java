package com.mz.auth.entity;

import lombok.Data;

@Data
public class CheckPaperVO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 学生id
     */
    private Long stuId;

    /**
     * 用来存放学生姓名
     */
    private Student student;

    /**
     * 试卷id
     */
    private Long paperId;

    /**
     * 用来存放试卷名称
     */
    private Paper paper;

    /**
     * 问题id
     */
    private Long questionId;

    /**
     * 问题题目
     */
    private String questionTitle;

    /**
     * 学生答案
     */
    private String questionAnswer;

    /**
     * 正确答案
     */
    private String correntAnswer;

    /**
     * 问题分数
     */
    private Long questionScore;

    /**
     * 学生分数
     */
    private Long correntScore;

}

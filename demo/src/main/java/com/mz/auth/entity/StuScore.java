package com.mz.auth.entity;

import lombok.Data;

@Data
public class StuScore {

    /**
     * 学生主键id
     */
    private Long stuId;

    /**
     * 试卷主键id
     */
    private Long paperId;

    /**
     * 学生昵称
     */
    private String nickName;

    /**
     * 试卷名称
     */
    private String name;

    /**
     * 学生成绩
     */
    private Long totalScore;

}

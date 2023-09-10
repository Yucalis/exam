package com.mz.auth.entity;

import lombok.Data;

@Data
public class ReportVO {

    /**
     * 学生昵称
     */
    private String nickName;

    /**
     * 总成绩
     */
    private Long totalScore;

}

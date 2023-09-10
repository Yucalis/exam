package com.mz.auth.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StuPaperQuestion {

    /**
     * 试卷主键id
     */
    private Long id;

    /**
     * 试卷名称
     */
    private String name;

    /**
     * 题目集合列表
     */
    private List<StuQuestionQueryVO> stuQuestionsList = new ArrayList<>();

}

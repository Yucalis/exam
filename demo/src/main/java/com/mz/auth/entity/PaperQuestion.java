package com.mz.auth.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个实体对应的是 试卷 和 题目 的中间表
 */
@Data
public class PaperQuestion {

    /**
     * 试卷问题id的主键
     */
    private Long id;

    /**
     * 试卷主键id
     */
    private Long paperId;

    /**
     * 问题主键id
     */
    private Long questionId;

    /**
     * 接收前端传递过来的 问题id 的list集合列表
     * 组卷时才用到
     */
    List<Question> questionIdsList = new ArrayList<>();

}

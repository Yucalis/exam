package com.mz.auth.entity;

import lombok.Data;

@Data
public class TypeTotalVO {

    /**
     * 题目类型
     */
    private Long q_typeid;

    /**
     * 题库中该类型题目的总数量
     */
    private Long totalNum;

}

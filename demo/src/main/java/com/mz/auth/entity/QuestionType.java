package com.mz.auth.entity;

import lombok.Data;

@Data
public class QuestionType {

    /**
     * 问题类型主键id
     */
    private Long id;

    /**
     * 问题类型名称
     */
    private String name;

    /**
     * 问题类型描述
     */
    private String  desc;

    /**
     * 问题类型编号
     */
    private String typeNum;

}

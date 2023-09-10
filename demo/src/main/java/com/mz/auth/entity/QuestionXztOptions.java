package com.mz.auth.entity;

import lombok.Data;

@Data
public class QuestionXztOptions {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 选项A
     */
    private String optionA;

    /**
     * 选项B
     */
    private String optionB;

    /**
     * 选项C
     */
    private String optionC;

    /**
     * 选项D
     */
    private String optionD;

    /**
     * 对应选择题的主键id
     */
    private Long questionId;

}

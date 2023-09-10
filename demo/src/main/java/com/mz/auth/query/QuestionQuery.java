package com.mz.auth.query;

import lombok.Data;

/**
 * 用来接收前端模糊查询的条件和分页参数的对象
 */
@Data
public class QuestionQuery extends BaseQuery {

    /**
     * 问题名称
     */
    private String questionTitle;

}

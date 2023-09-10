package com.mz.auth.query;

import lombok.Data;

@Data
public class CheckExamQuery extends BaseQuery {

    private Long paperId;

    private Long questionId;

}

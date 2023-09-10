package com.mz.auth.query;

import lombok.Data;

@Data
public class PaperQuery extends BaseQuery {

    /**
     * 试卷id
     */
    private Long id;

    /**
     * 试卷名称
     */
    private String name;

}

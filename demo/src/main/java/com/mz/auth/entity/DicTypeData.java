package com.mz.auth.entity;

import lombok.Data;

@Data
public class DicTypeData {

    /**
     * 主键信息
     */
    private Long id;

    /**
     * 试卷的难易程度
     */
    private String name;

    /**
     * 关联类型表id
     */
    private Long typeid;

}

package com.mz.auth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Question {

    /**
     * 问题主键id
     */
    private Long id;

    /**
     * 问题题目
     */
    private String questionTitle;

    /**
     * 问题答案
     */
    private String questionAnswer;

    /**
     * 问题类型
     */
    private Long q_typeid;

    /**
     * 问题状态
     */
    private Long status;

    /**
     * 问题创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //前台页面展示的时间格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //后台接收到时间的类型
    private Date createTime;

    /**
     * 问题等级
     */
    private Integer grade;

    /**
     * 创建者主键id
     */
    private Long creatorId;

    /**
     * 问题类型的对象
     * 主要是为了在前端显示中文类型
     */
    private QuestionType questionType;

    /**
     * 不管你是不是选择题都带上选项对象
     * 是选择题就有对应的值
     * 不是选择题则没有
     */
    private QuestionXztOptions questionXztOptions;

    /**
     * 只存储创建者的昵称
     */
    private User user;


}

package com.mz.auth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Student {

    private Long id;

    private String username;

    private String password;

    private String tel;

    private String email;

    private String stuNum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //前台页面展示的时间格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //后台接收到时间的类型
    private Date createTime;

    private String nickName;

    private String usercode;

}

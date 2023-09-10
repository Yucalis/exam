package com.mz.auth.service.impl;

import com.mz.auth.entity.CheckPaperVO;
import com.mz.auth.entity.User;
import com.mz.auth.mapper.CheckExamMapper;
import com.mz.auth.mapper.UserMapper;
import com.mz.auth.query.CheckExamQuery;
import com.mz.auth.query.UserQuery;
import com.mz.auth.service.TeacherService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CheckExamMapper checkExamMapper;

    @Override
    public void addTeacher(User user) {
//        设置用户类型，2代表老师
        user.setType(2);
//        设置用户创建时间
        user.setCreateTime(new Date());
//        密码加密
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userMapper.addUser(user);
    }

    @Override
    public PageList listPage(UserQuery userQuery) {
//        将查询到的记录封装到PageList对象中
        PageList pageList = new PageList();
//        查询到的记录的数目
        pageList.setTotal(userMapper.queryTotal(userQuery));
//        查询到的记录
        pageList.setRows(userMapper.queryData(userQuery));
        return pageList;
    }

    @Override
    public PageList paperExamlistpage(CheckExamQuery checkExamQuery) {
        PageList pageList = new PageList();
        pageList.setTotal(checkExamMapper.checkExamRecordTotal(checkExamQuery));
        pageList.setRows(checkExamMapper.checkExamRecordData(checkExamQuery));
        return pageList;
    }

    @Override
    public void updateJdtScore(CheckPaperVO checkPaperVO) {
        checkExamMapper.updateJdtScore(checkPaperVO);
    }
}

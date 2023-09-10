package com.mz.auth.service;

import com.mz.auth.entity.CheckPaperVO;
import com.mz.auth.entity.User;
import com.mz.auth.query.CheckExamQuery;
import com.mz.auth.query.UserQuery;
import com.mz.auth.util.PageList;

public interface TeacherService {

    void addTeacher(User user);

    PageList listPage(UserQuery userQuery);

    PageList paperExamlistpage(CheckExamQuery checkExamQuery);

    void updateJdtScore(CheckPaperVO checkPaperVO);
}

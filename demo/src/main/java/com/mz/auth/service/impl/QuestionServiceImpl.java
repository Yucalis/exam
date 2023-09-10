package com.mz.auth.service.impl;

import com.mz.auth.entity.Question;
import com.mz.auth.entity.QuestionXztOptions;
import com.mz.auth.mapper.QuestionMapper;
import com.mz.auth.query.QuestionQuery;
import com.mz.auth.service.QuestionService;
import com.mz.auth.util.CommonUtils;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public PageList listpage(QuestionQuery questionQuery) {
        PageList pageList = new PageList();
        pageList.setTotal(questionMapper.queryTotal(questionQuery));
        pageList.setRows(questionMapper.queryData(questionQuery));
        return pageList;
    }

    /**
     * 怎么去实现新增？涉及到几张表？
     * 问题表、选项表 这里又涉及到了多张表的修改操作
     * @param question 题目
     */
    @Override
    @Transactional
    public void addQuestion(Question question) {
        System.out.println(question);
//        新增题目到数据库
        question.setStatus(0L);
        question.setCreateTime(new Date());
        question.setCreatorId(CommonUtils.getLoginUser().getId());
        questionMapper.addQuestion(question);
//        判断一下是不是选择题 1表示是选择题
//        如果是选择题就需要保存选项
        if (question.getQ_typeid() == 1L) {
//            进入if就说明是选择题
//            从question中先获取选择题的对象
            QuestionXztOptions xztOptions = question.getQuestionXztOptions();
//            设置该选项对应的题目id
            xztOptions.setQuestionId(question.getId());
            questionMapper.addXztOption(xztOptions);
        }
    }

    @Override
    public Question queryQuestionByQid(Long qid) {
        return questionMapper.queryQuestionByQid(qid);
    }

    @Override
    @Transactional
    public void editQuestion(Question question) {
//        重新获取登录用户的id（即将题目的修改者重新定义为题目的创建者
//        同时防止有其他人在修改题目，所以重新获取
        question.setCreatorId(CommonUtils.getLoginUser().getId());
//        修改题目
        questionMapper.updateQuestion(question);
//        如果是选择题，则先删除所有的选项，再重新添加
        questionMapper.deleteXztOptions(question.getId());
        if (question.getQ_typeid() == 1L) {
            QuestionXztOptions questionXztOptions = question.getQuestionXztOptions();
            questionXztOptions.setQuestionId(question.getId());
            questionMapper.addXztOption(questionXztOptions);
        }
    }

    @Override
    @Transactional
    public void deleteQuestion(Long id) {
//        无论是不是选择题，先根据id在选项表中删除选项
        questionMapper.deleteXztOptions(id);
//        再删除问题表
        questionMapper.deleteQuestion(id);
    }
}

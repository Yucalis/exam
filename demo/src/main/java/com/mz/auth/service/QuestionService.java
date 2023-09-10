package com.mz.auth.service;

import com.mz.auth.entity.Question;
import com.mz.auth.query.QuestionQuery;
import com.mz.auth.util.PageList;

public interface QuestionService {

    PageList listpage(QuestionQuery questionQuery);

    void addQuestion(Question question);

    Question queryQuestionByQid(Long qid);

    void deleteQuestion(Long id);

    void editQuestion(Question question);
}

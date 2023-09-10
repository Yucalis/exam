package com.mz.auth.service;

import com.mz.auth.entity.PaperGengerateVO;
import com.mz.auth.entity.PaperQuestion;
import com.mz.auth.entity.TypeTotalVO;

import java.util.List;
import java.util.Map;

public interface PaperQuestionService {

    List<PaperQuestion> queryQuestionByPaperId(Long paperId);

    void diyPaperQuestion(PaperQuestion paperQuestion);

    PaperGengerateVO previewPaper(Long paperId);

    List<TypeTotalVO> queryTypeTotal();

    void randomPaperQuestion(Map map);
}

package com.mz.auth.service.impl;

import com.mz.auth.entity.PaperGengerateVO;
import com.mz.auth.entity.PaperQuestion;
import com.mz.auth.entity.TypeTotalVO;
import com.mz.auth.mapper.PaperQuestionMapper;
import com.mz.auth.mapper.QuestionMapper;
import com.mz.auth.service.PaperQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaperQuestionServiceImpl implements PaperQuestionService {

    @Autowired
    private PaperQuestionMapper paperQuestionMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<PaperQuestion> queryQuestionByPaperId(Long paperId) {
        return paperQuestionMapper.queryQuestionByPaperId(paperId);
    }

    @Override
    public void diyPaperQuestion(PaperQuestion paperQuestion) {
//        1、先删除试卷对应的题目
//        System.out.println(paperQuestion);
        paperQuestionMapper.deletePaperQuestion(paperQuestion.getPaperId());
//        2、再把选的问题重新导入试卷
        List<Map> params = paperQuestion.getQuestionIdsList().stream().map(question ->{
            Map mp = new HashMap<>();
            mp.put("paperId", paperQuestion.getPaperId());
            mp.put("questionId", question.getId());
            return mp;
        }).collect(Collectors.toList());
//        List<Map> params = new ArrayList<>();
//        List<Question> questionIdList = paperQuestion.getQuestionIdsList();
//        for (Question question : questionIdList) {
//            Map<String, Long> map = new HashMap<>();
//            map.put("paperId", paperQuestion.getPaperId());
//            map.put("questionId", question.getId());
//            params.add(map);
//        }
//        System.out.println(params);
        paperQuestionMapper.insertBatchPaperQuestion(params);
    }

    @Override
    public PaperGengerateVO previewPaper(Long paperId) {
        return paperQuestionMapper.previewPaper(paperId);
    }

    @Override
    public List<TypeTotalVO> queryTypeTotal() {
        return paperQuestionMapper.queryTypeTotal();
    }

    @Override
    @Transactional
    public void randomPaperQuestion(Map map) {
//        存放随机组卷的题目id的集合
        List<Long> ids = new ArrayList<>();
//        接收前台传递过来的要随机组卷的试卷的id
        Long paperId = Long.valueOf((String) map.get("paperId"));
//        接收前台传递过来的要随机组卷的选择题的数量
        Long xztNum = Long.valueOf((String) map.get("xztNum"));
//        接收前台传递过来的要随机组卷的填空题的数量
        Long tktNum = Long.valueOf((String) map.get("tktNum"));
//        接收前台传递过来的要随机组卷的判断题的数量
        Long pdtNum = Long.valueOf((String) map.get("pdtNum"));
//        接收前台传递过来的要随机组卷的简答题的数量
        Long jdtNum = Long.valueOf((String) map.get("jdtNum"));
//        查询出所有选择题的id
        List<Long> xztIds = questionMapper.queryQuestionByTypeId(1L);
//        从查询结果中随机选择id
        for (int i = 0; i < xztNum; i++) {
//            在查询出来的选择题列表内随机选择题目
            Long id = xztIds.get(new Random().nextInt(xztIds.size()));
//            将题目先存放到集合中
            ids.add(id);
//            移除已被选择的题目，防止后面重复选择
            xztIds.remove(id);
        }
//        查询出所有填空题的id
        List<Long> tktIds = questionMapper.queryQuestionByTypeId(2L);
//        从查询结果中随机选择id
        for (int i = 0; i < tktNum; i++) {
//            在查询出来的选择题列表内随机选择题目
            Long id = tktIds.get(new Random().nextInt(tktIds.size()));
//            将题目先存放到集合中
            ids.add(id);
//            移除已被选择的题目，防止后面重复选择
            tktIds.remove(id);
        }
//        查询出所有判断题的id
        List<Long> pdtIds = questionMapper.queryQuestionByTypeId(3L);
//        从查询结果中随机选择id
        for (int i = 0; i < pdtNum; i++) {
//            在查询出来的选择题列表内随机选择题目
            Long id = pdtIds.get(new Random().nextInt(pdtIds.size()));
//            将题目先存放到集合中
            ids.add(id);
//            移除已被选择的题目，防止后面重复选择
            pdtIds.remove(id);
        }
//        查询出所有简答题的id
        List<Long> jdtIds = questionMapper.queryQuestionByTypeId(4L);
//        从查询结果中随机选择id
        for (int i = 0; i < jdtNum; i++) {
//            在查询出来的选择题列表内随机选择题目
            Long id = jdtIds.get(new Random().nextInt(jdtIds.size()));
//            将题目先存放到集合中
            ids.add(id);
//            移除已被选择的题目，防止后面重复选择
            jdtIds.remove(id);
        }
//        先删除原先试卷的题目
        paperQuestionMapper.deletePaperQuestion(paperId);
//        List<Map> params = (List) ids.stream().map(id ->{
//            Map map1 = new HashMap<>();
//            map1.put("paperId", paperId);
//            map1.put("questionId", id);
//            return map1;
//        }).collect(Collectors.toList());
        List<Map> params = new ArrayList<>();
        for (Long questionId : ids) {
            Map map1 = new HashMap<>();
            map1.put("paperId", paperId);
            map1.put("questionId", questionId);
            params.add(map1);
        }
        paperQuestionMapper.insertBatchPaperQuestion(params);
    }
}

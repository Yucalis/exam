package com.mz.auth.service.impl;

import com.mz.auth.entity.Paper;
import com.mz.auth.mapper.PaperMapper;
import com.mz.auth.query.PaperQuery;
import com.mz.auth.service.PaperService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public PageList listpage(PaperQuery paperQuery) {
        PageList pageList = new PageList();
        pageList.setTotal(paperMapper.queryTotal(paperQuery));
        pageList.setRows(paperMapper.queryData(paperQuery));
        return pageList;
    }

    @Override
    public List<Paper> findAll() {
        return paperMapper.findAll();
    }

    @Override
    public void savePaper(Paper paper) {
//        设置试卷状态，0为正在使用，1为已停用
        paper.setStatus(0);
//        设置试卷创建时间
        paper.setCreateTime(new Date());
        paperMapper.savePaper(paper);
    }

    @Override
    public void editSavePaper(Paper paper) {
        paperMapper.editSavePaper(paper);
    }

    /*
        涉及到两张表的级联删除，所以应采用事务的方式进行删除操作
     */
    @Override
    @Transactional
    public void deletePaper(Long id) {
//        删除试卷的组题记录
        paperMapper.deletePaperQuestion(id);
//        删除试卷
        paperMapper.deletePapper(id);
    }

    @Override
    public String getPaperName(Long paperId) {
        return paperMapper.getPaperName(paperId);
    }
}

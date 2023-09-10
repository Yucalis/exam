package com.mz.auth.service;

import com.mz.auth.entity.Paper;
import com.mz.auth.query.PaperQuery;
import com.mz.auth.util.PageList;

import java.util.List;

public interface PaperService {

    /**
     * 分页方法
     * @param paperQuery
     * @return
     */
    PageList listpage(PaperQuery paperQuery);

    /**
     * 查询所有的试卷信息
     * @return
     */
    List<Paper> findAll();

    /**
     * 保存试卷
     * @param paper
     */
    void savePaper(Paper paper);

    /**
     * 修改保存试卷
     * @param paper
     */
    void editSavePaper(Paper paper);

    void deletePaper(Long id);

    String getPaperName(Long paperId);
}

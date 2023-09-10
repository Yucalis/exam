package com.mz.auth.service;

import com.mz.auth.entity.DicType;
import com.mz.auth.entity.DicTypeData;
import com.mz.auth.query.DicQuery;
import com.mz.auth.util.PageList;

import java.util.List;

public interface DicService {

    /**
     * 查询试卷的所有等级
     * @return
     */
    List<DicTypeData> findLevels();

    PageList listpage(DicQuery dicQuery);

    List<DicType> queryDicType();

    List<Long> queryDicTypeDataIdsByTypeid(Long typeid);

    void savaDicTypeData(DicTypeData dicTypeData);

    void editSaveDicTypeData(DicTypeData dicTypeData);

    void deleteDicTypeData(Long id);

    void saveDicType(DicType dicType);

    DicType queryDicTypeInfoById(Long id);

    void editSaveDicType(DicType dicType);

    void deleteDicType(Long id);
}

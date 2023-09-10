package com.mz.auth.service.impl;

import com.mz.auth.entity.DicType;
import com.mz.auth.entity.DicTypeData;
import com.mz.auth.mapper.DicMapper;
import com.mz.auth.query.DicQuery;
import com.mz.auth.service.DicService;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DicServiceImpl implements DicService {

    @Autowired
    private DicMapper dicMapper;

    @Override
    public List<DicTypeData> findLevels() {
        return dicMapper.findLevels();
    }

    @Override
    public PageList listpage(DicQuery dicQuery) {
        PageList pageList = new PageList();
        pageList.setTotal(dicMapper.getTotalCount(dicQuery));
        pageList.setRows(dicMapper.getData(dicQuery));
        return pageList;
    }

    @Override
    public List<DicType> queryDicType() {
        return dicMapper.queryDicType();
    }

    @Override
    public List<Long> queryDicTypeDataIdsByTypeid(Long typeid) {
        return dicMapper.queryDicTypeDataIdsByTypeid(typeid);
    }

    @Override
    public void savaDicTypeData(DicTypeData dicTypeData) {
        dicMapper.saveDicTypeData(dicTypeData);
    }

    @Override
    public void editSaveDicTypeData(DicTypeData dicTypeData) {
        dicMapper.editSaveDicTypeData(dicTypeData);
    }

    @Override
    public void deleteDicTypeData(Long id) {
        dicMapper.deleteDicTypeData(id);
    }

    @Override
    public void saveDicType(DicType dicType) {
        dicMapper.saveDicType(dicType);
    }

    @Override
    public DicType queryDicTypeInfoById(Long id) {
        return dicMapper.queryDicTypeInfoById(id);
    }

    @Override
    public void editSaveDicType(DicType dicType) {
        dicMapper.editSaveDicType(dicType);
    }

    @Override
    @Transactional
    public void deleteDicType(Long id) {
        dicMapper.deleteDicTypeDataByTypeid(id);
        dicMapper.deleteDicType(id);
    }
}

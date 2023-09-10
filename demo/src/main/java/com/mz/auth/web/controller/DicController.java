package com.mz.auth.web.controller;

import com.mz.auth.entity.DicType;
import com.mz.auth.entity.DicTypeData;
import com.mz.auth.query.DicQuery;
import com.mz.auth.service.DicService;
import com.mz.auth.util.MzResult;
import com.mz.auth.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DicController {

    @Autowired
    private DicService dicService;

    @RequestMapping("/dic/index")
    public String toDicIndex() {
        return "views/dic/dic_list";
    }

    @RequestMapping("/dic/listpage")
    @ResponseBody
    public PageList listpage(DicQuery dicQuery) {
        return dicService.listpage(dicQuery);
    }

    @PostMapping("dic/queryDicType")
    @ResponseBody
    public List<DicType> queryDicType() {
        return dicService.queryDicType();
    }

    @PostMapping("/dic/queryDicTypeDataIdsByTypeid")
    @ResponseBody
    public List<Long> queryDicTypeDataIdsByTypeid(Long typeid) {
        return dicService.queryDicTypeDataIdsByTypeid(typeid);
    }

    @PostMapping("/dic/saveDicTypeData")
    @ResponseBody
    public MzResult saveDicTypeData(@RequestBody DicTypeData dicTypeData) {
        try {
            dicService.savaDicTypeData(dicTypeData);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    @PostMapping("/dic/editSaveDicTypeData")
    @ResponseBody
    public MzResult editSaveDicTypeData(@RequestBody DicTypeData dicTypeData) {
        try {
            dicService.editSaveDicTypeData(dicTypeData);
            return MzResult.ok();
        } catch (Exception e) {
            return MzResult.error(e.getMessage());
        }
    }


    @PostMapping("/dic/deleteDicTypeData")
    @ResponseBody
    public MzResult deleteDicTypeData(Long id) {
        try {
            dicService.deleteDicTypeData(id);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    @PostMapping("/dic/saveDicType")
    @ResponseBody
    public MzResult saveDicType(@RequestBody DicType dicType) {
        try {
            dicService.saveDicType(dicType);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    @PostMapping("/dic/queryDicTypeInfoById")
    @ResponseBody
    public DicType queryDicTypeInfoById(Long id) {
        return dicService.queryDicTypeInfoById(id);
    }

    @PostMapping("/dic/editSaveDicType")
    @ResponseBody
    public MzResult editSaveDicType(@RequestBody DicType dicType) {
        try {
            dicService.editSaveDicType(dicType);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }

    @PostMapping("/dic/deleteDicType")
    @ResponseBody
    public MzResult deleteDicType(Long id) {
        try {
            dicService.deleteDicType(id);
            return MzResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return MzResult.error(e.getMessage());
        }
    }


}

package com.mz.auth.mapper;

import com.mz.auth.entity.ReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReportMapper {

    @Select("select nickName, totalScore from v_stuscore")
    List<ReportVO> getData();

}

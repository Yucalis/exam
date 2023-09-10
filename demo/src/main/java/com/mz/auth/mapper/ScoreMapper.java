package com.mz.auth.mapper;

import com.mz.auth.entity.StuScore;
import com.mz.auth.query.ScoreQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {

    Long queryTotalCount(ScoreQuery scoreQuery);

    List<StuScore> queryData(ScoreQuery scoreQuery);

}

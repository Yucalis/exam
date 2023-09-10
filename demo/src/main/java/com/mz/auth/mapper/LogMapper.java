package com.mz.auth.mapper;

import com.mz.auth.entity.Log;
import com.mz.auth.query.LogQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {

    Long getTotalCount(LogQuery logQuery);

    List<Log> getData(LogQuery logQuery);
}

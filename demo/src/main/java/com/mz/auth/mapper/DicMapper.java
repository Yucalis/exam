package com.mz.auth.mapper;

import com.mz.auth.entity.DicType;
import com.mz.auth.entity.DicTypeData;
import com.mz.auth.query.DicQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DicMapper {

    @Select("select * from t_dictype_data where typeid = 1")
    List<DicTypeData> findLevels();

    Long getTotalCount(DicQuery dicQuery);

    List<DicTypeData> getData(DicQuery dicQuery);

    @Select("select * from t_dictype")
    @ResultType(DicType.class)
    List<DicType> queryDicType();

    @Select("select id from t_dictype_data where typeid = #{typeid}")
    @ResultType(Long.class)
    List<Long> queryDicTypeDataIdsByTypeid(@Param("typeid") Long typeid);

    @Insert("insert into t_dictype_data values(null, #{name}, #{typeid})")
    void saveDicTypeData(DicTypeData dicTypeData);

    @Update("update t_dictype_data set name = #{name} where id = #{id}")
    void editSaveDicTypeData(DicTypeData dicTypeData);

    @Delete("delete from t_dictype_data where id = #{id}")
    void deleteDicTypeData(@Param("id") Long id);

    @Insert("insert into t_dictype values(null, #{sn}, #{info})")
    void saveDicType(DicType dicType);

    @Select("select * from t_dictype where id = #{id}")
    @ResultType(DicType.class)
    DicType queryDicTypeInfoById(@Param("id") Long id);

    @Update("update t_dictype set sn = #{sn}, info = #{info} where id = #{id}")
    void editSaveDicType(DicType dicType);

    @Delete("delete from t_dictype_data where typeid = #{typeid}")
    void deleteDicTypeDataByTypeid(@Param("typeid") Long id);

    @Delete("delete from t_dictype where id = #{id}")
    void deleteDicType(@Param("id") Long id);
}

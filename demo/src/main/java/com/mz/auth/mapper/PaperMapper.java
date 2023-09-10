package com.mz.auth.mapper;

import com.mz.auth.entity.Paper;
import com.mz.auth.query.PaperQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaperMapper {

    /**
     * 查询记录的总条数
     * @param paperQuery
     * @return
     */
    Long queryTotal(PaperQuery paperQuery);

    /**
     * 查询当前页所要显示的数据
     * @param paperQuery
     * @return
     */
    List<Paper> queryData(PaperQuery paperQuery);

    /**
     * 查询所有的试卷信息
     * @return
     */
    List<Paper> findAll();

    /**
     * 保存试卷信息
     * @param paper
     */
    @Insert("insert into exam_paper(name, startTime, endTime, createTime, status, levelid)" +
        "values(#{name}, #{startTime}, #{endTime}, #{createTime}, #{status}, #{levelid})")
    void savePaper(Paper paper);

    @Update("update exam_paper set name = #{name}, startTime = #{startTime}, " +
        "endTime = #{endTime}, levelid = #{levelid} where id = #{id}")
    void editSavePaper(Paper paper);

    @Delete("delete from exam_paper where id = #{id}")
    void deletePapper(Long id);

    @Delete("delete from exam_paper_question where paperid = #{id}")
    void deletePaperQuestion(Long id);

    @Select("select name from exam_paper where id = #{paperId}")
    String getPaperName(@Param("paperId") Long paperId);
}

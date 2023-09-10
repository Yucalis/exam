package com.mz.auth.mapper;

import com.mz.auth.entity.Student;
import com.mz.auth.query.StudentQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Insert("insert into t_student values(null, #{username}, #{password}, #{tel}, #{email}, #{stuNum}, #{createTime}, #{nickName})")
    void addStudent(Student student);

    @Select("select * from t_student where username = #{username} and password = #{password}")
    @ResultType(Student.class)
    Student login(Student student);

    @Select("select nickName from t_student where id = #{stuId}")
    String getNickName(@Param("stuId") Long stuId);

    Long queryTotalCount(StudentQuery studentQuery);

    List<Student> queryData(StudentQuery studentQuery);
}

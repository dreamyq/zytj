package com.zmql.zytj.mapper;

import com.zmql.zytj.bean.TeachersExcel;
import com.zmql.zytj.bean.TeachersPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersMapper {
    /***
     * 查询所有教师
     * @return
     */
    List<TeachersExcel> queryAllTeacher();
    /**
     * 添加一位老师
     * @param teachersExcel
     * @return
     */
    Integer addTeacher(TeachersExcel teachersExcel);

    /**
     * 带条件的分页查询老师
     * @param teachersPage
     * @return
     */
    List<TeachersExcel> querAllTeacherFy(TeachersPage teachersPage);

    /***
     * 分页查询总条数
     * @param teachersPage
     * @return
     */
    Integer queryAllTeachCount(TeachersPage teachersPage);

    /**
     * 修改一位老师
     * @param teachersExcel
     * @return
     */
    Integer updateTeacher(TeachersExcel teachersExcel);

    /***
     * 根据id删除一位老师
     * @param id
     * @return
     */
    Integer deleteTeacher(@Param("id") Integer id);

}

package com.zmql.zytj.service;

import com.zmql.zytj.bean.TeachersExcel;
import com.zmql.zytj.bean.TeachersPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeachersService {
    List<TeachersExcel> queryAllTeacher();

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

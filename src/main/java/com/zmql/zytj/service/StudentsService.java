package com.zmql.zytj.service;


import com.zmql.zytj.bean.StudentsExcel;
import com.zmql.zytj.bean.StudentsPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentsService {
    List<StudentsExcel> queryAllStudent();
    /***
     * 学生的多条件查询
     * @return
     */
    List<StudentsExcel> queryStuByName(StudentsPage studentsPage);

    /***
     * 学生的多条件查询总条数
     * @return
     */
    int queryStuCount(StudentsPage studentsPage);
    /***
     * 添加一名学生
     * @param studentsExcel
     * @return
     */
    Integer addStu(StudentsExcel studentsExcel);

    /***
     * 修改学生
     * @param studentsExcel
     * @return
     */
    Integer updateStu(StudentsExcel studentsExcel);
    /***
     * 根据id删除一名学生
     * @param id
     * @return
     */
    Integer deleteStu(@Param("id") Integer id);
}

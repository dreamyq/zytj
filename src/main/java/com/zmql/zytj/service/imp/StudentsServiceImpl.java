package com.zmql.zytj.service.imp;

import com.zmql.zytj.bean.StudentsExcel;
import com.zmql.zytj.bean.StudentsPage;
import com.zmql.zytj.mapper.StudentsMapper;
import com.zmql.zytj.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsMapper studentsMapper;
    /***
     * 查询所有学生
     * @return
     */
    @Override
    public List<StudentsExcel> queryAllStudent() {
        return studentsMapper.queryAllStudent();
    }
    @Override
    public List<StudentsExcel> queryStuByName(StudentsPage studentsPage) {
        return studentsMapper.queryStuByName(studentsPage);
    }

    @Override
    public int queryStuCount(StudentsPage studentsPage) {
        return studentsMapper.queryStuCount(studentsPage);
    }

    @Override
    public Integer addStu(StudentsExcel studentsExcel) {
        return studentsMapper.addStu(studentsExcel);
    }

    @Override
    public Integer updateStu(StudentsExcel studentsExcel) {
        return studentsMapper.updateStu(studentsExcel);
    }

    @Override
    public Integer deleteStu(Integer id) {
        return studentsMapper.deleteStu(id);
    }
}

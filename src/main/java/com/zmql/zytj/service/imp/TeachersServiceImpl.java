package com.zmql.zytj.service.imp;

import com.zmql.zytj.bean.TeachersExcel;
import com.zmql.zytj.bean.TeachersPage;
import com.zmql.zytj.mapper.TeachersMapper;
import com.zmql.zytj.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersServiceImpl implements TeachersService {

    @Autowired
    private TeachersMapper teachersMapper;

    @Override
    public List<TeachersExcel> queryAllTeacher() {
        return teachersMapper.queryAllTeacher();
    }

    @Override
    public Integer addTeacher(TeachersExcel teachersExcel) {
        return teachersMapper.addTeacher(teachersExcel);
    }

    @Override
    public List<TeachersExcel> querAllTeacherFy(TeachersPage teachersPage) {
        return teachersMapper.querAllTeacherFy(teachersPage);
    }

    @Override
    public Integer queryAllTeachCount(TeachersPage teachersPage) {
        return teachersMapper.queryAllTeachCount(teachersPage);
    }

    @Override
    public Integer updateTeacher(TeachersExcel teachersExcel) {
        return teachersMapper.updateTeacher(teachersExcel);
    }

    @Override
    public Integer deleteTeacher(Integer id) {
        return teachersMapper.deleteTeacher(id);
    }
}

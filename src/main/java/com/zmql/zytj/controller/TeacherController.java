package com.zmql.zytj.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zmql.zytj.bean.TeachersExcel;
import com.zmql.zytj.bean.TeachersPage;
import com.zmql.zytj.service.imp.TeachersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/techer")
public class TeacherController {
    @Autowired
    private TeachersServiceImpl teacherService;


    @RequestMapping("/teacherUpload")
    public String teacherUpload(){

        return "teacherUpload";
    }


    /***
     * 带条件的分页查询老师
     * @param teachersPage
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryTeacherFy")
    public Object queryTeacherFy(TeachersPage teachersPage) {

        List<TeachersExcel> list = teacherService.querAllTeacherFy(teachersPage);
        Integer total = teacherService.queryAllTeachCount(teachersPage);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", list);
        map.put("total", total);
        return map;
    }

    /***
     * 添加教师
     * @param teachersExcel
     * @return
     */
    @RequestMapping("/addTeacher")
    public Object addTeacher(TeachersExcel teachersExcel) {
        int a = teacherService.addTeacher(teachersExcel);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("addInfo", a);
        return map;
    }

    /***
     * 修改教师
     * @param teachersExcel
     * @return
     */
    @RequestMapping("/updateTeacher")
    public Object updateTeacher(TeachersExcel teachersExcel) {
        int a = teacherService.updateTeacher(teachersExcel);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("res", a);
        return map;
    }

    /***
     * 删除教师
     * @param id
     * @return
     */
    @RequestMapping("/deleteTeacher")
    public Object deleteTeacher(Integer id) {
        int a = teacherService.deleteTeacher(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("res", a);
        return map;
    }
}

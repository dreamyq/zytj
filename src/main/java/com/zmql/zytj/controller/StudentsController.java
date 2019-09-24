package com.zmql.zytj.controller;


import com.zmql.zytj.bean.StudentsExcel;
import com.zmql.zytj.bean.StudentsPage;
import com.zmql.zytj.service.StudentsService;
import com.zmql.zytj.service.imp.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stu")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @RequestMapping("/studentUpload")
    public String studentUpload(){

        return "studentUpload";
    };


    /***
     * 查询所有学生
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryAllstudent")
    public  Object queryAllstudent(){
        return studentsService.queryAllStudent();
    }
    /***
     * 学生的多条件分页查询
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryStuFy")
    public  Object queryAllStuFy(StudentsPage studentsPage){

        List<StudentsExcel> list=studentsService.queryStuByName(studentsPage);
        int total=studentsService.queryStuCount(studentsPage);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("rows",list);
        map.put("total",total);
        return  map;
    }

    /***
     * 添加学生
     * @param studentsExcel
     * @return
     */
    @RequestMapping("/addStudent")
    public  Object addStudent(StudentsExcel studentsExcel){
        int a=studentsService.addStu(studentsExcel);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("addInfo", a);
        return map;
    }

    /***
     * 修改学生
     * @param studentsExcel
     * @return
     */
    @RequestMapping("/updateStudent")
    public Object updateStudent(StudentsExcel studentsExcel){
        int a=studentsService.updateStu(studentsExcel);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("addInfo", a);
        return map;
    }

    /***
     * 删除学生
     * @param id
     * @return
     */
    @RequestMapping("/deleteStudent")
    public  Object deleteStudent(Integer id){
        int a=studentsService.deleteStu(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("addInfo", a);
        return map;
    }


}

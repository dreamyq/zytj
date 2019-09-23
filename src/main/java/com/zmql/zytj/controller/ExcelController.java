package com.zmql.zytj.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.zmql.zytj.bean.*;
import com.zmql.zytj.service.TeachersService;
import com.zmql.zytj.service.imp.ConsumeLogsServiceImpl;
import com.zmql.zytj.service.imp.StudentsServiceImpl;
import com.zmql.zytj.service.imp.TeachersServiceImpl;
import com.zmql.zytj.util.PoiUtils;
import com.zmql.zytj.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    private StudentsServiceImpl studentsService;
    @Autowired
    private TeachersService teacherService;
    @Autowired
    private ConsumeLogsServiceImpl consumeLogsService;

    /**
     * 导入学生
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadStu", name = "导入学生")
    public Object uploadStu(@RequestParam(value = "file") MultipartFile file) {
        System.out.println("6666666666");

        String name = file.getName();//form表单中参数名称
        String originalFilename = file.getOriginalFilename();//得到上传文件的名称
        System.out.println("表单中文件参数名称 name=>" + name);
        System.out.println("上传的文件原始名称 originalfileName=>" + originalFilename);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PoiUtils poiUtils = new PoiUtils();//Excel工具类
        
        
        List<StudentsExcel> list = null;
        int n = 1;
        try {
            list = (List<StudentsExcel>) poiUtils.parseExcel(StudentsExcel.class, file.getInputStream(), originalFilename);
            System.out.println("导入的数据长度：" + list.size());
            for (StudentsExcel studentsExcel : list) {

                System.out.println("6666" + studentsExcel);
                n += studentsService.addStu(studentsExcel);
                System.out.println("aaaaa" + n);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        if (n > 0) {
            return new Result(true, "上传成功", "0");
        } else {
            return new Result(false, "上传失败", "1");
        }
    }

    /***
     * 下载导入学生模板
     * @param response
     * @return
     */
    @RequestMapping(value = "/stuModul", name = "下载导入学生模板")
    public Object downloadMould(HttpServletResponse response) {
        String downloadName = "下载的学生模板.xls";
        try {
            PoiUtils poiUtils = new PoiUtils();//Excel工具类
            response.setCharacterEncoding("UTF-8");//设置响应的字符编码格式
            response.setContentType("application/vnd.ms-excel");//指明响应文件为excel类型
            response.setHeader("Content-disposition", "attachment;filename=" + new String(downloadName.getBytes("GB2312"), "ISO8859-1"));//文件名编码处理，防止浏览器下载文件名乱码
            ServletOutputStream outputStream = response.getOutputStream();//获取响应的字节输出流
            List<StudentsExcel> stu = new ArrayList<StudentsExcel>();
            System.out.println(stu);
            poiUtils.createExcel(stu,StudentsExcel.class, outputStream);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 导出的所有学生
     * @param response
     * @return
     */
    @RequestMapping(value = "/studownload", produces = "text/html;charset=UTF-8", name = "导出的所有学生")
    public String download(HttpServletResponse response) {
        String downloadName = "导出的所有学生.xls";

        List<StudentsExcel> list = studentsService.queryAllStudent();//要导出的数据集合
        try {

            PoiUtils poiUtils = new PoiUtils();//Excel工具类
            response.setCharacterEncoding("UTF-8");//设置响应的字符编码格式
            response.setContentType("application/vnd.ms-excel");//指明响应文件为excel类型
            response.setHeader("Content-disposition", "attachment;filename=" + new String(downloadName.getBytes("GB2312"), "ISO8859-1"));//文件名编码处理，防止浏览器下载文件名乱码
            ServletOutputStream outputStream = response.getOutputStream();//获取响应的字节输出流
            poiUtils.createExcel(list, StudentsExcel.class, outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 下载导入教师模板
     * @param response
     * @return
     */
    @RequestMapping(value = "/teaModul", name = "下载导入教师模板")
    public Object downloadTeacherMould(HttpServletResponse response) {
        String downloadName = "下载的教师模板.xls";
        try {
            PoiUtils poiUtils = new PoiUtils();//Excel工具类
            response.setCharacterEncoding("UTF-8");//设置响应的字符编码格式
            response.setContentType("application/vnd.ms-excel");//指明响应文件为excel类型
            response.setHeader("Content-disposition", "attachment;filename=" + new String(downloadName.getBytes("GB2312"), "ISO8859-1"));//文件名编码处理，防止浏览器下载文件名乱码
            ServletOutputStream outputStream = response.getOutputStream();//获取响应的字节输出流
            List<TeachersExcel> tea = new ArrayList<TeachersExcel>();
            poiUtils.createExcel(tea, TeachersExcel.class, outputStream);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 导出教师
     * @param response
     * @return
     */
    @RequestMapping(value = "/teadownload", produces = "text/html;charset=UTF-8", name = "导出教师")
    public String downloadtea(HttpServletResponse response) {
        String downloadName = "导出的所有教师.xls";

        List<TeachersExcel> list = teacherService.queryAllTeacher();//要导出的数据集合
        try {

            PoiUtils poiUtils = new PoiUtils();//Excel工具类
            response.setCharacterEncoding("UTF-8");//设置响应的字符编码格式
            response.setContentType("application/vnd.ms-excel");//指明响应文件为excel类型
            response.setHeader("Content-disposition", "attachment;filename=" + new String(downloadName.getBytes("GB2312"), "ISO8859-1"));//文件名编码处理，防止浏览器下载文件名乱码
            ServletOutputStream outputStream = response.getOutputStream();//获取响应的字节输出流
            poiUtils.createExcel(list, TeachersExcel.class, outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 导入教师
     * @param file
     * @return
     */

    @RequestMapping(value = "/uploadTea", name = "导入教师")
    public Object uploadTea(@RequestParam(value = "file") MultipartFile file) {
        String name = file.getName();//form表单中参数名称
        String originalFilename = file.getOriginalFilename();//得到上传文件的名称
        System.out.println("表单中文件参数名称 name=>" + name);
        System.out.println("上传的文件原始名称 originalfileName=>" + originalFilename);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PoiUtils poiUtils = new PoiUtils();//Excel工具类
        List<TeachersExcel> list = null;
        int n = 1;
        try {
            list = (List<TeachersExcel>) poiUtils.parseExcel(TeachersExcel.class, file.getInputStream(), originalFilename);
            System.out.println("导入的数据长度：" + list.size());
            for (TeachersExcel teacherssEntity : list) {

                System.out.println("6666" + teacherssEntity);
                n += teacherService.addTeacher(teacherssEntity);
                System.out.println("aaaaa" + n);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        if (n > 0) {
            return new Result(true, "上传成功", "0");
        } else {
            return new Result(false, "上传失败", "1");
        }
    }

    /***
     * 导出所有刷卡记录
     * @param response
     * @returnl
     */
    @RequestMapping(value = "/conlogdownload", produces = "text/html;charset=UTF-8", name = "导出所有刷卡记录")
    public String downloadConlog(HttpServletResponse response) {
        String downloadName = "导出的所有刷卡记录.xls";

        List<ConsumeLogsExcel> list = consumeLogsService.getAllConsumeLogs();//要导出的数据集合
        try {

            PoiUtils poiUtils = new PoiUtils();//Excel工具类
            response.setCharacterEncoding("UTF-8");//设置响应的字符编码格式
            response.setContentType("application/vnd.ms-excel");//指明响应文件为excel类型
            response.setHeader("Content-disposition", "attachment;filename=" + new String(downloadName.getBytes("GB2312"), "ISO8859-1"));//文件名编码处理，防止浏览器下载文件名乱码
            ServletOutputStream outputStream = response.getOutputStream();//获取响应的字节输出流
            poiUtils.createExcel(list, ConsumeLogsExcel.class, outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

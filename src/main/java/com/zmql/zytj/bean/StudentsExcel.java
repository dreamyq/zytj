package com.zmql.zytj.bean;


import com.zmql.zytj.util.PoiHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsExcel {
    @PoiHandler(excelHeader = "ID",excelIgnore = true)
    private int id;
    @PoiHandler(excelHeader = "卡号")
    private String cardNo;
    @PoiHandler(excelHeader = "姓名")
    private String name;
    @PoiHandler(excelHeader = "专业ID")
    private String membershipId;
    @PoiHandler(excelHeader = "性别")
    private String sex;
    @PoiHandler(excelHeader = "状态",excelIgnore = true)
    private String status;
    @PoiHandler(excelHeader = "备注",excelIgnore = true)
    private String remark;
    @PoiHandler(excelHeader = "学号")
    private Integer stuNo;
}

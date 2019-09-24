package com.zmql.zytj.bean;

import com.zmql.zytj.util.PoiHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachersExcel {
    @PoiHandler(excelHeader = "ID",excelIgnore = true)
    private int id;
    @PoiHandler(excelHeader = "卡号")
    private String cardNo;
    @PoiHandler(excelHeader = "姓名")
    private String name;
    @PoiHandler(excelHeader = "性别")
    private String sex;
    @PoiHandler(excelHeader = "科室ID")
    private Integer sectionId;
    @PoiHandler(excelHeader = "状态",excelIgnore = true)
    private String status;
    @PoiHandler(excelHeader = "备注",excelIgnore = true)
    private String ramark;
}

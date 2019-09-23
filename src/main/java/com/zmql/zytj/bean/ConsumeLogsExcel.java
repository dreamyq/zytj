package com.zmql.zytj.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zmql.zytj.util.PoiHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumeLogsExcel {
    @PoiHandler(excelHeader = "ID",excelIgnore = true)
    private int id;
    @PoiHandler(excelHeader = "卡号")
    private String cardNo;
    @PoiHandler(excelHeader = "阅览室ID")
    private Integer readRoomId;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @PoiHandler(excelHeader = "进入时间")
    private Date inTime;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @PoiHandler(excelHeader = "离开时间")
    private Date outTime;
    @PoiHandler(excelHeader = "状态")
    private Integer status;
}

package com.zmql.zytj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teachers {
    private int id;
    private int cardNo;
    private String name;
    private String sex;
    private String sectionID;
    private String status;
    private String remark;


}

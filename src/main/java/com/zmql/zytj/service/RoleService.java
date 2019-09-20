package com.zmql.zytj.service;

public interface RoleService {
    /**
     * 判断输入的卡号是否存在，如果不存在则不允许进入
     */
    int judgeCardNO(int cardNO,String database);
}

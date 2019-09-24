package com.zmql.zytj.service;

import com.zmql.zytj.bean.ConsumeLogs;
import com.zmql.zytj.bean.ConsumeLogsExcel;


import java.util.List;

public interface ConsumeLogsService {
    int insertConsumeLogs(ConsumeLogs consumeLogs);
    List<ConsumeLogs> getConsumeLogsLastDataByCardNo(int cardNO);
    /**
     * 修改数据为刷卡离开
     */
    int updateConsumeLogs(ConsumeLogs consumeLogs);

    /**
     * 统计每天的使用数据
     * 这里统计的有资源总条数，因为Status字段没有用到，所以我们使用该字段代理count总条数
     * @return
     */
    List<ConsumeLogs> statisticalResources();

    List<ConsumeLogsExcel> getAllConsumeLogs();

}

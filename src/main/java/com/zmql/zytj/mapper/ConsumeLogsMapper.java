package com.zmql.zytj.mapper;

import com.zmql.zytj.bean.ConsumeLogs;
import java.util.List;

import com.zmql.zytj.bean.ConsumeLogsExcel;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ConsumeLogsMapper {
    /**
     * 插入日志记录
     * @param consumeLogs
     * @return
     */
    int insertConsumeLogs(ConsumeLogs consumeLogs);

    /**
     * 查询InTime为今天的且卡号为该卡号的的最后一条数据
     * @param cardNO
     * @return
     */
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

    /**
     * 查询所有
     * @return
     */
    List<ConsumeLogsExcel> getAllConsumeLogs();
}

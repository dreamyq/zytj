package com.zmql.zytj.quartz;

import com.zmql.zytj.bean.ConsumeLogs;
import com.zmql.zytj.service.ConsumeLogsService;
import com.zmql.zytj.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling //启动定时任务
public class SimpleTask {
    @Autowired
    private ConsumeLogsService consumeLogsService;
    @Autowired
    private StatisticsService statisticsService;

    @Resource
    private SimpleDateFormat dateFormat;

    //每隔1秒（cron表达式，六个*【*/5算一个，？算一个】，从左到右分别为秒分时天月年）
    @Scheduled(cron = "0 0 0 * * ?")
    public void reportCurrentByCron(){
        List<ConsumeLogs> consumeLogs = consumeLogsService.statisticalResources();
        statisticsService.insertStatistics(consumeLogs);
    }
}
package com.zmql.zytj.service;

import com.zmql.zytj.bean.ConsumeLogs;
import com.zmql.zytj.bean.Statistics;

import java.util.List;

public interface StatisticsService {
    int insertStatistics(List<ConsumeLogs> data);
    List<Statistics> getDataByYear();
    List<Statistics> getDataByMonth(String month);
    List<Statistics> getDataByDay(String day);
}

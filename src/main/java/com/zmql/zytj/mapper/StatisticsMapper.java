package com.zmql.zytj.mapper;

import com.zmql.zytj.bean.ConsumeLogs;
import com.zmql.zytj.bean.Statistics;

import java.util.List;

public interface StatisticsMapper {
    int insertStatistics(List<ConsumeLogs> data);
    List<Statistics> getDataByYear();
    List<Statistics> getDataByMonth(String month);
    List<Statistics> getDataByDay(String day);
}

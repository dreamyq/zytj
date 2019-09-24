package com.zmql.zytj.mapper;

import com.zmql.zytj.bean.ConsumeLogs;
import com.zmql.zytj.bean.Statistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatisticsMapper {
    int insertStatistics(List<ConsumeLogs> data);
    List<Statistics> getDataByYear(@Param("minYear") String minYear, @Param("maxYear") String maxYear);
    List<Statistics> getDataByMonth(String year);
    List<Statistics> getDataByDay(@Param("month")String month,@Param("year")String year);
}

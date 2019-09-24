package com.zmql.zytj.service.imp;

import com.zmql.zytj.bean.ConsumeLogs;
import com.zmql.zytj.bean.Statistics;
import com.zmql.zytj.mapper.StatisticsMapper;
import com.zmql.zytj.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsMapper statisticsMapper;
    @Override
    public int insertStatistics(List<ConsumeLogs> data) {
        return statisticsMapper.insertStatistics(data);
    }

    @Override
    public List<Statistics> getDataByYear(String minYear,String maxYear) {
        return statisticsMapper.getDataByYear(minYear, maxYear);
    }

    @Override
    public List<Statistics> getDataByMonth(String month) {
        return statisticsMapper.getDataByMonth(month);
    }

    @Override
    public List<Statistics> getDataByDay(String month, String year) {
        return statisticsMapper.getDataByDay(month,year);
    }


}

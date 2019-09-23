package com.zmql.zytj.controller;

import com.zmql.zytj.bean.Statistics;
import com.zmql.zytj.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("chart")
public class ChartController {
    @Autowired
    private StatisticsService statisticsService;
    @RequestMapping("page")
    private String chart(Map<String, Object> map){
        List<Statistics> dataByYear = statisticsService.getDataByYear();
        map.put("yearData",dataByYear);
        return "chart";
    }

    @RequestMapping("year")
    @ResponseBody
    private Map<String,Object> getByYear(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Statistics> dataByYear = statisticsService.getDataByYear();

        return modelMap;
    }

}

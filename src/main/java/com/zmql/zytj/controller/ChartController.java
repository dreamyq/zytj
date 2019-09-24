package com.zmql.zytj.controller;

import com.zmql.zytj.bean.ReadRooms;
import com.zmql.zytj.bean.Statistics;
import com.zmql.zytj.service.ReadRoomsService;
import com.zmql.zytj.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("chart")
public class ChartController {
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private ReadRoomsService readRoomsService;

    @RequestMapping("page")
    private String chart(Map<String, Object> map, HttpServletRequest request) {
        List<ReadRooms> allReadRooms = readRoomsService.getAllReadRooms();
        String param = "";
        String month=request.getParameter("month");
        param = request.getParameter("param");
        if (param != null && !"".equals(param)) {
            if(month==null){
                List<Statistics> dataByMonth = statisticsService.getDataByMonth(param);
                List<Statistics> monthData = new ArrayList();
                getMonth(allReadRooms, dataByMonth, monthData);
                map.put("yearData", monthData);
                map.put("minYear", null);
                //map.put("d", 1000);
            }else{
                List<Statistics> dataByDay = statisticsService.getDataByDay(month, param);
                List<Statistics> dayData = new ArrayList();
                getDayByMonthAndYear(allReadRooms,dataByDay,dayData);
                map.put("yearData", dayData);
                //map.put("d", null);
            }

        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            int min = Integer.parseInt(sdf.format(new Date())) - 10;
            String minYear = String.valueOf(min);
            String maxYear = sdf.format(new Date());
            int max = Integer.parseInt(maxYear);
            List<Statistics> dataByYear = statisticsService.getDataByYear(minYear, maxYear);
            List<Statistics> yearData = new ArrayList();
            getYear(min, dataByYear, allReadRooms, yearData);
            map.put("minYear", minYear);
            map.put("maxYear", maxYear);
            map.put("yearData", yearData);
            //map.put("d", 1000);
        }
        map.put("rooms", allReadRooms);
        return "chart";
    }

    private void getYear(int min, List<Statistics> dataByYear, List<ReadRooms> allReadRooms, List<Statistics> yearData) {
        for (ReadRooms room : allReadRooms) {//所有的room
            int m = min;
            for (Statistics s : dataByYear) {//查到的素有的每年的数据
                if (s.getReadRoomID() == room.getId()) {//如果数据中的roomid=romm的id
                    if (m < Integer.parseInt(s.getYear())) {
                        int y = (Integer.parseInt(s.getYear()) - m);
                        for (int i = 0; i < y; i++) {
                            m++;
                            Statistics ss = new Statistics();
                            ss.setReadRoomID(s.getReadRoomID());
                            ss.setPeopleNums("0");
                            yearData.add(ss);
                        }
                    }
                    if (m == Integer.parseInt(s.getYear())) {
                        m++;
                        yearData.add(s);
                        continue;
                    }
                    if (m > Integer.parseInt(s.getYear())) {
                        int y = (m - Integer.parseInt(s.getYear()));
                        for (int i = 0; i < y; i++) {
                            m++;
                            Statistics ss = new Statistics();
                            ss.setReadRoomID(s.getReadRoomID());
                            ss.setPeopleNums("0");
                            yearData.add(ss);
                        }
                    }

                }
            }
        }
    }

    private void getMonth(List<ReadRooms> allReadRooms, List<Statistics> dataByMonth, List<Statistics> monthData) {
        for (ReadRooms room : allReadRooms) {//所有的room
            int m = 1;
            for (Statistics s : dataByMonth) {//查到的素有的每年的数据
                if (s.getReadRoomID() == room.getId()) {//如果数据中的roomid=romm的id
                    if (m < Integer.parseInt(s.getMonth())) {
                        int y = (Integer.parseInt(s.getMonth()) - m);
                        for (int i = 0; i < y; i++) {
                            m++;
                            Statistics ss = new Statistics();
                            ss.setReadRoomID(s.getReadRoomID());
                            ss.setPeopleNums("0");
                            monthData.add(ss);
                        }
                    }
                    if (m == Integer.parseInt(s.getMonth())) {
                        m++;
                        monthData.add(s);
                        continue;
                    }
                    if (m > Integer.parseInt(s.getMonth())) {
                        int y = (m - Integer.parseInt(s.getMonth()));
                        for (int i = 0; i < y; i++) {
                            m++;
                            Statistics ss = new Statistics();
                            ss.setReadRoomID(s.getReadRoomID());
                            ss.setPeopleNums("0");
                            monthData.add(ss);
                        }
                    }

                }
            }
        }
    }
    //
    private void getDayByMonthAndYear(List<ReadRooms> allReadRooms, List<Statistics> dataByDay, List<Statistics> dayData){
        for (ReadRooms room : allReadRooms) {//所有的room
            int m = 1;
            for (Statistics s : dataByDay) {//查到的素有的每年的数据
                if (s.getReadRoomID() == room.getId()) {//如果数据中的roomid=romm的id
                    if (m < Integer.parseInt(s.getDay())) {
                        int y = (Integer.parseInt(s.getDay()) - m);
                        for (int i = 0; i < y; i++) {
                            m++;
                            Statistics ss = new Statistics();
                            ss.setReadRoomID(s.getReadRoomID());
                            ss.setPeopleNums("0");
                            dayData.add(ss);
                        }
                    }
                    if (m == Integer.parseInt(s.getDay())) {
                        m++;
                        dayData.add(s);
                        continue;
                    }
                    if (m > Integer.parseInt(s.getDay())) {
                        int y = (m - Integer.parseInt(s.getDay()));
                        for (int i = 0; i < y; i++) {
                            m++;
                            Statistics ss = new Statistics();
                            ss.setReadRoomID(s.getReadRoomID());
                            ss.setPeopleNums("0");
                            dayData.add(ss);
                        }
                    }

                }
            }
        }
    }
}

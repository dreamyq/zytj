package com.zmql.zytj.controller;

import com.zmql.zytj.bean.Computers;
import com.zmql.zytj.bean.ConsumeLogs;
import com.zmql.zytj.service.ComputersService;
import com.zmql.zytj.service.ConsumeLogsService;
import com.zmql.zytj.service.RoleService;
import com.zmql.zytj.util.GetComputer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Transactional
public class EnterController {
    @Autowired
    private ComputersService computersService;
    @Autowired
    private ConsumeLogsService consumeLogsService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("enter")
    private String enter(Map<String, Object> map){
        String ip = GetComputer.config();
        Computers computer = computersService.getComputerByIp(ip);
        map.put("computer",computer);
        return "enter";
    }

    @RequestMapping("addEnterData")
    @ResponseBody
    private Map<String,Object> addEnterData(@RequestParam("cardNO") String cardNO , @RequestParam("readroomid") String readroomid,@RequestParam("role") String role){
        Map<String,Object> modelMap = new HashMap<>();
        int cn = Integer.parseInt(cardNO);
        int rrd=Integer.parseInt(readroomid);
        int judgeCardNO = roleService.judgeCardNO(cn, role);
        if(judgeCardNO>0){
            ConsumeLogs consumeLogs = new ConsumeLogs();
            consumeLogs.setCardNo(cn);
            consumeLogs.setReadRoomID(rrd);
            ConsumeLogs consumeLogsLastDataByCardNo = consumeLogsService.getConsumeLogsLastDataByCardNo(cn);
            int effNum;
            if(consumeLogsLastDataByCardNo!=null && consumeLogsLastDataByCardNo.getOutTime()==null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long time = 0;
                try {
                    long stateTimeLong = consumeLogsLastDataByCardNo.getInTime().getTime();
                    long endTimeLong = new Date().getTime();
                    // 结束时间-开始时间 = 天数
                    time = (endTimeLong-stateTimeLong)/1000;//(endTimeLong-stateTimeLong)/(24*60*60*1000);
                    System.out.println(time);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if(time>60){
                    consumeLogs.setOutTime(new Date());
                    consumeLogs.setId(consumeLogsLastDataByCardNo.getId());
                    effNum=consumeLogsService.updateConsumeLogs(consumeLogs);
                    if(effNum>0){
                        computersService.updateRoleStatus(cn, role, 0);
                        modelMap.put("msg","刷卡离开成功");
                        modelMap.put("success",true);
                    }else {
                        modelMap.put("msg","刷卡失败请重试");
                        modelMap.put("success",false);
                    }
                }else {
                    modelMap.put("msg","连续刷卡，刷卡失败请"+(60-time)+"秒重试");
                    modelMap.put("success",false);
                }
            }else{
                consumeLogs.setInTime(new Date());
                effNum=consumeLogsService.insertConsumeLogs(consumeLogs);
                if(effNum>0){
                    computersService.updateRoleStatus(cn, role, rrd);
                    //System.out.println(updateRoleStatusInfo.toString());
                    modelMap.put("msg","刷卡进入成功");
                    modelMap.put("success",true);
                }else {
                    modelMap.put("msg","刷卡失败请重试");
                    modelMap.put("success",false);
                }
            }
        }else {
            modelMap.put("msg","您的卡号不存在");
            modelMap.put("success",false);
        }

        return modelMap;
    }


}

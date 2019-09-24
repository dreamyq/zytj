package com.zmql.zytj.controller;

import com.zmql.zytj.bean.Computers;
import com.zmql.zytj.bean.ConsumeLogs;
import com.zmql.zytj.service.ComputersService;
import com.zmql.zytj.service.ConsumeLogsService;
import com.zmql.zytj.service.ReadRoomsService;
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
    @Autowired
    private ReadRoomsService readRoomsService;

    @RequestMapping("enter")
    private String enter(Map<String, Object> map){
        String ip = GetComputer.config();
        Computers computer = computersService.getComputerByIp(ip);
        map.put("computer",computer);
        return "enter";
    }

    @RequestMapping("addEnterData")
    @ResponseBody
    private Map<String,Object> addEnterData(@RequestParam("cardNO") String cardNO , @RequestParam("readroomid") String readroomid ){
        Map<String,Object> modelMap = new HashMap<>();
        String role="";
        int cn = Integer.parseInt(cardNO);
        int rrd=Integer.parseInt(readroomid);
        String t ="teachers";
        String s = "students";
        int judgeCardNO = 0;
        int i = roleService.judgeCardNO(cn, t);
        int i2= roleService.judgeCardNO(cn, s);
        if(i>0){
            judgeCardNO=i;
            role="teachers";
        }
        if(i2>0){
            judgeCardNO=i2;
            role="students";
        }
        if(judgeCardNO>0){
            ConsumeLogs consumeLogs = new ConsumeLogs();
            consumeLogs.setCardNo(cn);
            consumeLogs.setReadRoomID(rrd);
            List<ConsumeLogs> clssc = consumeLogsService.getConsumeLogsLastDataByCardNo(cn);
            int effNum;
            ConsumeLogs consumeLogsLastDataByCardNo=clssc.get(0);
            //判断当前是否是未刷卡离开状态
            if(consumeLogsLastDataByCardNo!=null && consumeLogsLastDataByCardNo.getOutTime()==null){
                //判断该员工上次未刷卡的资源室是不是此资源室，如果不是，则判定让其去之前的资源室去刷卡离开
                String status = roleService.getCardStatus(role,cn);
                int ss=Integer.parseInt(status);
                if(rrd==consumeLogsLastDataByCardNo.getReadRoomID()){
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
                }else {
                    modelMap.put("msg","刷卡失败请去"+readRoomsService.getRoomByid(consumeLogsLastDataByCardNo.getReadRoomID()).getName()+"刷卡离开后再来");
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

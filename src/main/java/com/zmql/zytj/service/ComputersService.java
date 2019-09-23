package com.zmql.zytj.service;

import com.zmql.zytj.bean.Computers;

import java.util.HashMap;

public interface ComputersService {
    Computers getComputerByIp(String ip);
    public HashMap updateRoleStatus(int cardNO, String role, int readRoomId);
}

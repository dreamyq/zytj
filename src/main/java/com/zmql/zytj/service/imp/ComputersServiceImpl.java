package com.zmql.zytj.service.imp;

import com.zmql.zytj.bean.Computers;
import com.zmql.zytj.mapper.ComputersMapper;
import com.zmql.zytj.service.ComputersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class ComputersServiceImpl implements ComputersService {
    @Autowired
    private ComputersMapper computersMapper;
    @Override
    public Computers getComputerByIp(String ip) {
        return computersMapper.getComputerByIp(ip);
    }

    @Override
    public HashMap updateRoleStatus(int cardNO, String role, int readRoomId) {
        return computersMapper.updateRoleStatus(cardNO,role,readRoomId);
    }
}

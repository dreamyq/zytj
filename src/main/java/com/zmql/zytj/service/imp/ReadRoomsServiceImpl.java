package com.zmql.zytj.service.imp;

import com.zmql.zytj.bean.ReadRooms;
import com.zmql.zytj.mapper.ReadRoomsMapper;
import com.zmql.zytj.service.ReadRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReadRoomsServiceImpl implements ReadRoomsService {
    @Autowired
    private ReadRoomsMapper readRoomsMapper;
    @Override
    public List<ReadRooms> getAllReadRooms() {
        return readRoomsMapper.getAllReadRooms();
    }

    @Override
    public ReadRooms getRoomByid(int id) {
        return readRoomsMapper.getRoomByid(id);
    }
}

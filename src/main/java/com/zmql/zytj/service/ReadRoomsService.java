package com.zmql.zytj.service;

import com.zmql.zytj.bean.ReadRooms;

import java.util.List;

public interface ReadRoomsService {
    List<ReadRooms> getAllReadRooms();
    ReadRooms getRoomByid(int id);
}

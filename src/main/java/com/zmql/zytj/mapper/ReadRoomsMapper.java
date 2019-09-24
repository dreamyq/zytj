package com.zmql.zytj.mapper;

import com.zmql.zytj.bean.ReadRooms;

import java.util.List;

public interface ReadRoomsMapper {
      List<ReadRooms> getAllReadRooms();
      ReadRooms getRoomByid(int id);
}

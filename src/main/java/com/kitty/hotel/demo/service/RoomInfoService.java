package com.kitty.hotel.demo.service;

import com.kitty.hotel.demo.entity.RoomInfo;

import java.util.List;

public interface RoomInfoService {
    void addRoom(RoomInfo roomInfo);

    void updateRoom(RoomInfo roomInfo);

    RoomInfo queryRoomByRoomId(Integer roomId);

    List<RoomInfo> queryAllRoom(RoomInfo roomInfo);

    void deleteRoom(Integer roomId);
}

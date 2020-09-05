package com.kitty.hotel.demo.service.impl;

import com.kitty.hotel.demo.entity.RoomInfo;
import com.kitty.hotel.demo.mapper.RoomInfoMapper;
import com.kitty.hotel.demo.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("RoomInfoService")
public class RoomInfoServiceImpl implements RoomInfoService {

    @Autowired
    private RoomInfoMapper roomInfoMapper;

    @Override
    public void addRoom(RoomInfo roomInfo) {
        System.out.println("方法");
        roomInfo.setStatus(1);
        this.roomInfoMapper.insertRoom(roomInfo);
    }

    @Override
    public void updateRoom(RoomInfo roomInfo) {
        this.roomInfoMapper.updateRoom(roomInfo);
    }

    @Override
    public RoomInfo queryRoomByRoomId(Integer roomId) {
        return this.roomInfoMapper.queryRoomByRoomId(roomId);
    }

    @Override
    public List<RoomInfo> queryAllRoom(RoomInfo roomInfo) {
        return  this.roomInfoMapper.selectAllRooms(roomInfo);
    }

    @Override
    public void deleteRoom(Integer roomId) {
        this.roomInfoMapper.deleteRoom(roomId);
    }
}

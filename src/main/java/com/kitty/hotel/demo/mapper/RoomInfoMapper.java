package com.kitty.hotel.demo.mapper;

import com.kitty.hotel.demo.entity.RoomInfo;
import com.kitty.hotel.demo.provider.RoomSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomInfoMapper {

    @Insert("INSERT INTO RoomInfo(roomId,status) VALUES (#{roomId},#{status})")
    void insertRoom(RoomInfo roomInfo);

    @Select("SELECT roomId,roomDate, status FROM RoomInfo WHERE roomId = #{roomId} ")
    @Results(id = "roomInfo", value = {
            @Result(id = true, column = "roomId", property = "roomId"),
            @Result(column = "roomDate", property = "roomDate"),
            @Result(column = "status", property = "status")
    }
    )
    RoomInfo queryRoomByRoomId(Integer roomId);

    @SelectProvider(type = RoomSQLProvider.class,  method = "createSelectAllSQL")
    List<RoomInfo> selectAllRooms(RoomInfo roomInfo);

    //    type属性指向提供者类的字节码对象，method属性确定类中具体的方法

    @UpdateProvider(type = RoomSQLProvider.class, method = "createUpdateSQL")
    void updateRoom(RoomInfo roomInfo);

    @Delete("DELETE FROM RoomInfo WHERE roomId = #{roomId} ")
    void deleteRoom(Integer roomId);



}

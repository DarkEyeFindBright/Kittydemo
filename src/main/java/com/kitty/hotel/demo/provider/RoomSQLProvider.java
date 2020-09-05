package com.kitty.hotel.demo.provider;

import com.kitty.hotel.demo.entity.RoomInfo;
import com.kitty.hotel.demo.entity.StaffInfo;
import org.apache.ibatis.jdbc.SQL;

public class RoomSQLProvider {

    public String createUpdateSQL(RoomInfo roomInfo){
//        return new SQL()
//                .UPDATE("dept")
//                .SET("deptname = #{deptName}")
//                .SET("status = #{status}")
//                .WHERE("deptid = #{deptId}")
//                .toString();
        return new SQL(){{
            UPDATE("RoomInfo");
            if (null != roomInfo.getRoomDate()) {
                SET("roomDate = #{roomDate}");
            }
            if(null != roomInfo.getStatus()){
                SET("status=#{status}");
            }
            WHERE("roomId = #{roomId}");
        }}
                .toString();
    }

    public String createSelectAllSQL(RoomInfo roomInfo){
        return new SQL(){{
            SELECT("roomId, roomDate, status");
            FROM("RoomInfo");
            if(null!=roomInfo.getRoomId()){
                WHERE("roomId=#{roomId}");
            }
            if (null != roomInfo.getRoomDate()) {
                WHERE("roomDate = #{roomDate}");
            }
            if(null != roomInfo.getStatus()){
                WHERE("status=#{status}");
            }
        }}
                .toString();
    }

}

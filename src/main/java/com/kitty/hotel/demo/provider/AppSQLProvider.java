package com.kitty.hotel.demo.provider;

import com.kitty.hotel.demo.entity.AppInfo;
import org.apache.ibatis.jdbc.SQL;

public class AppSQLProvider {
    public String createUpdateSQL(AppInfo appInfo){

        return new SQL(){{
            UPDATE("AppInfo");
            if (null != appInfo.getGuestId()){
                SET("guestId = #{guestId}");
            }
            if(null!=appInfo.getGuestName() && !"".equals(appInfo.getGuestName())){
                SET("guestName=#{guestId}");
            }
            if (null != appInfo.getAppDate()) {
                SET("appDate = #{appDate}");
            }
            if(null != appInfo.getRoomId()){
                SET("roomId=#{roomId}");
            }
            WHERE("appId = #{appId}");
        }}
                .toString();
    }

    public String createSelectAllSQL(AppInfo appInfo){

        return new SQL(){{
            SELECT("appId, guestId, guestName,roomId, appDate");
            FROM("appInfo");
            if(null!=appInfo.getAppId()){
                WHERE("appId=#{appId}");
            }
            if (null != appInfo.getGuestName() && !"".equals(appInfo.getGuestName())){
                WHERE("guestName = #{guestName}");
            }
            if(null!=appInfo.getGuestId()){
                WHERE("guestId=#{guestId}");
            }
            if (null != appInfo.getRoomId()) {
                WHERE("roomId = #{roomId}");
            }
            if(null != appInfo.getAppDate()){
                WHERE("appDate=#{appDate}");
            }
        }}
                .toString();
    }

}

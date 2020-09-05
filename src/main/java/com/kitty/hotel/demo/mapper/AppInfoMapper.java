package com.kitty.hotel.demo.mapper;

import com.kitty.hotel.demo.entity.AppInfo;
import com.kitty.hotel.demo.provider.AppSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppInfoMapper {
    @Insert("INSERT INTO appInfo(appId,guestId,guestName,roomId,appDate) VALUES (#{appId},#{guestId},#{guestName},#{roomId},#{appDate})")
    void insertApp(AppInfo appInfo);

    @Select("SELECT appId,guestId,guestName,roomId,appDate FROM appInfo WHERE appId = #{appId} ")
    AppInfo selectAppByAppId(Integer appId);

    // @Select(" SELECT staffId, staffName, birthday, phone FROM StaffInfo ")
    @SelectProvider(type = AppSQLProvider.class,  method = "createSelectAllSQL")
    List<AppInfo> selectAllApps(AppInfo appInfo);

    //    type属性指向提供者类的字节码对象，method属性确定类中具体的方法
    // @Update("UPDATE StaffInfo SET staffName = #{staffName}, birthday = #{birthday},phone=#{phone} WHERE staffId = #{staffId} ")
    @UpdateProvider(type = AppSQLProvider.class, method = "createUpdateSQL")
    void updateApp(AppInfo appInfo);

    @Delete("DELETE FROM appInfo WHERE appId = #{appId} ")
    void deleteAppByAppId(Integer appId);
}

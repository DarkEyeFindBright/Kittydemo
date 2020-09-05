package com.kitty.hotel.demo.mapper;

import com.kitty.hotel.demo.entity.StaffInfo;
import com.kitty.hotel.demo.provider.StaffSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaffInfoMapper {
    @Insert("INSERT INTO StaffInfo(staffName,birthday,phone) VALUES (#{staffName},#{birthday},#{phone})")
    void insertStaff(StaffInfo staffInfo);

    @Select("SELECT staffId, staffName, birthday, phone FROM StaffInfo WHERE staffId = #{staffId} ")
    @Results(id = "staffInfo", value = {
            @Result(id = true, column = "staffId", property = "staffId"),
            @Result(column = "deptName", property = "deptName"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "phone", property = "phone")
            }
    )

    StaffInfo selectStaffByStaffId(Integer staffId);

   // @Select(" SELECT staffId, staffName, birthday, phone FROM StaffInfo ")
    @SelectProvider(type = StaffSQLProvider.class,  method = "createSelectAllSQL")
    List<StaffInfo> selectAllStaffs(StaffInfo staffInfo);

    //    type属性指向提供者类的字节码对象，method属性确定类中具体的方法
   // @Update("UPDATE StaffInfo SET staffName = #{staffName}, birthday = #{birthday},phone=#{phone} WHERE staffId = #{staffId} ")
     @UpdateProvider(type = StaffSQLProvider.class, method = "createUpdateSQL")
     void updateStaff(StaffInfo staffInfo);

     @Delete("DELETE FROM StaffInfo WHERE staffId = #{staffId} ")
     void deleteStaffByDeptId(Integer staffId);


}

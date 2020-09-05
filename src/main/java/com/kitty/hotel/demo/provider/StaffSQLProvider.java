package com.kitty.hotel.demo.provider;

import com.kitty.hotel.demo.entity.StaffInfo;
import org.apache.ibatis.jdbc.SQL;

public class StaffSQLProvider {


        public String createUpdateSQL(StaffInfo staffInfo){
//        return new SQL()
//                .UPDATE("dept")
//                .SET("deptname = #{deptName}")
//                .SET("status = #{status}")
//                .WHERE("deptid = #{deptId}")
//                .toString();
            return new SQL(){{
                UPDATE("StaffInfo");
                if (null != staffInfo.getStaffName() && !"".equals(staffInfo.getStaffName())){
                    SET("staffName = #{staffName}");
                }
                if (null != staffInfo.getBirthday()) {
                    SET("birthday = #{birthday}");
                }
                if(null != staffInfo.getPhone()){
                    SET("phone=#{phone}");
                }
                WHERE("staffId = #{staffId}");
            }}
                    .toString();
        }

    public String createSelectAllSQL(StaffInfo staffInfo){
        return new SQL(){{
            SELECT("staffId, staffName, birthday, phone");
            FROM("StaffInfo");
            if(null!=staffInfo.getStaffId()){
                WHERE("staffId=#{staffId}");
            }
            if (null != staffInfo.getStaffName() && !"".equals(staffInfo.getStaffName())){
                WHERE("staffName = #{staffName}");
            }
            if (null != staffInfo.getBirthday()) {
                WHERE("birthday = #{birthday}");
            }
            if(null != staffInfo.getPhone()){
                WHERE("phone=#{phone}");
            }
        }}
                .toString();
    }


}

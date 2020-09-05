package com.kitty.hotel.demo.mapper;

import com.kitty.hotel.demo.entity.AppInfo;
import com.kitty.hotel.demo.entity.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LoginMapper {
    @Insert(" INSERT INTO login(manageId,manageName,managePass) VALUES (#{manageId},#{manageName},#{managePass}")
    void insertManage(Login login);

    @Select("SELECT manageId,manageName,managePass FROM login WHERE manageId = #{manageId} ")
    Login selectManageByLoginId(Integer LoginId);


}

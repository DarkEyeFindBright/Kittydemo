package com.kitty.hotel.demo.service;

import com.kitty.hotel.demo.entity.StaffInfo;

import java.util.List;


public interface StaffInfoService {
    void addStaff(StaffInfo staffInfo);

    void updateStaff(StaffInfo staffInfo);

    StaffInfo queryStaffByStaffId(Integer staffId);

    List<StaffInfo> queryAllStaff(StaffInfo staffInfo);

    void deleteStaff(Integer staffId);
}

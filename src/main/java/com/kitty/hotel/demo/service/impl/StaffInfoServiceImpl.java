package com.kitty.hotel.demo.service.impl;

import com.kitty.hotel.demo.entity.StaffInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kitty.hotel.demo.service.StaffInfoService;
import com.kitty.hotel.demo.mapper.StaffInfoMapper;
import java.util.List;

@Service("StaffInfoService")
public class StaffInfoServiceImpl implements StaffInfoService {

    @Autowired
    private StaffInfoMapper staffInfoMapper;
    @Override
    public void addStaff(StaffInfo staffInfo) {
        System.out.println("方法");
        this.staffInfoMapper.insertStaff(staffInfo);
    }

    @Override
    public void updateStaff(StaffInfo staffInfo) {
        this.staffInfoMapper.updateStaff(staffInfo);
    }

    @Override
    public StaffInfo queryStaffByStaffId(Integer staffId) {
        return this.staffInfoMapper.selectStaffByStaffId(staffId);
    }

    @Override
    public List<StaffInfo> queryAllStaff(StaffInfo staffInfo) {
        return this.staffInfoMapper.selectAllStaffs(staffInfo);
    }

    @Override
    public void deleteStaff(Integer staffId) {
        this.staffInfoMapper.deleteStaffByDeptId(staffId);
    }
}

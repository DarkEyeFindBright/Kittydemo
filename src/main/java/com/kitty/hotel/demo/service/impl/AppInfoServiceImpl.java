package com.kitty.hotel.demo.service.impl;


import com.kitty.hotel.demo.entity.AppInfo;
import com.kitty.hotel.demo.mapper.AppInfoMapper;
import com.kitty.hotel.demo.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AppInfoService")
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;


    @Override
    public void addApp(AppInfo appInfo) {
        this.appInfoMapper.insertApp(appInfo);
    }

    @Override
    public void updateApp(AppInfo appInfo) {
        this.appInfoMapper.updateApp(appInfo);
    }

    @Override
    public AppInfo queryStaffByStaffId(Integer appId) {
        return this.appInfoMapper.selectAppByAppId(appId);
    }

    @Override
    public List<AppInfo> queryAllApp(AppInfo appInfo) {
        return this.appInfoMapper.selectAllApps(appInfo);
    }

    @Override
    public void deleteApp(Integer appId) {
        this.appInfoMapper.deleteAppByAppId(appId);
    }
}

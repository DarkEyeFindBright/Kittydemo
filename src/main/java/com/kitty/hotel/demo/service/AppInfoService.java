package com.kitty.hotel.demo.service;

import com.kitty.hotel.demo.entity.AppInfo;


import java.util.List;

public interface AppInfoService {
    void addApp(AppInfo appInfo);

    void updateApp(AppInfo appInfo);

    AppInfo queryStaffByStaffId(Integer appId);

    List<AppInfo> queryAllApp(AppInfo appInfo);

    void deleteApp(Integer appId);
}

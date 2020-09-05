package com.kitty.hotel.demo.controller;

import com.kitty.hotel.demo.entity.AppInfo;
import com.kitty.hotel.demo.entity.RoomInfo;
import com.kitty.hotel.demo.service.AppInfoService;
import com.kitty.hotel.demo.service.RoomInfoService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/AppInfo")
public class AppInfoController {

        @Resource
        private AppInfoService appInfoService;
        @Resource
        private RoomInfoService roomInfoService;

        @InitBinder
        public void initBinder(WebDataBinder dataBinder){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(true);
            dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
        }


        @GetMapping(path="/preAdd")
        public String toAdd(){
            return "App/addApp";
        }
        //    PostMapping(path = "") = RequestMapping(path = "", method = RequestMethod.POST)
        @PostMapping(path = "/add")
        public String addStaff(AppInfo appInfo, RoomInfo roomInfo) {
            roomInfo.setStatus(0);
            roomInfo.setRoomDate(appInfo.getAppDate());
            roomInfo.setRoomId(appInfo.getRoomId());
            this.roomInfoService.updateRoom(roomInfo);
            this.appInfoService.addApp(appInfo);
//        确定返回的视图 - 页面
            return "redirect:/AppInfo/showList"; // 使用重定向的方式重新发起请求，请求另一个方法的执行
        }

        @RequestMapping(path = "/showList", method = {RequestMethod.GET, RequestMethod.POST})
        public String showList(Model model, AppInfo appInfo) {
            if (appInfo == null) {
                appInfo=new AppInfo();
            }
            List<AppInfo> apps = this.appInfoService.queryAllApp(appInfo);
            model.addAttribute("apps", apps);
            return "/App/AppList";
        }

        @GetMapping(path = "/preUpdate/{appId}")
        public String preUpdate(@PathVariable("appId") Integer appId, Model model){
            System.out.println("当前需要修改信息的是：" + appId);

            AppInfo app = this.appInfoService.queryStaffByStaffId(appId);

            model.addAttribute("app", app);

            return "/App/updateApp";
        }


        @PostMapping(path = "/update")
        public String updateDept(AppInfo appInfo){
            System.out.println("更改后的信息是：" + appInfo);
            this.appInfoService.updateApp(appInfo);
            return "redirect:/AppInfo/showList";
        }

        @GetMapping(path = "/disabled/{appId}")
        public @ResponseBody String disableDept(@PathVariable("appId") Integer appId, Model model){
            System.out.println("需要删除的人是:" + appId);
            this.appInfoService.deleteApp(appId);
            return "redirect:/AppInfo/showList";
        }

}

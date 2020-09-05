package com.kitty.hotel.demo.controller;

import com.kitty.hotel.demo.entity.StaffInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.kitty.hotel.demo.service.StaffInfoService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path="/StaffInfo")
public class StaffInfoController {
    @Resource
    private StaffInfoService staffInfoService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(true);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }


    @GetMapping(path="/preAdd")
    public String toAdd(){
        return "/Staff/addStaff";
    }
    //    PostMapping(path = "") = RequestMapping(path = "", method = RequestMethod.POST)
    @PostMapping(path = "/add")
    public String addStaff(StaffInfo staffInfo) {
        this.staffInfoService.addStaff(staffInfo);
//        确定返回的视图 - 页面
        return "redirect:/StaffInfo/showList"; // 使用重定向的方式重新发起请求，请求另一个方法的执行
    }

    @RequestMapping(path = "/showList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showList(Model model, StaffInfo staffInfo) {
        if (staffInfo == null) {
            staffInfo = new StaffInfo();
        }
        List<StaffInfo> staffs = this.staffInfoService.queryAllStaff(staffInfo);
        model.addAttribute("staffs", staffs);
        return "/Staff/staffList";
    }

    @GetMapping(path = "/preUpdate/{staffId}")
    public String preUpdate(@PathVariable("staffId") Integer staffId, Model model){
        System.out.println("当前需要修改信息的是：" + staffId);

        StaffInfo staff = this.staffInfoService.queryStaffByStaffId(staffId);

        model.addAttribute("staff", staff);

        return "/Staff/updateStaff";
    }

//    @GetMapping(path = "/showInfo/{staffId}")
//    public String showInfo(@PathVariable("staffId") Integer staffId, Model model){
//        System.out.println("需要查询的部门编号是：" + staffId);
//       StaffInfo staff= this.staffInfoService.queryStaffByStaffId(staffId);
//        model.addAttribute("staff", staff);
//        System.out.println(staff);
//        return "staffInfo";
//    }

    @PostMapping(path = "/update")
    public String updateDept(StaffInfo staffInfo){
        System.out.println("更改后的信息是：" + staffInfo);
        this.staffInfoService.updateStaff(staffInfo);
        return "redirect:/StaffInfo/showList";
    }

    @GetMapping(path = "/disabled/{staffId}")
    public @ResponseBody String disableDept(@PathVariable("staffId") Integer staffId, Model model){
        System.out.println("需要删除的人是:" + staffId);
        this.staffInfoService.deleteStaff(staffId);
        return "redirect:/StaffInfo/showList";
    }
}

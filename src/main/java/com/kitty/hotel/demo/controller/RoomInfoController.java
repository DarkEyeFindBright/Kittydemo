package com.kitty.hotel.demo.controller;

import com.kitty.hotel.demo.entity.RoomInfo;
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
@RequestMapping(path="/RoomInfo")
public class RoomInfoController {
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
        return "/Room/addRoom";
    }
    //    PostMapping(path = "") = RequestMapping(path = "", method = RequestMethod.POST)
    @PostMapping(path = "/add")
    public String addRoom(RoomInfo roomInfo) {
        this.roomInfoService.addRoom(roomInfo);
//        确定返回的视图 - 页面
        return "redirect:/RoomInfo/showList"; // 使用重定向的方式重新发起请求，请求另一个方法的执行
    }

    @RequestMapping(path = "/showList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showList(Model model, RoomInfo roomInfo) {
        if (roomInfo == null) {
            roomInfo = new RoomInfo();
        }
        List<RoomInfo> rooms = this.roomInfoService.queryAllRoom(roomInfo);
        model.addAttribute("rooms", rooms);
        return "/Room/roomList";
    }

    @GetMapping(path = "/preUpdate/{roomId}")
    public String preUpdate(@PathVariable("roomId") Integer roomId, Model model){
        System.out.println("当前需要修改信息的是：" + roomId);

        RoomInfo room = this.roomInfoService.queryRoomByRoomId(roomId);

        model.addAttribute("room", room);

        return "/Room/updateRoom";
    }
    @PostMapping(path = "/update")
    public String updateRoom(RoomInfo roomInfo){
        System.out.println("更改后的信息是：" + roomInfo);
        this.roomInfoService.updateRoom(roomInfo);
        return "redirect:/RoomInfo/showList";
    }

    @GetMapping(path = "/disabled/{roomId}")
    public @ResponseBody String disableRoom(@PathVariable("roomId") Integer roomId, Model model){
        System.out.println("需要删除的客房是:" + roomId);
        this.roomInfoService.deleteRoom(roomId);
        return "redirect:/RoomInfo/showList";
    }
}

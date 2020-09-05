package com.kitty.hotel.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AppInfo {
    private Integer guestId;
    private Integer roomId;
    private Date appDate;
    private Integer appId;
    private String guestName;
}

package com.kitty.hotel.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StaffInfo {
    private Integer staffId;
    private String staffName;
    private Date birthday;
    private Integer phone;
}

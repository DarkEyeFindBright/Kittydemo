package com.kitty.hotel.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoomInfo {
    private Integer roomId;
    private Integer status;
    private Date roomDate;
}

package com.kitty.hotel.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Login {
    private Integer manageId;
    private String manageName;
    private String managePass;
}

package com.kitty.hotel.demo.service;


import com.kitty.hotel.demo.entity.Login;

import java.security.NoSuchAlgorithmException;


public interface LoginService {
    void insertManage(Login login);
    Integer login(Login login) throws NoSuchAlgorithmException;
}

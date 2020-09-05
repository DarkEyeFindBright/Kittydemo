package com.kitty.hotel.demo.service.impl;

import com.kitty.hotel.demo.entity.Login;
import com.kitty.hotel.demo.mapper.LoginMapper;
import com.kitty.hotel.demo.service.LoginService;
import com.kitty.hotel.demo.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public void insertManage(Login login) {
        this.loginMapper.insertManage(login);
    }


    @Override
    public Integer login(Login login) throws NoSuchAlgorithmException {
        Login manageDB = this.loginMapper.selectManageByLoginId(login.getManageId());
//        根据用户编号查询用户，返回值是null 表示不存在该用户，向上返回对应的代码2
        if (null == manageDB) {
            return 2;
        }
//        数据库中的密码和前台传来的密码一致 - 登录成功的
//        加密前台传来的密码字符串
        String password = login.getManagePass();
        if (manageDB.getManagePass().equals(password)) {
            return 1;
        }
        return 0;
    }
}

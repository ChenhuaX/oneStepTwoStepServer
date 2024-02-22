package com.chx.api;

import com.alibaba.fastjson2.JSON;
import com.chx.domain.User;
import com.chx.service.UserService;
import com.chx.support.HttpSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserApi {
    @Autowired
    HttpSupport httpSupport;

    @Autowired
    UserService userService;

    // 用户提交信息： id、头像、分数、省份、提交时间
    @PostMapping("/user")
    String addUser(String code){
        //System.out.println(code);
        String req = httpSupport.getUserInfo(code);
        //System.out.println(req);
        // 返回成功
        return JSON.toJSONString(req);
    }

    @PostMapping("/record")
    String getRecord(String openId, String nickname, String province, int record, long time, String avatarUrl){

        Date date = new Date(time);

        User user = new User();
        user.setRecord(record);
        user.setNickname(nickname);
        user.setProvince(province);
        user.setOpenid(openId);
        user.setUpdateTime(date);
        user.setAvatarUrl(avatarUrl);
        return JSON.toJSONString(userService.getUserByOpenId(user));
    }

    @GetMapping("/top")
    String getTop(){
        return JSON.toJSONString(userService.getTop50());
    }
    //@GetMapping("/user-record/{code}")


}

package com.chx.service;

import com.chx.dao.UserDao;
import com.chx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private static List<User> top50 = new ArrayList<>();

    private static synchronized void updateTop50(User user){
        // 获取排行榜中最大值分数下标
        int index = 0;
        for(int i = 0; i < top50.size(); i++) {
            // 如果是同一玩家，则替换。
            if (top50.get(i).getOpenid().equals(user.getOpenid())) {


                return;
            }
            if(top50.get(index).getRecord() < top50.get(i).getRecord()) {
                index = i;
            }
        }

        if(top50.size() < 50){
            top50.add(user);
        }else{
            // 如果更优则替代
            if(user.getRecord() < top50.get(index).getRecord()){
                top50.set(index, user);
            }
        }
    }
    @Autowired
    private UserDao userDao;
    public void addUser(User user){
        if(user != null){
            userDao.addUser(user);
        }
    }
    private static void test(){


        for(int i = 0; i < 5; i++){
            User u = new User();
            u.setAvatarUrl("https://thirdwx.qlogo.cn/mmopen/vi_32/cabLXAUXiavWpKtfn6hclIHHRXdibHldkRhF5HaRW8SGgOYbEBvBEBMqQqaMopyHAeq5txabNzYMUrXD6E1TASZA/132");
            u.setNickname("熊呼壮哉 ");
            u.setRecord(10000*(5-i));
            top50.add(u);
        }
    }
    public User getUserByOpenId(User user){
        User _user = null;
        test();
        if(user != null){
            _user = userDao.getUserByOpendId(user.getOpenid());
            // 当openId查询不到，进行添加操作，如果找到，则比较record大小。
            if(_user == null){
                userDao.addUser(user);
                _user = user;

            }else if(user.getRecord() > 0 && (_user.getRecord() < 0 || user.getRecord() < _user.getRecord())){
                userDao.updateUser(user);
                _user = user;
                // 更新前50名：
                updateTop50(user);

                System.out.println(top50.size());
            }
        }

        return _user;
    }

    public List<User> getTop50(){
        return top50;
    }
}

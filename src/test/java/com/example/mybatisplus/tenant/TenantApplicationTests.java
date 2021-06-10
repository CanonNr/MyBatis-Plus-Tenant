package com.example.mybatisplus.tenant;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.example.mybatisplus.tenant.config.CurrentUser;
import com.example.mybatisplus.tenant.config.LocalUser;
import com.example.mybatisplus.tenant.entity.User;
import com.example.mybatisplus.tenant.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class TenantApplicationTests {

    @Resource
    UserMapper userMapper;

    LocalUser localUser = new LocalUser(1L,"123","123");

    @Test
    void contextLoads() {
        CurrentUser.addCurrentUser(localUser);
//        User user = userMapper.getUser(10L);
//        System.out.println(user);
//        List<User> all = userMapper.all();
        List<User> all = userMapper.selectAll();

        System.out.println(all);
        System.out.println(all.size());


    }


    @Test
    void test1() {
        CurrentUser.addCurrentUser(localUser);
        List<User> all = userMapper.all();

        System.out.println(all);
        System.out.println(all.size());
    }

    @Test
    void test2() {
        CurrentUser.addCurrentUser(localUser);
        User user = userMapper.getUser(10L);
        System.out.println(user);
    }


}

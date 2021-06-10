package com.example.mybatisplus.tenant.mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.tenant.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface  UserMapper extends BaseMapper<User> {
    public String getNameById(Long id);

    public Integer Insert(User user);

    public User getUser(@Param("id") Long id);

    public List<User> all();

    public List<User> selectAll();

}

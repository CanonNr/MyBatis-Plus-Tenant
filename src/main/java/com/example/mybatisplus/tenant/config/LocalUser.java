package com.example.mybatisplus.tenant.config;

import lombok.Data;

@Data
public class LocalUser {

    public Long tid;

    public String id;

    public String name;

    public LocalUser(){

    }

    public LocalUser(Long tid, String id, String name){
        this.tid = tid;
        this.id = id;
        this.name = name;
    }

}

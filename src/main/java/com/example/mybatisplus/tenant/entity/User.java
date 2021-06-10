package com.example.mybatisplus.tenant.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {
    @TableId()
    public Long id;

    public String name;

    public Integer tenantId;

    public Integer Status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupId=" + tenantId +
                ", Status=" + Status +
                '}';
    }
}

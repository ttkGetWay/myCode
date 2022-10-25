package com.ashink.graduationdesign.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginLog {
    private Integer id;
    private String userName;
    private Date loginTime;//登录时间
    private Date outTime;//退出时间
}

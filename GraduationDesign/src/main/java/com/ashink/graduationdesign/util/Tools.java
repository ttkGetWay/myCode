package com.ashink.graduationdesign.util;

public class Tools {
    public static String judgeAccountAndPassword(String userName, String userPassword) {
        if (userName.equals("") || userPassword.equals("")) {
            return "账号或密码为空";
        }
        return "";
    }
}

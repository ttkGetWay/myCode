package com.tking.andonsystem.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatus {
    private Long id;//自增id
    private String userName;//账号
    private String accountStatus;//账号状态
}

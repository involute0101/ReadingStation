package com.dbtest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 登录信息VO层
 */
@Data
@AllArgsConstructor
public class LoginResult {

    private boolean isSuccess;

    private String reason;

    public LoginResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public static LoginResult success() {
        return new LoginResult(true);
    }

    public static LoginResult fail(String reason){
        return new LoginResult(false,reason);
    }
}

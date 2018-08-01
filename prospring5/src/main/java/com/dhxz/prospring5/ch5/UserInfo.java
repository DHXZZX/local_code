package com.dhxz.prospring5.ch5;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 10066610
 */
@Data
@Builder(toBuilder = true)
@Accessors(fluent = true,chain = true)
public class UserInfo {
    private String userName;
    private String password;
}

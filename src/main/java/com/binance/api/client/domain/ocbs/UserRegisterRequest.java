package com.binance.api.client.domain.ocbs;

import lombok.Data;

/**
 * <p></p >
 *
 * @author shenyue
 */
@Data
public class UserRegisterRequest {
    private String merchantUserAccount;
    private String userIp;
}

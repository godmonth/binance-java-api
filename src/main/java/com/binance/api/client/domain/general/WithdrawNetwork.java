package com.binance.api.client.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * <p></p >
 *
 * @author shenyue
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WithdrawNetwork {
    private String addressRegex;
    private String coin;
    private Boolean depositEnable;
    private String insertTime;
    private Boolean isDefault;
    private String memoRegex;
    private Long minConfirm;
    private String name;
    private String network;
    private Boolean resetAddressStatus;
    private String specialTips;
    private Long unLockConfirm;
    private Boolean withdrawEnable;
    private String withdrawFee;
    private String withdrawIntegerMultiple;
    private String withdrawMin;


}

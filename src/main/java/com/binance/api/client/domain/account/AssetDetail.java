package com.binance.api.client.domain.account;

import lombok.Data;

/**
 * <p></p >
 *
 * @author shenyue
 */
@Data
public class AssetDetail {
    private String minWithdrawAmount;
    private Boolean depositStatus;

    private String withdrawFee;
    private Boolean withdrawStatus;
    private String depositTip;
}

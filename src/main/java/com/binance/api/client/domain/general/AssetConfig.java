package com.binance.api.client.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * <p></p >
 *
 * @author shenyue
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetConfig {
    private String coin;
    private Boolean depositAllEnable;
    private String free;
    private String freeze;
    private String ipoable;
    private String ipoing;
    private Boolean isLegalMoney;
    private String locked;
    private String name;
    private String storage;
    private Boolean trading;
    private Boolean withdrawAllEnable;
    private String withdrawing;
    private List<WithdrawNetwork> networkList;
}

package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * A withdraw result that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WithdrawResult2 {

    /**
     * Withdraw id.
     */
    private String id;


}

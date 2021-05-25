package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

/**
 * A deposit that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Deposit2 {

    /**
     * Amount deposited.
     */
    private String amount;

    /**
     * Symbol.
     */
    private String coin;
    /**
     * Symbol.
     */
    private String network;

    private String address;

    private String addressTag;

    private String transferType;

    private String confirmTimes;

    /**
     * Deposit time.
     */
    private Long insertTime;
    /**
     * Transaction id
     */
    private String txId;
    /**
     * (0:pending,1:success)
     */
    private int status;

    public Date getInsertTimeDate() {
        if (insertTime != null) {
            return new Date(insertTime);
        } else {
            return null;
        }
    }

}

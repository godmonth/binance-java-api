package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * A withdraw that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString
public class Withdraw2 {
    private BigDecimal transactionFee;
    private String network;
    private String withdrawOrderId;
    /**
     * Amount withdrawn.
     */
    private String amount;

    /**
     * Destination address.
     */
    private String address;

    /**
     * Symbol.
     */
    private String coin;

    /**
     * 秒.gmt时区.当地时间
     */
    private String applyTime;

    /**
     * Transaction id.
     */
    private String txId;

    /**
     * Id.
     */
    private String id;

    /**
     * (0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed)
     */
    private int status;

}

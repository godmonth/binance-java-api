package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.apache.commons.lang3.time.FastDateFormat;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

/**
 * A withdraw that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString
public class Withdraw2 {
    private static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT"));
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

    public Date getApplyTimeDate() {
        try {
            return DATE_FORMAT.parse(getApplyTime());
        } catch (ParseException e) {
            throw new ContextedRuntimeException(e);
        }
    }

}

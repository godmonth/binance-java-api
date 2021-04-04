package com.binance.api.client.domain.account.request;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Base request parameters for order-related methods.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BaseRequest {

    private Long recvWindow;

    private Long timestamp;

    public BaseRequest() {
        this.timestamp = System.currentTimeMillis();
        this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
    }

    public BaseRequest(String symbol) {
    }


    public BaseRequest recvWindow(Long recvWindow) {
        this.recvWindow = recvWindow;
        return this;
    }

    public BaseRequest timestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }


}

package com.binance.api.client.domain.account.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * A specialized order request with additional filters.
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class AllOrdersRequest extends OrderRequest {

    private static final Integer DEFAULT_LIMIT = 500;

    private Long orderId;

    private Integer limit;

    public AllOrdersRequest(String symbol) {
        super(symbol);
        this.limit = DEFAULT_LIMIT;
    }

    public AllOrdersRequest orderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public AllOrdersRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }


}

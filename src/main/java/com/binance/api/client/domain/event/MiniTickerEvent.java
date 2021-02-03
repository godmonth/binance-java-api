package com.binance.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniTickerEvent {

    @JsonProperty("e")
    private String eventType;

    @JsonProperty("E")
    private Long eventTime;

    @JsonProperty("s")
    private String symbol;

    /**
     * 最新成交价格
     */
    @JsonProperty("c")
    private String currentPrice;

    /**
     * 24小时前开始第一笔成交价格
     */
    @JsonProperty("o")
    private String oldPrice;

    @JsonProperty("h")
    private String highestPrice;

    @JsonProperty("l")
    private String lowestPrice;

    @JsonProperty("v")
    private String volume;

    @JsonProperty("q")
    private String quantity;


}
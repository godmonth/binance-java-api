package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * History of account deposits.
 *
 * @see Deposit
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DepositHistory2 {

  @JsonProperty("depositList")
  private List<Deposit> depositList;

  private boolean success;

  private String msg;



}

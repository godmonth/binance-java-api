package com.binance.api.client.domain.account;

import org.junit.Test;

/**
 * <p></p >
 *
 * @author shenyue
 */
public class Withdraw2Test {

    @Test
    public void getApplyTimeDate() {
        Withdraw2 withdraw2 = new Withdraw2();
        withdraw2.setApplyTime("2021-03-29 08:22:15");
        System.out.println(withdraw2.getApplyTimeDate());

    }
}
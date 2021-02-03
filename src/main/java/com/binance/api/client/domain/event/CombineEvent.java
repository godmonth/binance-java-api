package com.binance.api.client.domain.event;

import lombok.Data;

/**
 * <p></p >
 *
 * @author shenyue
 */
@Data
public class CombineEvent<T> {
    public T data;
    private String stream;

}

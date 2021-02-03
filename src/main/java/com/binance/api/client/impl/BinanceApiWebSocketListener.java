package com.binance.api.client.impl;

import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.exception.BinanceApiException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.io.IOException;

/**
 * Binance API WebSocket listener.
 */
@Slf4j
public class BinanceApiWebSocketListener<T> extends WebSocketListener {

    private static final ObjectMapper mapper = new ObjectMapper();
    private final ObjectReader objectReader;
    private BinanceApiCallback<T> callback;
    private boolean closing = false;

    public BinanceApiWebSocketListener(BinanceApiCallback<T> callback, Class<T> eventClass) {
        this.callback = callback;
        this.objectReader = mapper.readerFor(eventClass);
    }

    public BinanceApiWebSocketListener(BinanceApiCallback<T> callback, TypeReference<T> eventTypeReference) {
        this.callback = callback;
        this.objectReader = mapper.readerFor(eventTypeReference);
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        try {
            log.trace("text: {}", text);
            T event = objectReader.readValue(text);
            callback.onResponse(event);
        } catch (IOException e) {
            throw new BinanceApiException(e);
        }
    }

    @Override
    public void onClosing(final WebSocket webSocket, final int code, final String reason) {
        log.debug("ws closing:", webSocket);
        closing = true;
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        log.debug("ws onFailure:", webSocket);

        if (!closing) {
            callback.onFailure(t);
        }
    }
}
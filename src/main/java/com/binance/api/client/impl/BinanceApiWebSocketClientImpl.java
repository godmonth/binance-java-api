package com.binance.api.client.impl;

import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.config.BinanceApiConfig;
import com.binance.api.client.domain.event.AggTradeEvent;
import com.binance.api.client.domain.event.BookTickerEvent;
import com.binance.api.client.domain.event.CandlestickEvent;
import com.binance.api.client.domain.event.CombineEvent;
import com.binance.api.client.domain.event.DepthEvent;
import com.binance.api.client.domain.event.MiniTickerEvent;
import com.binance.api.client.domain.event.TickerEvent;
import com.binance.api.client.domain.event.UserDataUpdateEvent;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.io.Closeable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Binance API WebSocket client implementation using OkHttp.
 */
@Slf4j
public class BinanceApiWebSocketClientImpl implements BinanceApiWebSocketClient, Closeable {

    private final OkHttpClient client;

    public BinanceApiWebSocketClientImpl(OkHttpClient client) {
        this.client = client;
    }

    @Override
    public Closeable onDepthEvent(String symbols, BinanceApiCallback<DepthEvent> callback) {
        final String channel = Arrays.stream(symbols.split(","))
                .map(String::trim)
                .map(s -> String.format("%s@depth", s))
                .collect(Collectors.joining("/"));
        return createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, DepthEvent.class));
    }

    @Override
    public Closeable onCandlestickEvent(String symbols, CandlestickInterval interval, BinanceApiCallback<CandlestickEvent> callback) {
        final String channel = Arrays.stream(symbols.split(","))
                .map(String::trim)
                .map(s -> String.format("%s@kline_%s", s, interval.getIntervalId()))
                .collect(Collectors.joining("/"));
        return createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, CandlestickEvent.class));
    }
    
    @Override
    public Closeable onAggTradeEvent(String symbols, BinanceApiCallback<AggTradeEvent> callback) {
        final String channel = Arrays.stream(symbols.split(","))
                .map(String::trim)
                .map(s -> String.format("%s@aggTrade", s))
                .collect(Collectors.joining("/"));
        return createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, AggTradeEvent.class));
    }
    
    @Override
    public Closeable onUserDataUpdateEvent(String listenKey, BinanceApiCallback<UserDataUpdateEvent> callback) {
        return createNewWebSocket(listenKey, new BinanceApiWebSocketListener<>(callback, UserDataUpdateEvent.class));
    }

    @Override
    public Closeable onTickerEvent(String symbols, BinanceApiCallback<TickerEvent> callback) {
        final String channel = Arrays.stream(symbols.split(","))
                .map(String::trim)
                .map(s -> String.format("%s@ticker", s))
                .collect(Collectors.joining("/"));
        return createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, TickerEvent.class));
    }
    
    @Override
    public Closeable onAllMarketTickersEvent(BinanceApiCallback<List<TickerEvent>> callback) {
        final String channel = "!ticker@arr";
        return createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, new TypeReference<List<TickerEvent>>() {
        }));
    }

    @Override
    public Closeable onBookTickerEvent(String symbols, BinanceApiCallback<BookTickerEvent> callback) {
        final String channel = Arrays.stream(symbols.split(","))
                .map(String::trim)
                .map(s -> String.format("%s@bookTicker", s))
                .collect(Collectors.joining("/"));
        return createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, BookTickerEvent.class));
    }
    
    @Override
    public Closeable onAllBookTickersEvent(BinanceApiCallback<BookTickerEvent> callback) {
        final String channel = "!bookTicker";
        return createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, BookTickerEvent.class));
    }

    @Override
    public Closeable onMiniTickerEvent(String symbol, BinanceApiCallback<MiniTickerEvent> callback) {
        final String channel = symbol + "@miniTicker";
        return createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, MiniTickerEvent.class));
    }

    @Override
    public Closeable onCombineMiniTickerEvent(String symbols, BinanceApiCallback<CombineEvent<MiniTickerEvent>> callback) {
        final String channel = Arrays.stream(symbols.split(","))
                .map(String::trim)
                .map(s -> String.format("%s@miniTicker", s))
                .collect(Collectors.joining("/"));
        return createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, new TypeReference<CombineEvent<MiniTickerEvent>>() {
        }));
    }


    /**
     * @deprecated This method is no longer functional. Please use the returned {@link Closeable} from any of the other methods to close the web socket.
     */
    @Override
    public void close() {
    }

    @Override
    public void onClosed(Consumer<WebSocket> webSocketConsumer) {

    }

    private Closeable createNewWebSocket(String channel, BinanceApiWebSocketListener<?> listener) {
        String streamingUrl = null;
        if (channel.contains("/")) {
            streamingUrl = String.format("%s%s", BinanceApiConfig.getCombineStreamApiBaseUrl(), channel);
        } else {
            streamingUrl = String.format("%s/%s", BinanceApiConfig.getStreamApiBaseUrl(), channel);
        }
        log.debug("streamingUrl:{}", streamingUrl);
        Request request = new Request.Builder().url(streamingUrl).build();
        final WebSocket webSocket = client.newWebSocket(request, listener);

        return () -> {
            final int code = 1000;
            listener.onClosing(webSocket, code, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, null);
        };
    }

}

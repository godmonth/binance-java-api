package com.binance.api.client.impl;

import com.binance.api.client.BinanceOcbsApiRestClient;
import com.binance.api.client.domain.ocbs.UserRegisterRequest;
import com.binance.api.client.domain.ocbs.UserRegisterResponse;
import retrofit2.Call;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.createService;
import static com.binance.api.client.impl.BinanceApiServiceGenerator.executeSync;

/**
 * <p></p >
 *
 * @author shenyue
 */
public class BinanceOcbsApiRestClientImpl implements BinanceOcbsApiRestClient {
    private final BinanceApiService binanceApiService;

    public BinanceOcbsApiRestClientImpl(String apiKey, String secret) {
        binanceApiService = createService(BinanceApiService.class, apiKey, secret);
    }

    @Override
    public UserRegisterResponse userRegister(UserRegisterRequest userRegisterRequest) {
        final Call<UserRegisterResponse> userRegisterResponseCall = binanceApiService.ocbsUserRegister(userRegisterRequest);
        return executeSync(userRegisterResponseCall);
    }
}

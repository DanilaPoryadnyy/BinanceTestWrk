package com.example.binanceapiwork.service;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BinanceClientService {
    @Bean
    public BinanceApiRestClient getBinanceClient(){
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance();
        return factory.newRestClient();
    }
}

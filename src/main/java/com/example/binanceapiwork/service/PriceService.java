package com.example.binanceapiwork.service;

import com.binance.api.client.domain.market.TickerStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RequiredArgsConstructor
@Service
public class PriceService {
    private final BinanceClientService binanceClientService;
    private final Lock lock = new ReentrantLock();

    public BigDecimal readLastPrice(String s) {
        lock.lock();
        try {
            TickerStatistics tickerStatistics = binanceClientService.getBinanceClient().get24HrPriceStatistics(s);
            return new BigDecimal(tickerStatistics.getLastPrice());
        } finally {
            lock.unlock();
        }
    }

    public TickerStatistics read24hPrice(String s) {
        lock.lock();
        try {
            return binanceClientService.getBinanceClient().get24HrPriceStatistics(s);
        } finally {
            lock.unlock();
        }
    }
}


package com.example.binanceapiwork.controller;

import com.binance.api.client.domain.market.TickerStatistics;
import com.example.binanceapiwork.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/binance/price")
public class BinanceController {

    private final PriceService priceService;

    @GetMapping("/last/{s}")
    public ResponseEntity<BigDecimal> getLastPrice(@PathVariable String s) {
        BigDecimal price = priceService.readLastPrice(s);
        return ResponseEntity.ok(price);
    }

    @GetMapping("/24h/{s}")
    public ResponseEntity<TickerStatistics> get24hPrice(@PathVariable String s) {
        TickerStatistics tickerStatistics = priceService.read24hPrice(s);
        return ResponseEntity.ok(tickerStatistics);
    }
}

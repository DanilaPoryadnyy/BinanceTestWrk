## Base URL

### `/binance/price` — базовый адрес для всех запросов к API

___

## General

### `GET` [/last/{s}](/binance/price/last/{s})

Возвращает последнюю котировку

### `GET` [/price/24h/{s}](/binance/price/24h/{s})

Возвращает статистику за 24 часа
___

## EXAMPLE

### LAST

• REQUEST

[http://localhost:8080/binance/price/last/BTCUSDT]

• RESPONE

![image](https://github.com/DanilaPoryadnyy/BinanceTestWrk/assets/114912900/2c899164-aefa-4a01-be94-565d862f468d)

### 24H

• REQUEST

[http://localhost:8080/binance/price/24h/BTCUSDT]

• RESPONE

![image](https://github.com/DanilaPoryadnyy/BinanceTestWrk/assets/114912900/d4a3b6d4-d173-4ecd-8c94-554c2c209225)

package com.coin.portfolio.portfolio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Ta")
public interface TaClient {
    @GetMapping("/getTicker")
    String getTicker();

    @GetMapping("/getPrice")
    String getPrice();

}

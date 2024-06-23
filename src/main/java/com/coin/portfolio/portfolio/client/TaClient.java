package com.coin.portfolio.portfolio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "TA", url = "http://ta")
public interface TaClient {
    @GetMapping("/getTicker")
    String getTicker();

}

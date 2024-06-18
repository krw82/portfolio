package com.coin.portfolio.portfolio.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coin.portfolio.portfolio.Asset.AssetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final AssetService assetService;

    @GetMapping("/test/v2")
    public void test2() {
        assetService.getAssetInfo();
    }

    @GetMapping("/test/v1")
    public void getMethodName() {
        assetService.getAssetPrice();
    }

}

package com.coin.portfolio.portfolio.Asset.AssetHandler;

import com.coin.portfolio.portfolio.Asset.AssetType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Stock implements AssetHandler {

    @Override
    public void getAssetsInfo() {
        log.info(AssetType.STOCK + "getAssetPrice");

    }

    @Override
    public void getAssetPrice() {
        log.info(AssetType.STOCK + "getAssetPrice");

    }

}

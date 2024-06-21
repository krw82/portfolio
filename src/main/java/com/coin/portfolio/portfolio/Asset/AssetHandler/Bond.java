package com.coin.portfolio.portfolio.Asset.AssetHandler;

import com.coin.portfolio.portfolio.Asset.AssetType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bond implements AssetHandler {

    @Override
    public void getAssetsInfo() {
        log.info(AssetType.BOND + "getAssetsInfo");
    }

    @Override
    public void getAssetPrice() {
        log.info(AssetType.BOND + "getAssetPrice");

    }

}

package com.coin.portfolio.portfolio.Asset.AssetHandler;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssetFacade {
    private final List<AssetHandler> assetHandlers;

    public void getAssetsInfo() {
        for (AssetHandler assetHandler : assetHandlers) { // 각 asset 정보가져오기
            assetHandler.getAssetsInfo();
        }
    };

    public void getAssetPrice() { // 각 asset의 마지막값 가져오기
        for (AssetHandler assetHandler : assetHandlers) {
            assetHandler.getAssetPrice();
        }
    };

}

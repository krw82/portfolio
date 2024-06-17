package com.coin.portfolio.portfolio.Asset.AssetHandler;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssetFacade {
    private final List<AssetHandler> assetHandlers;

    public void getAssetsInfo() {
        for (AssetHandler assetHandler : assetHandlers) {
            assetHandler.getAssetsInfo();
        }
    };

}

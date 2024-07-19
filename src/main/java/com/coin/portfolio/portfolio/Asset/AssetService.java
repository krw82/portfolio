package com.coin.portfolio.portfolio.Asset;

import java.util.List;

import com.coin.portfolio.portfolio.Entity.Asset;

public interface AssetService {
    Asset createAsset(Asset asset);

    Asset getAssetById(String tickerSymbol);

    List<Asset> getAllAssets();

    Asset updateAsset(String tickerSymbol, Asset assetDetails);

    void deleteAsset(String tickerSymbol);

    void getAssetInfo();

    void getAssetPrice();
}

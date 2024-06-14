package com.coin.portfolio.portfolio.Asset;

import java.time.LocalDateTime;
import java.util.List;

public interface AssetService {
    Asset createAsset(Asset asset);

    Asset getAssetById(String tickerSymbol);

    List<Asset> getAllAssets();

    Asset updateAsset(String tickerSymbol, Asset assetDetails);

    void deleteAsset(String tickerSymbol);

    List<Asset> searchAssets(String keyword);

<<<<<<< HEAD
    List<Asset> filterAssets(String assetType, LocalDateTime startDate, LocalDateTime endDate);

    void getAssetInfo();
=======
    void getAssetPrice();
>>>>>>> 3a9c0a8 (//)
}

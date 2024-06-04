package com.coin.portfolio.portfolio.Asset;

import java.time.LocalDateTime;
import java.util.List;

public interface AssetService {
    Asset createAsset(Asset asset);

    Asset getAssetById(Long assetId);

    List<Asset> getAllAssets();

    Asset updateAsset(Long assetId, Asset assetDetails);

    void deleteAsset(Long assetId);

    List<Asset> searchAssets(String keyword);

    List<Asset> filterAssets(String assetType, LocalDateTime startDate, LocalDateTime endDate);

    void getAssetPrice();
}

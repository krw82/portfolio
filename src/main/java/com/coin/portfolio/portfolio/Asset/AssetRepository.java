package com.coin.portfolio.portfolio.Asset;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String> {

    List<Asset> findByAssetType(AssetType assetType);

}

package com.coin.portfolio.portfolio.Asset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String> {

    List<Asset> findByAssetTypeAndCreatedAtBetween(String assetType, LocalDateTime startDate,
            LocalDateTime endDate);
}

package com.coin.portfolio.portfolio.Asset.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.Asset.AssetRepository;
import com.coin.portfolio.portfolio.Asset.AssetService;
import com.coin.portfolio.portfolio.Asset.AssetHandler.AssetFacade;
import com.coin.portfolio.portfolio.Entity.Asset;
import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;

import lombok.RequiredArgsConstructor;

@Primary
@RequiredArgsConstructor
@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final AssetFacade assetFacade;

    @Override
    public Asset createAsset(Asset asset) { // 자산 생성
        asset.setCreatedAt(LocalDateTime.now());
        asset.setUpdatedAt(LocalDateTime.now());
        return assetRepository.save(asset);
    }

    @Override
    public Asset getAssetById(String symbol) { // 자산 id 정보 조회
        return assetRepository.findById(symbol)
                .orElseThrow(() -> new PortfolioExeption(ErrorCode.NO_DATA_TABLE));
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset updateAsset(String symbol, Asset assetDetails) {
        Asset asset = this.getAssetById(symbol);
        asset.setSymbol(assetDetails.getSymbol());
        asset.setUpdatedAt(LocalDateTime.now());
        return assetRepository.save(asset);

    }

    @Override
    public void deleteAsset(String symbol) {
        Asset asset = this.getAssetById(symbol);
        assetRepository.delete(asset);
    }

    @Override
    public void getAssetInfo() {
        assetFacade.getAssetsInfo();
    }

    @Override
    public void getAssetPrice() {
        assetFacade.getAssetPrice();
    }

}

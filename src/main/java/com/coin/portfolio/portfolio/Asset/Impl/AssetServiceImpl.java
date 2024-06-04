package com.coin.portfolio.portfolio.Asset.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Primary;

import com.coin.portfolio.portfolio.Asset.Asset;
import com.coin.portfolio.portfolio.Asset.AssetRepository;
import com.coin.portfolio.portfolio.Asset.AssetService;
import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;

import lombok.RequiredArgsConstructor;

@Primary
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    @Override
    public Asset createAsset(Asset asset) { // 자산 생성
        asset.setCreatedAt(LocalDateTime.now());
        asset.setUpdatedAt(LocalDateTime.now());
        return assetRepository.save(asset);
    }

    @Override
    public Asset getAssetById(Long assetId) { // 자산 id 정보 조회
        return assetRepository.findById(assetId)
                .orElseThrow(() -> new PortfolioExeption(ErrorCode.NO_DATA_TABLE));
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset updateAsset(Long assetId, Asset assetDetails) {
        Asset asset = this.getAssetById(assetId);
        asset.setAssetType(assetDetails.getAssetType());
        asset.setAssetName(assetDetails.getAssetName());
        asset.setTickerSymbol(assetDetails.getTickerSymbol());
        asset.setUpdatedAt(LocalDateTime.now());
        return assetRepository.save(asset);

    }

    @Override
    public void deleteAsset(Long assetId) {
        Asset asset = this.getAssetById(assetId);
        assetRepository.delete(asset);
    }

    @Override
    public List<Asset> searchAssets(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAssets'");
    }

    @Override
    public List<Asset> filterAssets(String assetType, LocalDateTime startDate, LocalDateTime endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filterAssets'");
    }

    @Override
    public void getAssetPrice() {
        List<Asset> assets = this.getAllAssets();
        // 다른 서비스로 통신하여 가져올것.
        // 다른서비스에서는 REDIS로 저장후 가져올것. => 가격데이터 저장하기싫음.
    }

}

package com.coin.portfolio.portfolio.Asset.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.Asset.Asset;
import com.coin.portfolio.portfolio.Asset.AssetRepository;
import com.coin.portfolio.portfolio.Asset.AssetService;
import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.Util.WebClientService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Primary
@RequiredArgsConstructor
@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final WebClientService webClientService;
    private final ObjectMapper objectMapper;

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
    public List<Asset> searchAssets(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAssets'");
    }

    @Override
<<<<<<< HEAD
    public List<Asset> filterAssets(String assetType, LocalDateTime startDate, LocalDateTime endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filterAssets'");
    }

    @Override
    public void getAssetInfo() {
        try {

            String response = webClientService.ApiGet("http://127.0.0.1:8081/v3", String.class).block();
            List<Asset> assets = objectMapper.readValue(response, new TypeReference<List<Asset>>() {
            });
            for (Asset asset : assets) {
                asset.setAssetType("COIN");
            }
            assetRepository.saveAll(assets);

        } catch (Exception e) {
            e.printStackTrace();
            throw new PortfolioExeption(ErrorCode.NO_DATA_TABLE);
        }
=======
    public void getAssetPrice() {
        List<Asset> assets = this.getAllAssets();
>>>>>>> 3a9c0a8 (//)

        // 다른 서비스로 통신하여 가져올것.
        // 다른서비스에서는 REDIS로 저장후 가져올것. => 가격데이터 저장하기싫음.
    }

}

package com.coin.portfolio.portfolio.Asset.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.Asset.Asset;
import com.coin.portfolio.portfolio.Asset.AssetRepository;
import com.coin.portfolio.portfolio.Asset.AssetService;
import com.coin.portfolio.portfolio.Asset.AssetType;
import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.client.TaClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Primary
@RequiredArgsConstructor
@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final ObjectMapper objectMapper;
    private final TaClient taClient;

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
        try {

            // String response = webClientService.ApiGet("http://ta/getTicker",
            // String.class).block();
            String response = taClient.getTicker();
            List<Asset> assets = objectMapper.readValue(response, new TypeReference<List<Asset>>() {
            });
            for (Asset asset : assets) {
                asset.setAssetType(AssetType.COIN);
            }
            assetRepository.saveAll(assets);

        } catch (Exception e) {
            e.printStackTrace();
            throw new PortfolioExeption(ErrorCode.NO_DATA_TABLE);
        }
    }

}

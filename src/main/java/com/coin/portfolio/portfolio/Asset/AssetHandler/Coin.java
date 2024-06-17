package com.coin.portfolio.portfolio.Asset.AssetHandler;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.Asset.Asset;
import com.coin.portfolio.portfolio.Asset.AssetRepository;
import com.coin.portfolio.portfolio.Asset.AssetType;
import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.Util.WebClientService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Coin implements AssetHandler {

    private final AssetRepository assetRepository;
    private final WebClientService webClientService;
    private final ObjectMapper objectMapper;

    @Override
    public void getAssetsInfo() {
        try {

            String response = webClientService.ApiGet("http://127.0.0.1:8081/v3", String.class).block();
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

        // 다른 서비스로 통신하여 가져올것.
        // 다른서비스에서는 REDIS로 저장후 가져올것. => 가격데이터 저장하기싫음.
    }

}

package com.coin.portfolio.portfolio.Asset.AssetHandler;

import java.util.List;
import java.util.Map;

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

            String response = webClientService.ApiGet("http://193.123.249.35:8080/ta/getTicker", String.class).block();
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

    @Override
    public void getAssetPrice() {

        try {
            List<Asset> assets = assetRepository.findByAssetType(AssetType.COIN);
            String response = webClientService.ApiGet("https://api.binance.com/api/v3/ticker/price", String.class)
                    .block();
            List<Map<String, String>> lastPrices = objectMapper.readValue(response,
                    new TypeReference<List<Map<String, String>>>() {
                    });
            for (Asset asset : assets) {
                lastPrices.stream().filter(priceMap -> priceMap.get("symbol").equals(asset.getSymbol())).findFirst()
                        .ifPresent(priceMap -> asset.setLastPrice(Double.valueOf(priceMap.get("price"))));
            }

            assetRepository.saveAll(assets);
        } catch (Exception e) {
        }
    }

}

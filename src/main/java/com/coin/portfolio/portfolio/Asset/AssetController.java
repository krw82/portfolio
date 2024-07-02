package com.coin.portfolio.portfolio.Asset;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/assets")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @PostMapping("/")
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        Asset createdAsset = assetService.createAsset(asset);
        return ResponseEntity.ok(createdAsset);
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<Asset> getAssetById(@PathVariable(value = "symbol") String symbol) {
        Asset asset = assetService.getAssetById(symbol);
        return ResponseEntity.ok(asset);
    }

    @GetMapping("/")
    public ResponseEntity<List<Asset>> getAllAssets() {
        List<Asset> assets = assetService.getAllAssets();
        return ResponseEntity.ok(assets);
    }

    @PutMapping("/{symbol}")
    public ResponseEntity<Asset> updateAsset(@PathVariable(value = "symbol") String symbol,
            @RequestBody Asset assetDetails) {
        Asset updatedAsset = assetService.updateAsset(symbol, assetDetails);
        return ResponseEntity.ok(updatedAsset);
    }

    @DeleteMapping("/{symbol}")
    public ResponseEntity<Void> deleteAsset(@PathVariable(value = "symbol") String symbol) {
        assetService.deleteAsset(symbol);
        return ResponseEntity.noContent().build();
    }
}

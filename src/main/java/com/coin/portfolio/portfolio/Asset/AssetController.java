package com.coin.portfolio.portfolio.Asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        Asset createdAsset = assetService.createAsset(asset);
        return ResponseEntity.ok(createdAsset);
    }

    @GetMapping("/{tickerSymbol}")
    public ResponseEntity<Asset> getAssetById(@PathVariable(value = "tickerSymbol") String tickerSymbol) {
        Asset asset = assetService.getAssetById(tickerSymbol);
        return ResponseEntity.ok(asset);
    }

    @GetMapping
    public ResponseEntity<List<Asset>> getAllAssets() {
        List<Asset> assets = assetService.getAllAssets();
        return ResponseEntity.ok(assets);
    }

    @PutMapping("/{tickerSymbol}")
    public ResponseEntity<Asset> updateAsset(@PathVariable(value = "tickerSymbol") String tickerSymbol,
            @RequestBody Asset assetDetails) {
        Asset updatedAsset = assetService.updateAsset(tickerSymbol, assetDetails);
        return ResponseEntity.ok(updatedAsset);
    }

    @DeleteMapping("/{tickerSymbol}")
    public ResponseEntity<Void> deleteAsset(@PathVariable(value = "tickerSymbol") String tickerSymbol) {
        assetService.deleteAsset(tickerSymbol);
        return ResponseEntity.noContent().build();
    }
}

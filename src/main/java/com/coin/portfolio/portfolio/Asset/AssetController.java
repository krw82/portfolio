package com.coin.portfolio.portfolio.Asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        Asset createdAsset = assetService.createAsset(asset);
        return ResponseEntity.ok(createdAsset);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable(value = "id") Long assetId) {
        Asset asset = assetService.getAssetById(assetId);
        return ResponseEntity.ok(asset);
    }

    @GetMapping
    public ResponseEntity<List<Asset>> getAllAssets() {
        List<Asset> assets = assetService.getAllAssets();
        return ResponseEntity.ok(assets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable(value = "id") Long assetId,
            @RequestBody Asset assetDetails) {
        Asset updatedAsset = assetService.updateAsset(assetId, assetDetails);
        return ResponseEntity.ok(updatedAsset);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable(value = "id") Long assetId) {
        assetService.deleteAsset(assetId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Asset>> searchAssets(@RequestParam(value = "keyword") String keyword) {
        List<Asset> assets = assetService.searchAssets(keyword);
        return ResponseEntity.ok(assets);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Asset>> filterAssets(
            @RequestParam(value = "assetType", required = false) String assetType,
            @RequestParam(value = "startDate", required = false) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) LocalDateTime endDate) {
        List<Asset> assets = assetService.filterAssets(assetType, startDate, endDate);
        return ResponseEntity.ok(assets);
    }
}

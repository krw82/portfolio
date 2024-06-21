package com.coin.portfolio.portfolio.Portfolio;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/portfolios")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
        Portfolio createdPortfolio = portfolioService.createPortfolio(portfolio);
        return ResponseEntity.ok(createdPortfolio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable Long id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        return ResponseEntity.ok(portfolio);
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<Portfolio>> getUserPortfolios(@PathVariable String user) {
        List<Portfolio> portfolios = portfolioService.getUserPortfolios(user);
        return ResponseEntity.ok(portfolios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable Long id, @RequestBody Portfolio portfolioDetails) {
        portfolioService.updatePortfolio(id, portfolioDetails);
        Portfolio updatedPortfolio = portfolioService.getPortfolioById(id);
        return ResponseEntity.ok(updatedPortfolio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/optimize/{user}")
    public ResponseEntity<Portfolio> optimizeAssetAllocation(@PathVariable String user) {
        Portfolio optimizedPortfolio = portfolioService.optimizeAssetAllocation(user);
        return ResponseEntity.ok(optimizedPortfolio);
    }
}

package com.coin.portfolio.portfolio.Asset;

import java.time.LocalDateTime;

import com.coin.portfolio.portfolio.Portfolio.Portfolio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_user_info")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assetId;
    private String assetType;
    private String assetName;
    private String tickerSymbol;
    private long price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum AssetType {
        CASH,
        STOCK,
        COIN
    }

    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

}

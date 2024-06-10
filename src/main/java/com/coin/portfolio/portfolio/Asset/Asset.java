package com.coin.portfolio.portfolio.Asset;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.coin.portfolio.portfolio.Portfolio.Portfolio;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Asset")
public class Asset {
    @Id
    private String symbol;

    private String assetType;
    private double lastPrice;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /*
     * public enum AssetType {
     * CASH,
     * STOCK,
     * COIN
     * }
     */

    /*
     * @JoinColumn(name = "portfolio_id")
     * private Portfolio portfolio;
     */

}

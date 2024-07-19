package com.coin.portfolio.portfolio.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.coin.portfolio.portfolio.Asset.AssetType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "asset")
public class Asset extends BaseEntity {
    @Id
    private String symbol;

    @Enumerated(EnumType.STRING)
    private AssetType assetType;

    private double lastPrice;

}

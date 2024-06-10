package com.coin.portfolio.portfolio.Portfolio;

import java.util.Set;

import com.coin.portfolio.portfolio.Asset.Asset;
import com.coin.portfolio.portfolio.User.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long count;

    /*
     * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     * 
     * @JoinColumn(name = "portfolio_id")
     * private Set<Asset> assets;
     * 
     * @OneToOne(fetch = FetchType.LAZY)
     * 
     * @JoinColumn(name = "user_id", nullable = false)
     * private UserEntity user;
     */

}

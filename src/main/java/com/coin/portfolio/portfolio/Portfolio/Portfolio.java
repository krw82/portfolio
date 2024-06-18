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
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // portFolioId
    private Long id;

    @Column(nullable = false) // 수량
    private Long count;

    @Column(nullable = false) // 평균매입가
    private Long flatPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "symbol")
    private Asset assets;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private UserEntity user;

}

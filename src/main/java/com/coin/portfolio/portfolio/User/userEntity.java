package com.coin.portfolio.portfolio.User;

import java.util.ArrayList;
import java.util.List;

import com.coin.portfolio.portfolio.Portfolio.Portfolio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_user_info")
@Getter
@Setter
public class UserEntity {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "id")
    private List<Portfolio> portfolio = new ArrayList<>();

}

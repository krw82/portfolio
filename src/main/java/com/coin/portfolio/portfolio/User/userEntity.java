package com.coin.portfolio.portfolio.User;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.coin.portfolio.portfolio.Portfolio.Portfolio;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

<<<<<<< HEAD
    /*
     * @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch =
     * FetchType.LAZY)
     * private Portfolio portfolio;
     */
=======
    // @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch =
    // FetchType.LAZY)
    //private Portfolio portfolio;
>>>>>>> 3a9c0a8 (//)

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

}

package com.coin.portfolio.portfolio.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coin.portfolio.portfolio.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}

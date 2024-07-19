package com.coin.portfolio.portfolio.User.Service.Impl;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.DTO.UserDto;
import com.coin.portfolio.portfolio.Entity.UserEntity;
import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.User.UserRepository;

import com.coin.portfolio.portfolio.User.Service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto login(Map<String, String> params) {
        UserDto user = modelMapper.map(userRepository.findById(params.get("Id"))
                .orElseThrow(() -> new PortfolioExeption(ErrorCode.USER_NOT_FOUND)), UserDto.class);
        return user;
    }

    @Override
    public UserDto getUserById(String id) {
        return modelMapper.map(userRepository.findById(id).orElseThrow(), UserDto.class);
    }

    @Override
    public UserDto createUser(UserEntity user) {
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}

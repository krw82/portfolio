package com.coin.portfolio.portfolio.AppConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelCoinfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

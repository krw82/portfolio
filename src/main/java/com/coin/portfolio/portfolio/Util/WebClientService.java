package com.coin.portfolio.portfolio.Util;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientService {

    private final WebClient.Builder webClientBuilder;

    public <T> Mono<T> ApiGet(String url, Class<T> clazz) {
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(clazz);
    }

    public <T> Mono<T> ApiPost(String url, Class<T> clazz) {
        return webClientBuilder.build()
                .post()
                .uri(url)
                .bodyValue(clazz)
                .retrieve()
                .bodyToMono(clazz);
    }

}

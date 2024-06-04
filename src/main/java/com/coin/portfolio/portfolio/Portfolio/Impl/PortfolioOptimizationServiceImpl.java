package com.coin.portfolio.portfolio.Portfolio.Impl;

import java.util.List;

import com.coin.portfolio.portfolio.Asset.Asset;
import com.coin.portfolio.portfolio.Portfolio.Portfolio;
import com.coin.portfolio.portfolio.Portfolio.PortfolioOptimizationService;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.PropertySource.Comparator;

public class PortfolioOptimizationServiceImpl implements PortfolioOptimizationService {

    @Override
    public Portfolio optimizeAssetAllocation(List<Portfolio> portfolios) {
        return portfolios.stream() // 1. 스트림 생성: 포트폴리오 리스트를 스트림으로 변환
                .flatMap(portfolio -> portfolio.getAssets().stream()) // 2. 각 포트폴리오의 자산들을 단일 스트림으로 병합
                .collect(Collectors.groupingBy(Asset::getAssetType)) // 3. 자산들을 유형별로 그룹화
                .entrySet().stream() // 4. 맵의 엔트리(자산 유형과 자산 리스트)를 스트림으로 변환
                .flatMap(entry -> entry.getValue().stream() // 5. 각 자산 유형의 자산 리스트를 스트림으로 변환
                        .sorted(Comparator.comparing(Asset::getPrice).reversed()) // 6. 가격 기준으로 내림차순 정렬
                        .limit(3)) // 7. 상위 3개의 자산 선택
                .collect(Collectors.toList()); // 8. 결과를 리스트로 수집
    }

}

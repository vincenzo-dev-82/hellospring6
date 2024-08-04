package com.vincenzo.hellospring.exrate;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class SimpleExRateProvider implements ExRateProvider {

    @Override
    public BigDecimal getExRate(String currency) throws IOException {

        if(currency.equals("USD")) return BigDecimal.valueOf(1000L);

        throw new IllegalArgumentException("지원되지 않는 서비스 입니다.");
    }
}

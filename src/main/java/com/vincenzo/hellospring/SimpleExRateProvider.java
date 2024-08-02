package com.vincenzo.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExRateProvider {

    BigDecimal getKRWExRate(String currency) throws IOException {

        if(currency.equals("USD")) return BigDecimal.valueOf(1000L);

        throw new IllegalArgumentException("지원되지 않는 서비스 입니다.");
    }
}

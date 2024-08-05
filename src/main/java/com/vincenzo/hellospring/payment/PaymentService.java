package com.vincenzo.hellospring.payment;

import com.vincenzo.hellospring.exrate.ExRateProvider;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final ExRateProvider exRateProvider;
    private final Clock clock;

    public PaymentService(ExRateProvider exRateProvider, Clock clock) {
        this.exRateProvider = exRateProvider;
        this.clock = clock;
    }

    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {

        BigDecimal exRate = exRateProvider.getExRate(currency); // 환율 가져오기
//        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exKrwRate); // 금액 계산
//        LocalDateTime validUntil = LocalDateTime.now(clock).plusMinutes(30); // 유효 시간 계산
        return Payment.createPrepared(orderId, currency, foreignCurrencyAmount, exRate, LocalDateTime.now(clock));
    }

}

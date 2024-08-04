package com.vincenzo.hellospring.payment;

import com.vincenzo.hellospring.exrate.ExRateProvider;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PaymentService {

    ExRateProvider exRateProvider;

    public PaymentService(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }

    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {

        BigDecimal exKrwRate = exRateProvider.getExRate(currency); // 환율 가져오기
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exKrwRate); // 금액 계산
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30); // 유효 시간 계산

        return new Payment(orderId, currency, foreignCurrencyAmount, exKrwRate, convertedAmount, validUntil);
    }

}
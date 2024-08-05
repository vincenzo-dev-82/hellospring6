package com.vincenzo.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

class PaymentServiceTest {

    Clock clock;

    @BeforeEach
    void beforeEach() {
        this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }

    @Test
    @DisplayName("prepare 메서드가 요구사항 3가지를 잘 충족했는지 검증")
    void convertedAmount() throws IOException {

        testAmount(BigDecimal.valueOf(500), BigDecimal.valueOf(5_000), this.clock);
        testAmount(BigDecimal.valueOf(1_000), BigDecimal.valueOf(10_000), this.clock);
        testAmount(BigDecimal.valueOf(3_000), BigDecimal.valueOf(30_000), this.clock);

        // 원화환산금액의 유효시간 계산
//        Assertions.assertThat(payment.getValidUnit()).isAfter(LocalDateTime.now());
//        Assertions.assertThat(payment.getValidUnit()).isBefore(LocalDateTime.now().plusMinutes(30));
    }

    @Test
    void validUntil() throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(BigDecimal.valueOf(1_000)), clock);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);


        // valid until 이 prepare() 30분 뒤로 설정됐는가?
        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        Assertions.assertThat(payment.getValidUnit()).isEqualTo(expectedValidUntil);
    }

    private static void testAmount(BigDecimal exRate, BigDecimal convertedAmount, Clock clock) throws IOException {

        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate), clock);

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        // 환율정보를 가져온다
        Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
        // 원화환산금액 계산
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
    }

}
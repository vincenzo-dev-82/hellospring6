package com.vincenzo.hellospring.payment;

import com.vincenzo.hellospring.TestPaymentConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
class PaymentServiceSpringTest {

    @Autowired PaymentService paymentService;
    @Autowired Clock clock;
    @Autowired ExRateProviderStub exRateProviderStub;

    @Test
    @DisplayName("convertedAmount 메서드가 요구사항 3가지를 잘 충족했는지 검증")
    void convertedAmount() throws IOException {
        // exRate : 1000
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        // 환율정보를 가져온다
        Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(1_000));
        // 원화환산금액 계산
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(10_000));


        // exRate : 500
        exRateProviderStub.setExRate(BigDecimal.valueOf(500));
        Payment payment2 = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        Assertions.assertThat(payment2.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(500));
        Assertions.assertThat(payment2.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(5_000));


        // 원화환산금액의 유효시간 계산
//        Assertions.assertThat(payment.getValidUnit()).isAfter(LocalDateTime.now());
//        Assertions.assertThat(payment.getValidUnit()).isBefore(LocalDateTime.now().plusMinutes(30));
    }


}
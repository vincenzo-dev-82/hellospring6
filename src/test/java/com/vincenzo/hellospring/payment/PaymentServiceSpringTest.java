package com.vincenzo.hellospring.payment;

import com.vincenzo.hellospring.TestObjectFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestObjectFactory.class)
class PaymentServiceSpringTest {

    @Autowired
    BeanFactory beanFactory;

    @Test
    @DisplayName("convertedAmount 메서드가 요구사항 3가지를 잘 충족했는지 검증")
    void convertedAmount() throws IOException {
//        BeanFactory beanFactory = new AnnotationConfigApplicationContext(TestObjectFactory.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        // 환율정보를 가져온다
        Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(1_000));
        // 원화환산금액 계산
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(10_000));

        // 원화환산금액의 유효시간 계산
//        Assertions.assertThat(payment.getValidUnit()).isAfter(LocalDateTime.now());
//        Assertions.assertThat(payment.getValidUnit()).isBefore(LocalDateTime.now().plusMinutes(30));
    }

}
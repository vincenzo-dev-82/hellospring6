package com.vincenzo.hellospring;

import com.vincenzo.hellospring.exrate.CachedExRateProvider;
import com.vincenzo.hellospring.exrate.ExRateProvider;
import com.vincenzo.hellospring.exrate.WebApiExRateProvider;
import com.vincenzo.hellospring.payment.ExRateProviderStub;
import com.vincenzo.hellospring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@ComponentScan
public class TestObjectFactory {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }

}

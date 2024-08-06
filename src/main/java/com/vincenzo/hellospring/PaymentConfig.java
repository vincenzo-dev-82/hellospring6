package com.vincenzo.hellospring;

import com.vincenzo.hellospring.api.ApiTemplate;
import com.vincenzo.hellospring.api.ErApiExRateExtractor;
import com.vincenzo.hellospring.api.HttpClientApiExecutor;
import com.vincenzo.hellospring.exrate.ExRateProvider;
import com.vincenzo.hellospring.exrate.WebApiExRateProvider;
import com.vincenzo.hellospring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
@ComponentScan
public class PaymentConfig {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ApiTemplate apiTemplate() {
        return new ApiTemplate(new HttpClientApiExecutor(), new ErApiExRateExtractor());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider(apiTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}

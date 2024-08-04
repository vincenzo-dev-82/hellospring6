package com.vincenzo.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ObjectFactory {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new SimpleExRateProvider();
    }

}

class OrderService {

    ExRateProvider exRateProvider;

    OrderService(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }
}
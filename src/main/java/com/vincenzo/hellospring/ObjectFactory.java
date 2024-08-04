package com.vincenzo.hellospring;

import com.vincenzo.hellospring.exrate.CachedExRateProvider;
import com.vincenzo.hellospring.exrate.ExRateProvider;
import com.vincenzo.hellospring.exrate.WebApiExRateProvider;
import com.vincenzo.hellospring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ObjectFactory {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(cachedExRateProvider());
    }

//    @Bean
//    public OrderService orderService() {
//        return new OrderService(exRateProvider());
//    }

    @Bean
    public ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }

}

//class OrderService {
//
//    ExRateProvider exRateProvider;
//
//    OrderService(ExRateProvider exRateProvider) {
//        this.exRateProvider = exRateProvider;
//    }
//}
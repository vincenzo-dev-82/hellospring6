package com.vincenzo.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {

    public static void main(String[] args) throws IOException {

        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        OrderService orderService = beanFactory.getBean(OrderService.class);

        // 스프링을 통해 생성된 PaymentService는 모두 동일한가? 동일하다를 설명하기 위한 코드
        ObjectFactory objectFactory = beanFactory.getBean(ObjectFactory.class);
        PaymentService paymentService1 = objectFactory.paymentService();
        PaymentService paymentService2 = objectFactory.paymentService();
        System.out.println(paymentService == paymentService1);
        System.out.println(paymentService == paymentService2);
        System.out.println(paymentService1 == paymentService2);

        // 각 서비스에 주입된 exRateProvider가 동일한지 확인
        System.out.println(paymentService.exRateProvider == orderService.exRateProvider);

        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }

}

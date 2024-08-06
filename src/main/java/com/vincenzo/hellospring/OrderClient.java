package com.vincenzo.hellospring;

import com.vincenzo.hellospring.data.OrderRepository;
import com.vincenzo.hellospring.order.Order;
import com.vincenzo.hellospring.order.OrderService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

public class OrderClient {
    public static void main(String[] args) {

        BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
        OrderService orderService = beanFactory.getBean(OrderService.class);

        Order order  = orderService.createOrder("0100", BigDecimal.TEN);
        System.out.println(order);
    }
}

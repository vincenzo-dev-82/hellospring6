package com.vincenzo.hellospring;

import com.vincenzo.hellospring.data.JpaOrderRepository;
import com.vincenzo.hellospring.order.OrderRepository;
import com.vincenzo.hellospring.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
@Import(DataConfig.class)
public class OrderConfig {

    @Bean
    public OrderRepository orderRepository() {
        return new JpaOrderRepository();
    }

    @Bean
    public OrderService orderSErvice(JpaTransactionManager jpaTransactionManager) {

        return new OrderService(orderRepository(), jpaTransactionManager);
    }
}

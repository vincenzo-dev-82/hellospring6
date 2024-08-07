package com.vincenzo.hellospring;

import com.vincenzo.hellospring.order.JdbcOrderRepository;
import com.vincenzo.hellospring.order.OrderRepository;
import com.vincenzo.hellospring.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@Import(DataConfig.class)
public class OrderConfig {

    @Bean
    public OrderRepository orderRepository(DataSource dataSource) {
//        return new JpaOrderRepository();
        return new JdbcOrderRepository(dataSource);
    }

    @Bean
    public OrderService orderService(
            PlatformTransactionManager transactionManager,
            OrderRepository orderRepository
            ) {
        return new OrderService(orderRepository, transactionManager);
    }
}

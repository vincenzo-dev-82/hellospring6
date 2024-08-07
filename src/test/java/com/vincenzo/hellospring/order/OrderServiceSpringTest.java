package com.vincenzo.hellospring.order;


import com.vincenzo.hellospring.OrderConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = OrderConfig.class)
public class OrderServiceSpringTest {

    @Autowired OrderService orderService;
    @Autowired DataSource dataSource;

    @DisplayName("Order를 하나 만든다")
    @Test
    void createOrder() {
        var order = orderService.createOrder("O100", BigDecimal.ONE);

        assertThat(order.getId()).isGreaterThan(0);
    }
}

package com.vincenzo.hellospring.order;


import com.vincenzo.hellospring.OrderConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = OrderConfig.class)
public class OrderServiceSpringTest {

    @Autowired OrderService orderService;

    @DisplayName("Order를 하나 만든다")
    @Test
    void createOrder() {
        var order = orderService.createOrder("0110", BigDecimal.ONE);

        Assertions.assertThat(order.getId()).isGreaterThan(0);
    }
}

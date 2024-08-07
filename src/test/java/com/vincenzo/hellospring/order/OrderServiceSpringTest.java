package com.vincenzo.hellospring.order;


import com.vincenzo.hellospring.OrderConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("Order를 두개 이상 만든다")
    @Test
    void createOrders() {
        List<OrderReq> orderReqs = List.of(
                new OrderReq("0200", BigDecimal.ONE),
                new OrderReq("0201", BigDecimal.TWO)
        );
        var orders = orderService.createOrders(orderReqs);

        orders.stream().forEach( order -> System.out.println(order.getNo()));
        assertThat(orders).hasSize(2);
        orders.forEach(order -> Assertions.assertThat(order.getId()).isGreaterThan(0));
    }

    @DisplayName("Order를 두개 이상 만들다가 중복예외 후 롤백")
    @Test
    void createDuplicatedOrders() {
        List<OrderReq> orderReqs = List.of(
                new OrderReq("0300", BigDecimal.ONE),
                new OrderReq("0300", BigDecimal.TWO)
        );

        assertThatThrownBy(() -> orderService.createOrders(orderReqs))
                .isInstanceOf(DataIntegrityViolationException.class);

        JdbcClient jdbcClient = JdbcClient.create(dataSource);
        var count = jdbcClient.sql("select count(*) from orders where no = '0300'").query(Long.class).single();
        Assertions.assertThat(count).isEqualTo(0);
    }
}

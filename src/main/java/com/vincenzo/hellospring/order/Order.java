package com.vincenzo.hellospring.order;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String no;

    private BigDecimal total;

    public Order() {} // JPA 사용 시 기본생성자는 필수

    public Order(String no, BigDecimal total) {
        this.no = no;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public String getNo() {
        return no;
    }

    public BigDecimal getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", total=" + total +
                '}';
    }
}

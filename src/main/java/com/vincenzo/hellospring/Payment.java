package com.vincenzo.hellospring;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    private Long orderId;
    private String currency;
    private BigDecimal foreignCurrencyAmount;
    private BigDecimal exAmoutn;
    private BigDecimal convertedAmount;
    private LocalDateTime validUnit;

    public Payment(Long orderId, String currency, BigDecimal foreignCurrencyAmount, BigDecimal exAmoutn, BigDecimal convertedAmount, LocalDateTime validUnit) {
        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exAmoutn = exAmoutn;
        this.convertedAmount = convertedAmount;
        this.validUnit = validUnit;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getForeignCurrencyAmount() {
        return foreignCurrencyAmount;
    }

    public BigDecimal getExAmoutn() {
        return exAmoutn;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getValidUnit() {
        return validUnit;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exAmoutn=" + exAmoutn +
                ", convertedAmount=" + convertedAmount +
                ", validUnit=" + validUnit +
                '}';
    }
}

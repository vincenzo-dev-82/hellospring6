package com.vincenzo.hellospring.exrate;

import com.vincenzo.hellospring.api.ApiTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WebApiExRateProvider implements ExRateProvider {
    private final ApiTemplate apiTemplate;

    public WebApiExRateProvider(ApiTemplate apiTemplate) {
        this.apiTemplate = apiTemplate;
    }

    @Override
    public BigDecimal getExRate(String currency) {

        String url = "https://open.er-api.com/v6/latest/" + currency;
        return apiTemplate.getExRate(url); // 이것이 콜백이다
    }
}

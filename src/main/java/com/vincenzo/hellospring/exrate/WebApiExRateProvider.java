package com.vincenzo.hellospring.exrate;

import com.vincenzo.hellospring.api.ApiTemplate;
import com.vincenzo.hellospring.api.ErApiExRateExtractor;
import com.vincenzo.hellospring.api.HttpClientApiExecutor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WebApiExRateProvider implements ExRateProvider {
    ApiTemplate apiTemplate = new ApiTemplate();

    @Override
    public BigDecimal getExRate(String currency) {

        String url = "https://open.er-api.com/v6/latest/" + currency;

        return apiTemplate.getExRate(
                url,
                new HttpClientApiExecutor(),
                new ErApiExRateExtractor()
        ); // 이것이 콜백이다
    }
}

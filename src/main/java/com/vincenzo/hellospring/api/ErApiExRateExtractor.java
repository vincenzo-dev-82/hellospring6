package com.vincenzo.hellospring.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vincenzo.hellospring.exrate.ExRateDate;

import java.math.BigDecimal;

public class ErApiExRateExtractor implements ExRateExtractor {

    @Override
    public BigDecimal extract(String response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ExRateDate exRateDate = objectMapper.readValue(response, ExRateDate.class);
        System.out.println("API Rates : " + exRateDate.rates().get("KRW"));
        return exRateDate.rates().get("KRW");
    }
}

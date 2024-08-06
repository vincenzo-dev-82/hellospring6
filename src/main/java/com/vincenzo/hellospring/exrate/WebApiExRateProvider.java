package com.vincenzo.hellospring.exrate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

@Component
public class WebApiExRateProvider implements ExRateProvider {

    @Override
    public BigDecimal getExRate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String response;
        try {
            response = executeApi(uri);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            return parseExRate(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static BigDecimal parseExRate(String response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ExRateDate exRateDate = objectMapper.readValue(response, ExRateDate.class);
        System.out.println("API Rates : " + exRateDate.rates().get("KRW"));
        return exRateDate.rates().get("KRW");
    }

    private static String executeApi(URI uri) throws IOException {
        String response;
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            response = bufferedReader.lines().collect(Collectors.joining());
        }
        return response;
    }
}

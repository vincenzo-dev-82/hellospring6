package com.vincenzo.hellospring;

import com.vincenzo.hellospring.api.ApiTemplate;
import com.vincenzo.hellospring.api.ErApiExRateExtractor;
import com.vincenzo.hellospring.api.HttpClientApiExecutor;
import com.vincenzo.hellospring.exrate.ExRateProvider;
import com.vincenzo.hellospring.exrate.RestTemplateExRateProvider;
import com.vincenzo.hellospring.exrate.WebApiExRateProvider;
import com.vincenzo.hellospring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.http.client.JettyClientHttpRequestFactory;
import org.springframework.http.client.ReactorNettyClientRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

@Configuration
@ComponentScan
public class PaymentConfig {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ApiTemplate apiTemplate() {
        return new ApiTemplate(new HttpClientApiExecutor(), new ErApiExRateExtractor());
    }

    /**
     * SimpleClientHttpRequest(HttpURLConnection)
     * JdkClientHttpRequest(HttpClient) - JdkClientHttpRequestFactory
     * NettyClientRequest - ReactorNettyClientRequestFactory
     * JettyClientRequest - JettyClientHttpRequestFactory
     * OkHttp3ClientRequest -
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new JdkClientHttpRequestFactory());
//        return new RestTemplate(new ReactorNettyClientRequestFactory());
//        return new RestTemplate(new JettyClientHttpRequestFactory());
    }

    @Bean
    public ExRateProvider exRateProvider() {
//        return new WebApiExRateProvider(apiTemplate());
        return new RestTemplateExRateProvider(restTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}

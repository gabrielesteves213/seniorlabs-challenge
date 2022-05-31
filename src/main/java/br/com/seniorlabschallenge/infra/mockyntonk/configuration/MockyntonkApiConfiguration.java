package br.com.seniorlabschallenge.infra.mockyntonk.configuration;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockyntonkApiConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor(){return new MokcyntonkRequestInterceptor();}

}

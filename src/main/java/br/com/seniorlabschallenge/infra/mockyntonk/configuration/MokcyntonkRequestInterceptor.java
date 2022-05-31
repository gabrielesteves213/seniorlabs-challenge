package br.com.seniorlabschallenge.infra.mockyntonk.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.MediaType;

public class MokcyntonkRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    }
}

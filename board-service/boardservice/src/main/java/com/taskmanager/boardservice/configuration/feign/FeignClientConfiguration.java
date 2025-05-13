package com.taskmanager.boardservice.configuration.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignClientConfiguration {

    private static final String X_USER_EMAIL_HEADER = "X-User-Email";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                if (attributes != null) {
                    HttpServletRequest request = attributes.getRequest();
                    String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
                    String userEmailHeader = request.getHeader(X_USER_EMAIL_HEADER);
                    if (authorizationHeader != null) {
                        template.header(HttpHeaders.AUTHORIZATION, authorizationHeader);
                        template.header(X_USER_EMAIL_HEADER, userEmailHeader);
                    }
                }
            }
        };
    }
}
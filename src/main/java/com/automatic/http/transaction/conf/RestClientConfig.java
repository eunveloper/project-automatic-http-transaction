package com.automatic.http.transaction.conf;

import com.automatic.http.transaction.obj.RestClient;
import com.automatic.http.transaction.obj.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient() {
        RestClient restClient = RestClientBuilder.custom()
                .setConnectionRequestTimeout(5000)
                .setConnectionTimeout(3000)
                .setSocketTimeout(5000)
                .setMaxConnectionTotal(150).create();

        return restClient;
    }

}

package com.automatic.http.transaction.obj;

import lombok.Getter;
import lombok.Setter;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Setter
@Getter
public class RestClient {

    private RestTemplate restTemplate;
    private int connectionRequestTimeout;
    private int connectionTimeout;
    private int socketTimeout;
    private int maxConnectionTotal;

    public void init() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(this.connectionRequestTimeout)
                .setConnectTimeout(this.connectionTimeout)
                .setSocketTimeout(this.socketTimeout)
                .build();
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnPerRoute(this.maxConnectionTotal)
                .setDefaultRequestConfig(requestConfig).build();
        this.restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
    }

}

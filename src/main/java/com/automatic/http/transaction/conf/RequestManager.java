package com.automatic.http.transaction.conf;

import com.automatic.http.transaction.obj.ClientRequest;
import com.automatic.http.transaction.obj.RestClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Component
public class RequestManager<T> {

    private final RestClient restClient;

    public void request(ClientRequest request) {
        log.info("request info [" + request + "]");
        switch (request.getMethod()) {
            case POST:
                post(request.getUrl(), request.getHeader(), request.getBody(), request.getClazz());
                break;
            case PUT:
                put(request.getUrl(), request.getHeader(), request.getBody(), request.getClazz());
                break;
            case DELETE:
                delete(request.getUrl(), request.getHeader(), request.getBody(), request.getClazz());
                break;
        }
    }

    private void post(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
        callApiEndpoint(url, HttpMethod.POST, httpHeaders, body, clazz);
    }

    private void delete(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
        callApiEndpoint(url, HttpMethod.DELETE, httpHeaders, body, clazz);
    }

    private void put(String url, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
        callApiEndpoint(url, HttpMethod.PUT, httpHeaders, body, clazz);
    }

    private void callApiEndpoint(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
        RestTemplate restTemplate = restClient.getRestTemplate();
        restTemplate.exchange(url, httpMethod, new HttpEntity<>(body, httpHeaders), clazz);
    }

}

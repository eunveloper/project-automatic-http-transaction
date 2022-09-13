package com.automatic.http.transaction.conf;

import com.automatic.http.transaction.obj.ClientCommitRequest;
import com.automatic.http.transaction.obj.RestClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Component
public class RequestManager<T> {

    private final RestClient restClient;

    public void request(ClientCommitRequest request) {
        log.info("request info [" + request + "]");
        switch (request.getMethod()) {
            case POST:
                callApiEndpoint(
                        request.getUrl(),
                        HttpMethod.POST,
                        request.getHeader(),
                        request.getBody(),
                        request.getClazz());
                return;
            case PUT:
                callApiEndpoint(
                        request.getUrl(),
                        HttpMethod.PUT,
                        request.getHeader(),
                        request.getBody(),
                        request.getClazz());
                return;
            case DELETE:
                callApiEndpoint(
                        request.getUrl(),
                        HttpMethod.DELETE,
                        request.getHeader(),
                        request.getBody(),
                        request.getClazz());
        }
    }

    private ResponseEntity<T> callApiEndpoint(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Object body, Class<T> clazz) {
        RestTemplate restTemplate = restClient.getRestTemplate();
        return restTemplate.exchange(url, httpMethod, new HttpEntity<>(body, httpHeaders), clazz);
    }

}

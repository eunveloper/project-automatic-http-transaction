package com.automatic.http.transaction.obj;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ClientRequests {

    private List<ClientRequest> clientRequests;
    private ClientRequest clientRequest;

    @PostConstruct
    public void init() {
        this.clientRequests = new ArrayList<>();
    }

    public ClientRequests create() {
        this.clientRequest = new ClientRequest();
        return this;
    }

    public ClientRequests url(String url) {
        this.clientRequest.setUrl(url);
        return this;
    }

    public ClientRequests method(MethodType method) {
        this.clientRequest.setMethod(method);
        return this;
    }

    public ClientRequests header(HttpHeaders header) {
        this.clientRequest.setHeader(header);
        return this;
    }

    public ClientRequests body(Object body) {
        this.clientRequest.setBody(body);
        return this;
    }

    public ClientRequests clazz(Class clazz) {
        this.clientRequest.setClazz(clazz);
        return this;
    }

    public ClientRequests transaction(TransactionType transaction) {
        this.clientRequest.setTransaction(transaction);
        return this;
    }

    public ClientRequests add() {
        this.clientRequests.add(this.clientRequest);
        return this;
    }

    public List<ClientRequest> getClientRequests() {
        return clientRequests;
    }
}

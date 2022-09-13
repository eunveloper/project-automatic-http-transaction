package com.automatic.http.transaction.obj;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ClientRequests {

    private List<ClientCommitRequest> committedClientRequests;
    private ClientCommitRequest committedRequest;
    private List<ClientRollbackRequest> rollbackClientRequests;
    private ClientRollbackRequest rollbackRequest;

    @PostConstruct
    public void init() {
        this.committedClientRequests = new ArrayList<>();
        this.rollbackClientRequests = new ArrayList<>();
    }

    public ClientRequest create(TransactionType transactionType) {
        switch (transactionType) {
            case COMMIT:
                return ClientCommitRequest.builder().build();
            case ROLLBACK:
                return ClientRollbackRequest.builder().build();
        }
        return null;
    }

    public ClientRequests url(String url) {
        this.committedRequest.setUrl(url);
        return this;
    }

    public ClientRequests method(MethodType method) {
        this.committedRequest.setMethod(method);
        return this;
    }

    public ClientRequests header(HttpHeaders header) {
        this.committedRequest.setHeader(header);
        return this;
    }

    public ClientRequests body(Object body) {
        this.committedRequest.setBody(body);
        return this;
    }

    public ClientRequests clazz(Class clazz) {
        this.committedRequest.setClazz(clazz);
        return this;
    }

    public ClientRequests add() {
        this.committedClientRequests.add(this.committedRequest);
        this.committedRequest = null;
        return this;
    }

}

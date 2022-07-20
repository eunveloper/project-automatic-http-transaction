package com.automatic.http.transaction.obj;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;

@Setter
@Getter
public class ClientRequest<T> {

    private String url;
    private MethodType method;
    private HttpHeaders header;
    private Object body;
    private Class<T> clazz;
    private TransactionType transaction;

    @Override
    public String toString() {
        return "url='" + url + '\'' +
                ", method=" + method +
                ", header=" + header +
                ", body=" + body +
                ", clazz=" + clazz +
                ", transaction=" + transaction +
                '}';
    }
}

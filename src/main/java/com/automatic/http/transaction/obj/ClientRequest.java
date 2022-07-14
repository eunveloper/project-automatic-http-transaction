package com.automatic.http.transaction.obj;

import lombok.Setter;
import org.apache.http.HttpHeaders;

@Setter
public class ClientRequest<T> {

    private String url;
    private MethodType method;
    private HttpHeaders header;
    private Object body;
    private Class<T> clazz;

}

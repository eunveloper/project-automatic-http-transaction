package com.automatic.http.transaction.obj;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;

@Setter
@Getter
@Builder
public class ClientRollbackRequest extends ClientRequest {

    private String rollbackUrl;
    private MethodType method;
    private HttpHeaders header;
    private Object body;

}

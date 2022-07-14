package com.automatic.http.transaction;

import com.automatic.http.transaction.obj.ClientRequests;
import com.automatic.http.transaction.obj.MethodType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final ClientRequests clientRequests;

    public String testAutomaticRestTransactional() {
        clientRequests
                .init()
                .create()
                .url(null).method(MethodType.GET)
                .header(null).body(null)
                .clazz(Object.class).add()
                .url(null).method(MethodType.GET)
                .header(null).body(null)
                .clazz(Object.class).add();
        return null;
    }
}

package com.automatic.http.transaction;

import com.automatic.http.transaction.aop.RestTransactional;
import com.automatic.http.transaction.conf.TransactionManager;
import com.automatic.http.transaction.obj.ClientRequests;
import com.automatic.http.transaction.obj.MethodType;
import com.automatic.http.transaction.obj.ResponseObj;
import com.automatic.http.transaction.obj.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.automatic.http.transaction.obj.TransactionType.ROLLBACK;

@Service
@RequiredArgsConstructor
public class TestService {

    private final ClientRequests clientRequests;
    private final TransactionManager transactionManager;

    @RestTransactional
    public String testAutomaticRestTransactional(String msg) {
        HttpHeaders httpHeaders = new HttpHeaders();
        UUID uuid = UUID.randomUUID();
        httpHeaders.set("content-type", "application/json");
        clientRequests
                .create(ROLLBACK)
                /*.url("http://localhost:8087/api/test?msg=" + msg)
                .method(MethodType.POST)
                .header(httpHeaders)
                .clazz(String.class)*/
                /*.add()
                .create()
                .url("http://localhost:8087/api/test?msg=" + uuid)
                .method(MethodType.POST)
                .header(httpHeaders)
                .clazz(String.class).transaction(TransactionType.COMMIT)
                .add()*/;
        ResponseObj responseObj = transactionManager.run();
        List list = transactionManager.run();
        return msg;
    }
}

package com.automatic.http.transaction.conf;

import com.automatic.http.transaction.obj.ClientRequest;
import com.automatic.http.transaction.obj.ClientRequests;
import com.automatic.http.transaction.obj.TransactionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionManager {

    private final ClientRequests clientRequests;
    private final RequestManager requestManager;

    @AfterReturning("@annotation(com.automatic.http.transaction.aop.RestTransactional)")
    public void transactionalReturning() {  // Transaction type is commit
        log.info("start request transaction type is commit ..");

        List<ClientRequest> requests = clientRequests.getClientRequests();
        for (ClientRequest request : requests) {
            if (request.getTransaction().equals(TransactionType.COMMIT)) {
                requestManager.request(request);
            }
        }
    }

    @AfterThrowing("@annotation(com.automatic.http.transaction.aop.RestTransactional)")
    public void transactionalThrowing() {   // Transaction type is rollback
        log.info("start request transaction type is rollback ..");

        List<ClientRequest> requests = clientRequests.getClientRequests();
        for (ClientRequest request : requests) {
            if (request.getTransaction().equals(TransactionType.ROLLBACK)) {

            }
        }
    }

}

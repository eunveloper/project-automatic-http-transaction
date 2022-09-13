package com.automatic.http.transaction.conf;

import com.automatic.http.transaction.obj.ClientCommitRequest;
import com.automatic.http.transaction.obj.ClientRequests;
import com.automatic.http.transaction.obj.ClientRollbackRequest;
import com.automatic.http.transaction.obj.ResponseObj;
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

        List<ClientCommitRequest> requests = clientRequests.getCommittedClientRequests();
        for (ClientCommitRequest request : requests) {
            requestManager.request(request);
        }
    }

    @AfterThrowing("@annotation(com.automatic.http.transaction.aop.RestTransactional)")
    public void transactionalThrowing() {   // Transaction type is rollback
        log.info("start request transaction type is rollback ..");

        List<ClientRollbackRequest> requests = clientRequests.getRollbackClientRequests();
        for (ClientRollbackRequest request : requests) {

        }
    }

    public <T> T run() {
        return (T) run(clientRequests.getRollbackRequest().getClazz());
    }

    public <T> T run(Class<T> response) {
        Object obj = new ResponseObj();
        return (T) obj;
    }
}

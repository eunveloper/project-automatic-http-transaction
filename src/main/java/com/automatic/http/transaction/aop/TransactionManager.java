package com.automatic.http.transaction.aop;

import com.automatic.http.transaction.obj.ClientRequests;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class TransactionManager {

    private final ClientRequests clientRequests;

    @Before(("@annotation(com.automatic.http.transaction.aop.RestTransactional)"))
    public void createTransactional() {
        //Long threadId = Thread.currentThread().getId();
        //transaction.put(threadId, true);
    }

    @After(("@annotation(com.automatic.http.transaction.aop.RestTransactional)"))
    public void deleteTransactional() {
        //Long threadId = Thread.currentThread().getId();
        //transaction.remove(threadId);
        //beforeData.remove(threadId);
    }

    @AfterReturning("@annotation(com.automatic.http.transaction.aop.RestTransactional)")
    public void transactionalReturning() {  // update, delete
        /*log.info("keycloak returning request transaction committed ..");
        Long threadId = Thread.currentThread().getId();
        List<KeycloakRestRequestInfo> committedDatas = beforeData.get(threadId);
        for (KeycloakRestRequestInfo committedData : committedDatas) {
            switch (committedData.getMethod()) {
                case UPDATE:
                    committedUpdateTransactional(committedData);
                    break;
                case DELETE:
                    committedDeleteTransactional(committedData);
                    break;
            }
        }*/
    }

    @AfterThrowing("@annotation(com.automatic.http.transaction.aop.RestTransactional)")
    public void transactionalThrowing() {   // create
        /*log.info("keycloak throwing request transaction committed ..");
        Long threadId = Thread.currentThread().getId();
        List<KeycloakRestRequestInfo> committedDatas = beforeData.get(threadId);
        for (KeycloakRestRequestInfo committedData : committedDatas) {
            switch (committedData.getMethod()) {
                case CREATE:    // create 경우에는 uuid 가 필요하기 때문에 exception 시 delete 하도록
                    rollbackCreateTransactional(committedData);
                    break;
            }
        }*/
    }

    /*public T create(Map<Enum, String> fields, T obj) {
        if (obj instanceof UserRepresentation) {
            return (T) createUser(fields);
        }
        if (obj instanceof GroupRepresentation) {
            return (T) createTenant(fields);
        }
    }

    public T add(T obj) {
        if (obj instanceof UserRepresentation) {
            UserRepresentation userRepresentation = (UserRepresentation) obj;
            return (T) addUser(userRepresentation);
        }
        if (obj instanceof GroupRepresentation) {
            GroupRepresentation groupRepresentation = (GroupRepresentation) obj;
            return (T) addTenant(groupRepresentation);
        }
    }

    public T get(T obj) {
        if (obj instanceof UserRepresentation) {
            UserRepresentation userRepresentation = (UserRepresentation) obj;
            return (T) getUser(userRepresentation.getId());
        }
        if (obj instanceof GroupRepresentation) {
            GroupRepresentation groupRepresentation = (GroupRepresentation) obj;
            return (T) getTenant(groupRepresentation.getId());
        }
    }

    public void update(T obj) {
        if (obj instanceof UserRepresentation) {
            UserRepresentation userRepresentation = (UserRepresentation) obj;
            updateUser(userRepresentation.getId(), userRepresentation);
            return;
        }
        if (obj instanceof GroupRepresentation) {
            GroupRepresentation groupRepresentation = (GroupRepresentation) obj;
            updateTenant(groupRepresentation.getId(), groupRepresentation);
            return;
        }
    }

    public void delete(T obj) {
        if (obj instanceof UserRepresentation) {
            UserRepresentation userRepresentation = (UserRepresentation) obj;
            deleteUser(userRepresentation.getId());
            return;
        }
        if (obj instanceof GroupRepresentation) {
            GroupRepresentation groupRepresentation = (GroupRepresentation) obj;
            deleteTenant(groupRepresentation.getId());
            return;
        }
    }*/

}

# Description
웹 어플리케이션을 개발하다보면 각종 데이터베이스와 연동한 CRUD 작업들이 일어나게 됩니다. Spring 에서는 데이터베이스 레벨의 트랜잭션 처리를 위해 @Transactional Annotation을 제공합니다.
최근 많은 서비스 기업은 대용량 트래픽 처리를 위해 MSA 환경을 구성중에 있습니다. MSA 환경이 구성됨에 따라 서비스간 통신이 많아지고, 서비스간 트랜잭션 처리를 위해 매번 예외처리와 분기처리를 해줘야 하는 번거로움이 있습니다.
이에 해당 프로젝트는 동기 HTTP Request의 서버간 트랜잭션 처리를 Annotation 기반으로 간편하게 사용하기 위해 개발되었으며 Srping 에서 제공하는 기본 HTTP Client인 RestTemplate를 사용하여 서버간 트랜잭션 처리를 해줍니다. 이제 사용자는 서버간 통신마다 예외처리와 분기처리를 하는것이 아닌 통신이 필요한 HTTP Reqeust 행위를 설정만 해주면 기능이 정상동작 됐을때 정상적으로 서비스 요청이 이뤄집니다.

<br/>

# Function Release
- 2022.07.20
  - TranscationType.COMMIT HTTP 통신 Transcation 기능 구현


<br/>

# How To Use
- 2022.07.20
``` Java
@Autowired
private ClientRequests clientRequests;

@RestTransactional
clientRequests
    .create()
    .url("http://localhost:8080/api).method(MethodType.POST)
    .header(httpHeader).clazz(Response.class).transaction(TransactionType.COMMIT)
    .add();
```
  - HTTP 통신 Transaction 을 사용하고자 하는 메소드에 @RestTransactional Anootation을 작성합니다.
  - 한 리퀘스트당 N개의 HTTP 요청을 할 수 있으며, create()와 add() 함수를 이용합니다.
  - HTTP 통신에 필요한 각종 파라미터 (url, method, header, claszz 값들을 설정해 줍니다.
  - 메소드가 예외 없이 정상 종료된다면 설정한 HTTP 요청들을 요청합니다.

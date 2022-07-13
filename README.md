# Description
웹 어플리케이션을 개발하다보면 각종 데이터베이스에 연동하여 CRUD 작업들이 일어나게 됩니다. 이에 Spring 에서는 데이터베이스 레벨의 트랜잭션 처리를 위해 @Transactional Annotation을 이용합니다.
로직 성공 여부에 따라 Commit 처리의 여부가 달라집니다.
최근 많은 서비스 기업은 대용량 트래픽 처리를 위해 MSA 환경을 구성중에 있습니다. MSA 환경이 구성됨에 따라 서비스간 통신이 많아지고, 서비스간 트랜잭션 처리를 위해 매번 예외처리와 분기처리를 해줘야 하는 번거로움이 있습니다.
이에 이 프로젝트는 동기 HTTP Request를 기반으로 서버간 트랜잭션 처리를 Annotation 기반으로 간편하게 도와줍니다.

<br/>

# Function Release


<br/>

# How To Use
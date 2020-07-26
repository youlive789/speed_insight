# speed_insight
Web performance checker using Google Lighthouse.

![Speed Insight Design](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F80ce24bb-6371-48ed-8315-e596fa59d931%2Fspeed_insight_design.png?table=block&id=e6bda937-ebca-4c6c-a4aa-9177b6234359&width=3190&cache=v2)

### 1. 사용방법
 1. 프로젝트 빌드
    - ./collector/gradle build -x test
    - ./processor/gradle build -x test
    - ./dashborad/gradle build -x test
 2. docker compose 시작
    - docker-compose up -d
 3. 대쉬보드
    - http://localhost:8702/

### 2. 의존성
 - google lighthouse
 - spring-boot
 - mysql

### 3. 프로젝트 구조
 - **collector** : spring-boot cron을 활용하여 lighthouse data를 json형식으로 생성
 - **processor** : collector에서 생성한 데이터를 db에 입력처리
 - **dashboard** : 수집한 데이터를 dashboard 형태로 표출

### 4. 대쉬보드 화면
 ![대시보드 메인화면](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/12792c05-c08c-48ec-80c0-e3b9ca1b9be7/.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20200726%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20200726T090903Z&X-Amz-Expires=86400&X-Amz-Signature=7ea3884a5cd4e8fda012b3ca41d84b0986c7dc9422b5071a658bc1d529e2495c&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22.jpg%22)

 ![수집URL 추가화면](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/32da28ab-3767-428b-99bf-062351cda64d/URL.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20200726%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20200726T090924Z&X-Amz-Expires=86400&X-Amz-Signature=89a5d8929419ee56c10d81b0289d6d13ebe9311afd4b418613935c29b7dd92bb&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22URL.jpg%22)

### 5. TODO
 - 도커 컨테이너로 전환에 따른 환경설정 및 소스코드 변경필요
  1. application.properties를 동적으로 구성할 수 있는 방법 검토

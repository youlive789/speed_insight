﻿# speed_insight
Web performance checker using Google Lighthouse.

![Speed Insight Design](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F80ce24bb-6371-48ed-8315-e596fa59d931%2Fspeed_insight_design.png?table=block&id=e6bda937-ebca-4c6c-a4aa-9177b6234359&width=3190&cache=v2)

### 1. 사용방법
 1. 프로젝트 빌드
    - ./collector/gradlew build -x test
    - ./processor/gradlew build -x test
    - ./dashborad/gradlew build -x test
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
 ![대시보드 메인화면](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcPjyjy%2FbtqIRNjOJ4x%2FKGCCERuznLzOrxhjTzVtN0%2Fimg.png)

 ![자원 지연시간화면](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbzWZER%2FbtqIVGRKVeL%2F1YWOKhlUpYCuRHunlYjDZ0%2Fimg.png)

 ![수집URL 추가화면](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbnEQKR%2FbtqISviTsh2%2F7beN1JFfbdIVpCyHfMk3z1%2Fimg.png)

### 5. TODO
 - 도커 컨테이너로 전환에 따른 환경설정 및 소스코드 변경필요
  1. application.properties를 동적으로 구성할 수 있는 방법 검토

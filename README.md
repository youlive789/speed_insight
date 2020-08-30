# speed_insight
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
 ![대시보드 메인화면](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6570a272-99a9-4df9-8902-8978762fa0e9/dashboard.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20200830%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20200830T025939Z&X-Amz-Expires=86400&X-Amz-Signature=87a72f46e563f9534b32f19718e79fbc79962150eb9ac6de060dc7c1f15caa70&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22dashboard.png%22)

 ![자원 지연시간화면](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0d981183-7102-41ca-a958-96b56c83bd61/latency.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20200830%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20200830T030012Z&X-Amz-Expires=86400&X-Amz-Signature=2fa662d405c51df4c674d1b2eeab281e71f167664b13fb337b0582ac34ededa0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22latency.png%22)

 ![수집URL 추가화면](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2549dbee-cd47-4836-8e30-51e641d783cb/target.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20200830%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20200830T030022Z&X-Amz-Expires=86400&X-Amz-Signature=1c12867e8f8af0bd8a8944ea7d7eeb4837f9bad16154f4be500be13ed1e57f0e&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22target.png%22)

### 5. TODO
 - 도커 컨테이너로 전환에 따른 환경설정 및 소스코드 변경필요
  1. application.properties를 동적으로 구성할 수 있는 방법 검토

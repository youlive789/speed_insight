# speed_insight
Web performance checker using Google Lighthouse.

![Speed Insight Design](https://www.notion.so/geonwookim/Speed-Insight-a882ac7f3016403f903a1b3e4d891662#e6bda937ebca4c6ca4aa9177b6234359)

### 1. 의존성
 - google lighthouse (현재 윈도우 기준으로 개발되었기 때문에 윈도우 환경에서 nodejs 및 google lighthouse 설치필요)
 - spring-boot
 - mysql

### 2. 프로젝트 구조
 - **collector** : spring-boot cron을 활용하여 lighthouse data를 json형식으로 생성
 - **processor** : collector에서 생성한 데이터를 db에 입력처리
 - **dashboard** : 수집한 데이터를 dashboard 형태로 표출

### 3. TODO
 - 향후 도커 컨테이너 방식으로 관리 효율화
  1. lighthouse, spring-boot, mysql을 모두 도커 컨테이너로 관리
  2. docker-compose를 활용해야 할 지 검토필요
 - 도커 컨테이너로 전환에 따른 환경설정 및 소스코드 변경필요
  1. application.properties를 동적으로 구성할 수 있는 방법 검토
  2. google lighthouse를 설치할 수 있는 배치 스크립트 필요

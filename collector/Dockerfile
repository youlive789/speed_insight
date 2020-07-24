# 1. 라이트하우스 빌드
# 2. data 폴더 마운트

# 빌드 명령어
# docker build --build-arg JAR_FILE=build/libs/*.jar -t collector .

FROM openjdk:16-jdk-alpine3.12

RUN apk add --no-cache nodejs nodejs-npm

ENV CHROME_BIN="/usr/bin/chromium-browser"\
    PUPPETEER_SKIP_CHROMIUM_DOWNLOAD="true"

RUN set -x \
  #&& apk update \
  #&& apk upgrade \

  # Add the packages
  && apk add --no-cache dumb-init curl make gcc g++ linux-headers binutils-gold gnupg libstdc++ nss chromium \
  \
  && npm install puppeteer@0.13.0 \
  \
  # Do some cleanup
  && apk del --no-cache make gcc g++ binutils-gold gnupg libstdc++ \
  && rm -rf /usr/include \
  && rm -rf /var/cache/apk/* /root/.node-gyp /usr/share/man /tmp/* \
  && echo

RUN npm install -g lighthouse
ENV CHROME_PATH=/usr/bin/chromium-browser
ENV LIGHTHOUSE_CHROMIUM_PATH=/usr/bin/chromium-browser

EXPOSE 6222

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
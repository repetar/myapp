FROM openjdk:11

RUN mkdir /usr/src/app/
RUN mkdir /usr/src/app/dependency/

COPY target/request-handler-1.0-SNAPSHOT.jar /usr/src/app/
COPY target/dependency/* /usr/src/app/dependency/

WORKDIR /usr/src/app

CMD bash

FROM openjdk:11

RUN mkdir /usr/src/app/
RUN mkdir /usr/src/app/dependency/

COPY target/traffic-handler-1.0-SNAPSHOT.jar /usr/src/app/
COPY target/dependency/* /usr/src/app/dependency/

WORKDIR /usr/src/app

CMD bash

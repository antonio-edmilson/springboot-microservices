FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/discovery-eureka-0.0.1-SNAPSHOT.jar /app/discovery-eureka.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 9080

CMD java ${ADDITIONAL_OPTS} -jar discovery-eureka.jar --spring.profiles.active=${PROFILE}
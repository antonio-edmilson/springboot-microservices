FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/discovery-eureka*.jar /app/discovery-eureka.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 9093

CMD java ${ADDITIONAL_OPTS} -jar discovery-eureka.jar --spring.profiles.active=${PROFILE}
FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/sale-microservice-0.0.1-SNAPSHOT.jar /app/sale-microservice.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 9091

CMD java ${ADDITIONAL_OPTS} -jar sale-microservice.jar --spring.profiles.active=${PROFILE}
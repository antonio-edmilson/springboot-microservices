FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/salesman-microservice-0.0.1-SNAPSHOT.jar /app/salesman-microservice.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 9092

CMD java ${ADDITIONAL_OPTS} -jar salesman-microservice.jar --spring.profiles.active=${PROFILE}